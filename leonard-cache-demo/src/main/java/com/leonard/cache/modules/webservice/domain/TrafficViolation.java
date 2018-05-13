package com.leonard.cache.modules.webservice.domain;

import lombok.Data;

import javax.persistence.*;

/*
 * 文件名：TrafficViolation
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/22 23:24 .
 */
@Data
@Entity
@Table(name = "traffic_violation")
public class TrafficViolation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 车牌号码
     */
    private String carNumber;
    /**
     * 发动机号
     */
    private String engineNumber;
    /**
     * 违章行为
     */
    private String illegality;
    /**
     * 违章地点
     */
    private String place;
    /**
     * 违章时间
     */
    private String time;
    /**
     * 罚款金额
     */
    private String fineAmount;
    /**
     * 扣分
     */
    private String deductMarks;
    /**
     * 所属省
     */
    private String province;
    /**
     * 所属市
     */
    private String city;
}
