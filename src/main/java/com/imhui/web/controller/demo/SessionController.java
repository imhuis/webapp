package com.imhui.web.controller.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
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
