package com.lihm.xxljobdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {


    public static void main(String[] args) {

//        SpringApplication.run(App.class, args);


        // 1.指定web应用类型为响应式
//        SpringApplication app = new SpringApplication(App.class);
//        app.setWebApplicationType(WebApplicationType.REACTIVE);
//        app.run(args);


//         2.指定web应用类型为响应式
        ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(App.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);


    }
}
