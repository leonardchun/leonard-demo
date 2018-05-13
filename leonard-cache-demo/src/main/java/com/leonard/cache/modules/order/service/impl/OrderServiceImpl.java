package com.leonard.cache.modules.order.service.impl;

import com.leonard.cache.modules.order.repository.OrderRepository;
import com.leonard.cache.modules.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/*
 * 文件名：UserServiceImpl
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-08-18 01:25 PM
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public BigDecimal findOrderCount(String userId) {
        return BigDecimal.valueOf(this.orderRepository.findOrderCount());
    }
}
