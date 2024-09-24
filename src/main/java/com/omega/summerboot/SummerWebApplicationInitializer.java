package com.omega.summerboot;

import com.omega.summerboot.config.BeanConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Class SummerWebApplicationInitializer
 *
 * @author KennySo
 * @date 2024/9/24
 */
public class SummerWebApplicationInitializer implements WebApplicationInitializer {

    /**
     * onStartup() 方法由 Tomcat 调用, 并把 ServletContext 对象传入
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("startup ...");
        // 1. 创建 Spring 容器 —— 按照注解的方式
        AnnotationConfigWebApplicationContext ioc = new AnnotationConfigWebApplicationContext();
        // 2. 在 Spring 容器中注册 配置类, 读取 ComponentScan 内容
        ioc.register(BeanConfig.class);
        // 3. 完成 Bean 的创建, 并注入到 Spring 容器中
        ioc.refresh();
        // 4. 创建前端控制器 DispatchServlet, 并让其持有 Spring 容器, 这样就可以进行 SpringMVC 的映射分发
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ioc);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", dispatcherServlet);
        // 设置 Tomcat 启动就进行加载
        registration.setLoadOnStartup(1);
        // 设置 拦截请求, 并进行分发处理
        registration.addMapping("/");
    }
}
