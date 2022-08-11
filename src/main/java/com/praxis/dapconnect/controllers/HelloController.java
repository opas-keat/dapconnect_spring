package com.praxis.dapconnect.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/api",produces = "application/json")
    public Object sayHello() {
        return Map.of("success", Boolean.TRUE, "datetime", LocalDateTime.now());
//        return "Swagger Hello World";
    }
}
