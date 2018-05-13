package com.leonard.esb.modules.webservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/*
 * 文件名：IdentityInformation
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 2:10 .
 */
@Data
@Entity
@Table(name = "identity")
public class IdentityInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 姓名
     */
    private String identityName;
    /**
     * 身份证编号
     */
    private String identityCode;
    /**
     * 签发机关
     */
    private String issuingAuthority;
    /**
     *照片存放路径
     */
    private String imageUrl;
    /**
     *住址
     */
    private String address;
}
