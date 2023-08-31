package com.example.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    // 使用@Value读取单个数据
    @Value("${server.port}")
    private int port;

    @Value("${lesson}")
    private String lesson;

    @Value("${enterprise.subjects[1]}")
    private String[] subject_01;

    @Autowired
    private Environment env;

    @GetMapping("/{id}")
    public String hello(@PathVariable("id") Long id) {
        System.out.println("port ==> " + port);
        System.out.println("lesson ==> " + lesson);
        System.out.println("subject_01 ==> " + subject_01[0]);
        System.out.println("env.enterprise.name ==> " + env.getProperty("enterprise.name"));
        System.out.println("id ==> " + id);
        return "hello , spring boot! ";
    }
}
