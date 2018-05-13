package com.leonard.esb.modules.webservice.service.impl;

import com.leonard.esb.modules.webservice.domain.TrafficViolation;
import com.leonard.esb.modules.webservice.repository.TrafficViolationRepository;
import com.leonard.esb.modules.webservice.service.ITrafficViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 文件名：WebserviceServiceImpl
 * 描述：〈交通违章webservice接口〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:10 .
 */
@Service
public class TrafficViolationServiceImpl implements ITrafficViolationService {

    @Autowired
    private TrafficViolationRepository trafficViolationRepository;

    /**
     * 查找违章信息列表
     *
     * @param carNumber
     * @return
     */
    @Override
    public List<TrafficViolation> findTrafficViolation(String carNumber) {
        if ("".equals(carNumber)){
            List<TrafficViolation> trafficViolations = this.trafficViolationRepository.findAll();
            return trafficViolations;
        }else {
            List<TrafficViolation> trafficViolationList =this.trafficViolationRepository.findByCarNumber(carNumber);
            return trafficViolationList;
        }


    }
}
