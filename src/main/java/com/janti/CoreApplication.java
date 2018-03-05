package com.janti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author janti
 * @date 2018/3/4 20:54
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class CoreApplication {
    public static void main(String[] args){
        SpringApplication application = new SpringApplication(CoreApplication.class);
        application.run(args);
    }
}
