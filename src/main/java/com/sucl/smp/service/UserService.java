package com.sucl.smp.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.sucl.smp.mapper.UserMapper;
import com.sucl.smp.model.User;
import com.sucl.smp.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User get(Integer id){
        return userMapper.selectById(id);
    }

    public List<User> getAll(User user){
        Map<String, Object> map = EntityUtils.EntityToMap(user);
        return userMapper.selectByMap(map);
    }

    public List<User> getPager(User user){
        return userMapper.selectPage(new Page<User>(1,10),null);
    }

    public void save(User user){
        userMapper.insert(user);
    }

    public void update(User user){
        userMapper.updateById(user);
    }

    public void delete(Integer id){
        userMapper.deleteById(id);
    }

}
