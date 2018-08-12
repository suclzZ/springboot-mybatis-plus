package com.sucl.smp.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("USER")
public class User extends Model<User> {

    @TableId(value = "id",type=IdType.AUTO)
    private Integer id;
    @TableField(value = "USERNAME")
    private String username;
    @TableField(value = "PASSWORD")
    private String password;
    @TableField(value = "CAPTION")
    private String caption;
    @TableField(value = "AGE")
    private int age;
    @TableField(value = "PHONE")
    private String phone;
    @TableField(value = "EMAIL")
    private String email;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
