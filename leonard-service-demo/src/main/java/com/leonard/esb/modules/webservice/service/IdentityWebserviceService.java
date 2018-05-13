package com.leonard.esb.modules.webservice.service;

import com.leonard.esb.modules.webservice.domain.IdentityInformation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/*
 * 文件名：IdentityWebserviceService
 * 描述：〈身份信息webservice接口〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 11:03 .
 */
@WebService
public interface IdentityWebserviceService {

    @WebMethod
    List<IdentityInformation> findIdentitys();

    @WebMethod
    IdentityInformation getIdentity(@WebParam(name = "identityName")String identityName);
}
