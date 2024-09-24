package com.omega.summerboot.config;

import com.omega.summerboot.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class BeanConfig
 *
 * @author KennySo
 * @date 2024/9/24
 */
@Configuration
@ComponentScan("com.omega.summerboot")
public class BeanConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
