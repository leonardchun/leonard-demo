package com.leonard.cache.modules.order.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ky_operator_income_statistics")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private Long totalOrderPrice;
    private Integer operatorId;
    private String address;
    private String idCard;
    private String images;
}
