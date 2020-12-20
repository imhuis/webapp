package com.imhui.mvc.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/v1/test/session")
public class SessionController {

    @RequestMapping("add")
    @ResponseBody
    public String put(HttpSession httpSession){
        httpSession.setAttribute("name","hello world");
        return httpSession.getId();
    }
}