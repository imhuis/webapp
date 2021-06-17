package com.imhui.web.controller.demo;

import com.imhui.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
@Controller
@RequestMapping("/demo/valid")
@Validated
public class ValidController {

    @RequestMapping("/validParameter")
    @ResponseBody
    public String validParameter(@RequestParam String txt){
        return txt;
    }

    @RequestMapping("/validUser")
    @ResponseBody
    public Object validUser(@Valid @RequestBody User user){
        return user;
    }


    @RequestMapping("/validEmail")
    @ResponseBody
    public String validEmail(@NotNull @Email String email){
        return email;
    }
}
