package com.example.basemapperdemo.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 *     user.
 * </p>
 * @author kevin
 * @date 2019/11/21
 */
@Data
@TableName("t_user")
public class User {

    //@TableField("id")
    private String id;

    //@TableField("user_name")
    private String userName;

    //@TableField("login_id")
    private String loginId;

    //@TableField("password")
    private String password;

}
