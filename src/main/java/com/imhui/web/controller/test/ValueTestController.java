package com.imhui.web.controller.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ValueTestController {

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String getUser(){
        return username + ":" + password;
    }
}
