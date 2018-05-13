package com.leonard.cache.modules.order.repository;

import com.leonard.cache.modules.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

/*
 * 文件名：UserRepository
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-08-18 01:19 PM
 */
public interface OrderRepository extends JpaRepository<Order, String> {

    @Query(value = "SELECT sum(total_order_price) FROM ky_operator_income_statistics WHERE operator_id = '2'",nativeQuery = true)
    Long findOrderCount();
}
