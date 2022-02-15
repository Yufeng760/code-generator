package com.wpf.generator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @AUTHOR: wangpf2
 * @DATETIME: 2022/02/15 11:43:04
 * @DESCRIPTION:
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/page/")
public class PageController {

    @RequestMapping(value = "index")
    public String index(){
        return "/views/index.html";
    }

}
