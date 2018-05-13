package com.leonard.cache.modules.webservice.service;

import com.leonard.cache.modules.webservice.domain.TrafficViolation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

/*
 * 文件名：ITrafficViolationService
 * 描述：〈交通违章webservice接口〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:10 .
 */
@WebService
public interface ITrafficViolationService {

    @WebMethod
    List<TrafficViolation> findTrafficViolation(@WebParam(name = "carNumber") String carNumber);
}
