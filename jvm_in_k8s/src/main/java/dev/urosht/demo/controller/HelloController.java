package dev.urosht.demo.controller;

import dev.urosht.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private HelloService service;

    public HelloController(HelloService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return service.hello();
    }

    @GetMapping("/count")
    public int count() {
        return service.count();
    }
}
