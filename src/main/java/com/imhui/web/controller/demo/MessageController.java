package com.imhui.web.controller.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
@RequestMapping("/demo/i18n")
@ResponseBody
public class MessageController {

    private MessageSource messageSource;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping("/hello")
    public String showHello(Locale locale){
        String helloMessage = messageSource.getMessage("hello_message",null, locale);
        return helloMessage;
    }

    @RequestMapping("/message")
    public String showMessage(String message, Locale locale){
        String sourceMessage = messageSource.getMessage(message,null, locale);
        return sourceMessage;
    }
}
