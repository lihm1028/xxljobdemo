package com.lihm.xxljobdemo.controller;

import com.lihm.xxljobdemo.service.PersonHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.annotation.Resource;

@Configuration
public class PersonRouter {


    @Resource
    private PersonHandler personHandler;


    /**
     * 新增
     * curl -XPOST -H 'content-type:application/json' http://localhost:18080/person/create -d'{"id":"1","age":32,"name":"lihongming"}' -i
     *
     *
     *
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> personRouters() {
        return RouterFunctions.route()
                .GET("/person/{id}", RequestPredicates.accept(MediaType.APPLICATION_JSON), personHandler::getPerson)
                .GET("/persons", RequestPredicates.accept(MediaType.APPLICATION_JSON), personHandler::getAllPerson)
                .POST("/person/createPerson", personHandler::createPerson)
                .POST("/person/create",RequestPredicates.accept(MediaType.APPLICATION_JSON), personHandler::create)
                .build();
    }

}
