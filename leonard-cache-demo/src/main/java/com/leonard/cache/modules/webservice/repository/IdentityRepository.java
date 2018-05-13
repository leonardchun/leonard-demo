package com.leonard.cache.modules.webservice.repository;

import com.leonard.cache.modules.webservice.domain.IdentityInformation;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 文件名：RestRepository
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:08 .
 */
public interface IdentityRepository extends JpaRepository<IdentityInformation,Long> {

    /**
     * 通过身份证ID查询身份信息
     * @param identityName
     * @return
     */
    IdentityInformation findByIdentityName(String identityName);
}
