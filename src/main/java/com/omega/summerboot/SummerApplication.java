package com.omega.summerboot;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Class SummerApplication
 *
 * @author KennySo
 * @date 2024/9/24
 */
public class SummerApplication {

    public static void run() {
        try {
            // 创建 Tomcat
            Tomcat tomcat = new Tomcat();
            // 设置 端口号
            tomcat.setPort(9090);
            // 将 Tomcat 和 Spring web 容器进行关联
            // (1) 设置 ContextPath
            // (2) 指定 Spring web 项目的位置
            tomcat.addWebapp("/SummerBoot", "C:\\WorkSpace\\Practice\\JavaCode\\SummerBoot");
            // 启动 Tomcat
            tomcat.start();
            // 等待请求接入
            System.out.println("====== 9090 端口等待请求 ======");
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }
    }
}
