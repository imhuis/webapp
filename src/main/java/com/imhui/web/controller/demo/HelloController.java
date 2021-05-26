package com.imhui.web.controller.demo;

import com.imhui.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
@Controller
@RequestMapping("/v1/test")
public class HelloController {

    private ServiceImpl serviceImpl;

    @Autowired
    private ApplicationContext applicationContext;

    @Lookup
    public ServiceImpl getServiceImpl(){
//        return applicationContext.getBean(ServiceImpl.class);
        return null;
    }

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

    @RequestMapping(path = "/hii", method = RequestMethod.GET)
    @ResponseBody
    public String hiService(){
        return "helloworld, service is : " + getServiceImpl();
    }
    
}
