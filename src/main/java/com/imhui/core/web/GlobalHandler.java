package com.imhui.core.web;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: zyixh
 * @date: 2021/5/16
 * @description: 全局数据绑定 & 全局数据预处理
 */
//@ControllerAdvice
public class GlobalHandler {

    @InitBinder
    protected void initBinder(WebDataBinder dataBinder){
//        dataBinder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


}
