package com.mondol.mhmh.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello We are mong";
    }
}
