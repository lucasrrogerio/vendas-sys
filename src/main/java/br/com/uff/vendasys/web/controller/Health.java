package br.com.uff.vendasys.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class Health {

    @GetMapping("health")
    @ResponseBody
    public Map<String, String> health() {
        return Collections.singletonMap("message", "up!");
    }
    
}
