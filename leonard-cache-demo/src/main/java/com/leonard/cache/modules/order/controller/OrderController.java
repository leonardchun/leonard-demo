package com.leonard.cache.modules.order.controller;

import com.leonard.cache.modules.order.service.IOrderService;
import com.leonard.cache.modules.user.domain.Users;
import com.leonard.cache.modules.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@Api(value = "订单管理", description = "订单管理")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/findOrderCount", method = RequestMethod.GET)
    @ApiOperation(value = "查询订单的统计做缓存击穿测试", notes = "查询订单的统计做缓存击穿测试")
    @ResponseBody
    public BigDecimal findOrderCount(@RequestParam("userId") String userId) {
        BigDecimal bigDecimal = this.orderService.findOrderCount(userId);
        return bigDecimal;
    }
}
