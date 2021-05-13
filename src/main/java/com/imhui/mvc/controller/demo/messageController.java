package com.imhui.mvc.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
@Controller
@RequestMapping("/v1/i18n")
public class messageController {

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping("/locale")
    @ResponseBody
    public String showMessage(Locale locale){
        String name = messageSource.getMessage("name",null, locale);
        return "hello " + name;
    }
}
