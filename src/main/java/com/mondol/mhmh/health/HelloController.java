package com.mondol.mhmh.health;

import com.mondol.mhmh.auth.principal.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello We are mong";
    }


    @GetMapping("/hello/token")
    public String helloToken(@AuthenticationPrincipal PrincipalDetail userDetails) {
        return "정상적인 토큰";
    }
}
