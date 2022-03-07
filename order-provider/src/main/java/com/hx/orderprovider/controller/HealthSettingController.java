package com.hx.orderprovider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthSettingController {



    @RequestMapping("/health/{status}")
    public String up(@PathVariable("status") Boolean status) {


        return "helllllll";
    }

}