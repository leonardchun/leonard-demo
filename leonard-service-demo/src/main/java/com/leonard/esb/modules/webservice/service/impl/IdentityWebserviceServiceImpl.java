package com.leonard.esb.modules.webservice.service.impl;

import com.leonard.esb.modules.webservice.domain.IdentityInformation;
import com.leonard.esb.modules.webservice.repository.IdentityRepository;
import com.leonard.esb.modules.webservice.service.IdentityWebserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 文件名：IdentityWebserviceServiceImpl
 * 描述：〈身份信息webservice接口〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 11:04 .
 */
@Service
public class IdentityWebserviceServiceImpl implements IdentityWebserviceService {

    @Autowired
    private IdentityRepository identityRepository;

    @Override
    public List<IdentityInformation> findIdentitys() {
        List<IdentityInformation> identities = this.identityRepository.findAll();
        return identities;
    }

    @Override
    public IdentityInformation getIdentity(String identityName) {
        IdentityInformation identityInformation = this.identityRepository.findByIdentityName(identityName);
        return identityInformation;
    }
}
