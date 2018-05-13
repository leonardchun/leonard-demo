package com.leonard.cache.modules.user.service.impl;

import com.leonard.cache.modules.user.domain.Users;
import com.leonard.cache.modules.user.repository.UserRepository;
import com.leonard.cache.modules.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 文件名：UserServiceImpl
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-08-18 01:25 PM
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users save(Users users) {
        users.setAge(44);
        users.setName("张三");

        List<Users> users1 = this.userRepository.findByName("wang");

        return this.userRepository.save(users);
    }
}
