package com.imhui.mvc.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Email;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
@Controller
@RequestMapping("/v1/valid")
@Validated
public class ValidController {


    @RequestMapping("/validEmail")
    @ResponseBody
    public String validEmail(@Email String email){
        return email;
    }
}
