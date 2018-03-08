package com.janti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangj
 * @date 2018/3/4 21:04
 */
@Controller
@RequestMapping("/login")
public class IndexController {
    @GetMapping("")
    public String index(){
        return "login";
    }
}
