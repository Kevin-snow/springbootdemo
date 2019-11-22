package com.example.springbootshirodemo.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录Controller.
 */
@Controller
public class LoginController {

    /**
     *
     * @param request
     * @return
     */
    @GetMapping("/login")
    public String index(HttpServletRequest request){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/index";
        }
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody String param){
        JSONObject jsonObject = JSONObject.parseObject(param);
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(jsonObject.getString("username"),
                    jsonObject.getString("password"));
            token.setRememberMe(true);
            try {
                subject.login(token);
            } catch (AuthenticationException e) {
                System.out.println("登录失败");
                e.printStackTrace();
            }
        }
        return "index";
    }


}
