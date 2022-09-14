package com.lihm.xxljobdemo.repository;

import com.lihm.xxljobdemo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

    Person findByName(String name);
}
