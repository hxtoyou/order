package com.hx.orderweb.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {



    @RequestMapping("demo")
    public String demo() {


        return "2121212";
    }

}