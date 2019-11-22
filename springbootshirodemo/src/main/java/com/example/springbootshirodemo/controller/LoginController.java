package com.example.springbootshirodemo.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录Controller.
 * @author kevin
 * @date 2019/11/22
 */
@Controller
public class LoginController {

    /**
     * 登录页面
     * @return string
     */
    @GetMapping("/login")
    public String index(){
        if (SecurityUtils.getSubject().isAuthenticated()){
            return "redirect:/index";
        }
        return "login";
    }

    /**
     * <p>
     *     登录
     * </p>
     * @param param 参数
     * @return 登录成功页面
     */
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
