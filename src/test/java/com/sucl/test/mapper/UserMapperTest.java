package com.sucl.test.mapper;

import com.sucl.smp.mapper.UserMapper;
import com.sucl.smp.model.User;
import com.sucl.test.BasicTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserMapperTest extends BasicTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        //BaseMapper
        User user = userMapper.selectById(1);
        System.out.println("user : "+user);
        //ActiveRecord
        List<User> users = user.selectAll();
        System.out.println("users : "+users);
        //mapper.xml 不能同时使用
//        users = userMapper.getAllUsers();
//        System.out.println("users :" +users);
    }

    @Before
    public void before(){
        System.out.println("before");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeclass");
    }
}
