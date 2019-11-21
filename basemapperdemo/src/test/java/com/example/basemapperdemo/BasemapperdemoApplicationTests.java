package com.example.basemapperdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.basemapperdemo.mapper.UserMapper;
import com.example.basemapperdemo.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

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
     * <p>
     *     根据 Wrapper 条件，查询总记录数
     * </p>
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
     *     根据 Wrapper 条件，查询全部记录
     * </p>
     */
    @Test
    void selectMap(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.ge("user_name","小明");
        List<Map<String,Object>>  maps = userMapper.selectMaps(qw);
        maps.forEach(System.out::println);
    }

    /**
     * <p>
     *    注意： 只返回第一个字段的值
     * </p>
     */
    @Test
    void selectObject(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.ge("user_name","小明");
        Object obj = userMapper.selectObjs(qw);
        System.out.println(obj);
    }

    /**
     * <p>
     *     根据 Wrapper 条件，查询全部记录（并翻页）
     *     翻页查询一
     * </p>
     */
    @Test
    void selectPage(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.ge("user_name","小明");
        Page<User> page = new Page<>(1,2);
        IPage<User> mapIPage = userMapper.selectPage(page,qw);
        System.out.println("总记录数：" + mapIPage.getTotal());
        System.out.println("总页数：" + mapIPage.getPages());

        List<User> userList = mapIPage.getRecords();
        userList.forEach(System.out::println);
    }

    /**
     * <p>
     *     根据 Wrapper 条件，查询全部记录（并翻页）
     *     翻页查询二
     * </p>
     */
    @Test
    void selectMapsPage(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.ge("user_name","小明");
        Page<User> page = new Page<>(1,2);
        IPage<Map<String,Object>> mapIPage = userMapper.selectMapsPage(page,qw);
        System.out.println("总记录数：" + mapIPage.getTotal());
        System.out.println("总页数：" + mapIPage.getPages());

        List<Map<String,Object>> userList = mapIPage.getRecords();
        userList.forEach(System.out::println);
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

    /**
     * <p>
     *     插入一条记录
     * </p>
     */
    @Test
    void insert(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setLoginId("zhangsan");
        user.setPassword("123");
        user.setUserName("张三");
        int count = userMapper.insert(user);
        Assert.assertEquals(1,count);
    }

    /**
     * <p>
     *     更新一条记录
     * </p>
     */
    @Test
    void updateById(){
        User user = new User();
        user.setId("30b512e4-7196-4736-8f4e-ea472f4f475f");
        user.setLoginId("lisi");
        user.setPassword("123123");
        user.setUserName("王五");
        int count = userMapper.updateById(user);
        Assert.assertEquals(1,count);
    }

    /**
     * <p>
     *     更新一条记录
     * </p>
     */
    @Test
    void update(){
        User user = new User();
        user.setLoginId("bajie");
        user.setPassword("2627323");
        user.setUserName("八戒");
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("id","db7e7bed-99da-4267-9428-a4707b110e8c");
        int count = userMapper.update(user,qw);
        Assert.assertEquals(1,count);
    }

    /**
     * <p>
     *     删除记录
     * </p>
     */
    @Test
    void delete(){
        QueryWrapper<User> wq = new QueryWrapper<>();
        wq.eq("id","db7e7bed-99da-4267-9428-a4707b110e8c");
        int count = userMapper.delete(wq);
        Assert.assertEquals(1,count);
    }

    /**
     * <p>
     *     删除记录
     * </p>
     */
    @Test
    void deleteById(){
        int count = userMapper.deleteById("30b512e4-7196-4736-8f4e-ea472f4f475f");
        Assert.assertEquals(1,count);
    }


}
