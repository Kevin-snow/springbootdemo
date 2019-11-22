package com.example.springbootshirodemo;

import com.example.springbootshirodemo.pojo.User;
import com.example.springbootshirodemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SpringbootshirodemoApplicationTests {

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {

        User user = userService.getUser("zhangsan");

        Assert.notNull(user,"不为空");
    }

}
