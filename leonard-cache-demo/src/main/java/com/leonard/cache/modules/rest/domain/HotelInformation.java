package com.leonard.cache.modules.rest.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
 * 文件名：HotelInformation
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:24 .
 */
@Data
@Entity
@Table(name = "hotel_information")
public class HotelInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 住宿人姓名
     */
    private String name;
    /**
     * 身份证编号
     */
    private String resCode;
    /**
     * 入住开始时间
     */
    private Date startTime;
    /**
     * 旅店名称
     */
    private String hotelName;
    /**
     * 房间号
     */
    private String roomCode;
    /**
     * 结束时间
     */
    private String overTime;
    /**
     * 同住人员
     */
    private String cohabit;
    /**
     * 地址
     */
    private String address;
}
