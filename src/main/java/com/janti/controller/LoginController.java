package com.janti.controller;

import com.janti.domain.bo.RestResponseBo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tangj
 * @date 2018/3/4 21:04
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping(value = "doLogin")
    @ResponseBody
    public RestResponseBo doLogin(@RequestParam String username,
                                  @RequestParam String password,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {
        try{

        }catch (Exception e){
            return RestResponseBo.fail("登录失败");
        }
        return RestResponseBo.ok();
    }

}
