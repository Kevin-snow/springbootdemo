package com.example.basemapperdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.basemapperdemo.mapper.UserMapper;
import com.example.basemapperdemo.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class BasemapperdemoApplicationTests {

    private UserMapper userMapper;

    @Resource
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * <p>
     *     获取一个.
     * </p>
     */
    @Test
    void selectOne() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("user_name","黄宏");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    /**
     * <p>
     *     按照主键获取
     * </p>
     */
    @Test
    void selectById(){
       User user =  userMapper.selectById("db7e7bed-99da-4267-9428-a4707b110e8c");
        System.out.println(user);
    }

    /**
     * <p>
     *     按照编号批量获取
     * </p>
     */
    @Test
    void selectByBatchId(){
        String[] ids = {"30b512e4-7196-4736-8f4e-ea472f4f475f","db7e7bed-99da-4267-9428-a4707b110e8c","fd8b2b74-13a6-456b-bf48-04bae5560e11"};
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(ids));
        Assert.assertEquals(3,userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * <p>
     *     参数为map的查询方式
     * </p>
     */
    @Test
    void selectByMap(){
        Map<String, Object> param = new HashMap<>();
        param.put("user_name","尼古拉斯赵四");
        param.put("login_id","zhaosi");
        List<User> users = userMapper.selectByMap(param);
        users.forEach(System.out::println);
    }

    /**
     *
     */
    @Test
    void selectCount(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.ge("user_name","小明");
        int count = userMapper.selectCount(qw);
        Assert.assertEquals(1,count);
    }

    /**
     * <p>
     *     获取集合.
     * </p>
     */
    @Test
    void selectList(){
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }



}
