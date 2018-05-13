package com.leonard.cache.modules.order.service;


import java.math.BigDecimal;

/*
 * 文件名：IUserService
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-08-18 01:25 PM
 */
public interface IOrderService {

    public BigDecimal findOrderCount(String userId);


}
