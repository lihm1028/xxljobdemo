package com.lihm.xxljobdemo.controller;

import com.lihm.xxljobdemo.RestResult;
import com.lihm.xxljobdemo.exception.SharedException;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {


    @GetMapping("/test")
    public RestResult<Map> test() {
        HashMap map = new HashMap() {{
            put("id", "test");
            put("name", "hello world !");
        }};
        return RestResult.success(map);
    }


    @GetMapping("/fail")
    public RestResult<Map> fail(@RequestParam(value = "num") int num) {
        HashMap map = new HashMap() {{
            put("id", "test");
            put("name", "hello world !");
        }};
        if (num % 2 == 0) {
            throw new SharedException("数据处理异常");
        }
        return RestResult.success(map);
    }


    @GetMapping("/fail2")
    public RestResult<Map> fail2(@RequestParam(value = "num") int num) {
        HashMap map = new HashMap() {{
            put("id", "test");
            put("name", "hello world !");
        }};
        if (num % 2 == 0) {
            throw new RuntimeException("数据处理异常2");
        }
        return RestResult.success(map);
    }


    @GetMapping("/fail3")
    @SneakyThrows
    public RestResult<Map> fail3(@RequestParam(value = "num") int num) {
        HashMap map = new HashMap() {{
            put("id", "test");
            put("name", "hello world !");
        }};
        if (num % 2 == 0) {
            throw new Exception("数据处理异常2");
        }
        return RestResult.success(map);
    }

}
