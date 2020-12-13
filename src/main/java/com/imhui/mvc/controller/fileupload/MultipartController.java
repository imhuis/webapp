package com.imhui.mvc.controller.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/file")
public class MultipartController {

    @RequestMapping("/upload")
    public String upload(){
        return "";
    }
}
