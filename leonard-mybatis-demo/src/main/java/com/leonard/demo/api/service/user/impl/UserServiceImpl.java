package com.leonard.demo.api.service.user.impl;


import com.leonard.demo.api.mapper.UserMapper;
import com.leonard.demo.api.model.User;
import com.leonard.demo.api.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(User user) {
        user.setPassword("123456");
        user.setUserName("12345666666");
        user.setPhone("123456666666");
        return userMapper.insertSelective(user);
    }
}
