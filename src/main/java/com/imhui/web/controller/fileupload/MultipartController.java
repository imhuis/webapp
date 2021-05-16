package com.imhui.web.controller.fileupload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: zyixh
 * @date: 2020/1/28
 * @description:
 */
@Controller
@RequestMapping("/v1/file")
public class MultipartController {

    static final Logger log = LoggerFactory.getLogger(MultipartController.class);

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String,String> upload(@RequestParam("file") MultipartFile file, HttpSession httpSession){
        Map<String,String> map = new HashMap<>();
        if (file.getSize() > 0){
            String path = httpSession.getServletContext().getRealPath("upload");
            log.debug("server real path:{}", path);
            String fileName = file.getOriginalFilename();
            File f = new File(path, fileName);
            try {
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put("info", "upload success");
            map.put("filename",file.getName());
        }else {
            map.put("info", "upload fail");
        }
        return map;
    }
}
