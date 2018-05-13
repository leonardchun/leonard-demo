package com.leonard.cache.modules.user.repository;

import com.leonard.cache.modules.user.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * 文件名：UserRepository
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-08-18 01:19 PM
 */
public interface UserRepository extends JpaRepository<Users,Long> {

    List<Users> findByName(String name);

}
