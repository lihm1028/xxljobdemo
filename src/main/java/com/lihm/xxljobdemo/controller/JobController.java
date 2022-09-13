package com.lihm.xxljobdemo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lihm.xxljobdemo.RestResult;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
public class JobController {

    @GetMapping("/job/getUser")
    @SneakyThrows
    public RestResult<Map> get() {
        HashMap map = new HashMap() {{
            put("id", UUID.randomUUID().toString().replace("-", ""));
            put("name", "hello world !");
        }};
        String valueAsString = new ObjectMapper().writeValueAsString(map);
        log.info("获取用户信息:{}", valueAsString);
        return RestResult.success(map);
    }


    @PostMapping("/job/addUser")
    @SneakyThrows
    public RestResult<Map> addUser(@RequestBody(required = false) Map<String, String> reqMap) {
        String valueAsString = new ObjectMapper().writeValueAsString(reqMap);
        log.info("新增用户信息:{}", valueAsString);
        return RestResult.success(reqMap);
    }
}
