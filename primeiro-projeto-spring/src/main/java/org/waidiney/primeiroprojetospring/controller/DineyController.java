package org.waidiney.primeiroprojetospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/waidiney")
public class DineyController {
    @GetMapping
    public String hello() {
        String saudacao="<h1>Hello</h1>";
        return saudacao;
    }
}
