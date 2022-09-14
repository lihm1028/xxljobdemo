package com.lihm.xxljobdemo.service;

import com.lihm.xxljobdemo.model.Person;
import com.lihm.xxljobdemo.repository.PersonRepository;
import org.apache.commons.lang3.Validate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class PersonHandler {

    @Resource
    private PersonRepository personRepository;


    /**
     * 创建对象1
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> createPerson(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);

        Mono<ServerResponse> flatMap = person.flatMap(p -> {
            Person save = personRepository.save(p);
            return ok().contentType(MediaType.APPLICATION_JSON).bodyValue(save);
        });
        return flatMap;
    }

    /**
     * 创建对象2
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<Person> person = request.bodyToMono(Person.class);
        Mono<ServerResponse> flatMap = person.flatMap(p -> {
            Validate.notBlank(p.getId(), "id不能为空");
            return ok().contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(personRepository.save(p));
        });
        return flatMap;
    }


    /**
     * 获取一个
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> getPerson(ServerRequest request) {
        String id = request.pathVariable("id");
        Person person = personRepository.findById(id)
                .orElse(null);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(person)
                .switchIfEmpty(ServerResponse.notFound().build());

    }


    /**
     * 获取所有人员
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> getAllPerson(ServerRequest request) {

        List<Person> all = personRepository.findAll();
        Flux<Person> persons = Flux.fromIterable(all);
        Mono<ServerResponse> body = ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(persons, Person.class);
        return body;
    }


}
