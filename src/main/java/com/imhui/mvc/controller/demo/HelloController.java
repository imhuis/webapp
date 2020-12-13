package com.imhui.mvc.controller.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/v1/test")
public class HelloController {

    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "Hello World!";
    }

    /**
     * request URL后缀（eg. xml,json）默认开启
     * request URL参数（eg. ?format=json）默认关闭
     * request HEADER中的Accept参数 默认开启
     *
     * produces={“MediaType.APPLICATION_ATOM_XML_VALUE”}
     *
     * @return
     */
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> hi(){
        Map<String,Object> map = new HashMap<>();
        map.put("A","a");
        map.put("B","b");
        map.put("text","小阳");
        return map;
    }

    
}
