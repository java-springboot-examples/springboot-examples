package springboot.examples.keycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "Hello";
    }

    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "Hello World";
    }
}
