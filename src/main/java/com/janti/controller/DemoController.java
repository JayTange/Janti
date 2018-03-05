package com.janti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangj
 * @date 2018/3/5 22:08
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("")
    public String helloHtml(Model model){
        model.addAttribute("name","janti");
        return "hello";
    }
}
