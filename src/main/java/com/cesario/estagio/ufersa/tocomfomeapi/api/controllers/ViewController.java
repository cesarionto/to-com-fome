package com.cesario.estagio.ufersa.tocomfomeapi.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
