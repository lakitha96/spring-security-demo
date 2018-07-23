package com.example.security.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lakitha
 */
@RestController
public class DemoController {

    @GetMapping(value = "/")
    public String Hello(){
        return "Hello World...";
    }


    @GetMapping(value = "/protectedByAdminRole")
    public String helloAdmin(){
        return "Hello Admin...";
    }

}
