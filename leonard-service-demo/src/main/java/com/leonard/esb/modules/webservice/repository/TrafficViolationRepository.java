package com.leonard.esb.modules.webservice.repository;

import com.leonard.esb.modules.webservice.domain.TrafficViolation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * 文件名：RestRepository
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:08 .
 */
public interface TrafficViolationRepository extends JpaRepository<TrafficViolation,Long> {

    /**
     * 通过车牌号查询车辆信息
     * @param carNumber
     * @return
     */
    List<TrafficViolation> findByCarNumber(String carNumber);
}
