package com.zn.order.controller;

import com.taomall.common.entities.TaotaoResult;
import com.taomall.common.utils.ExceptionUtil;
import com.zn.order.entities.Order;
import com.zn.order.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单
 * Created by zhoun on 2018/4/6.
 **/
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value="/create", method= RequestMethod.POST)
    @ResponseBody
    public TaotaoResult createOrder(@RequestBody Order order) {
        try {
            TaotaoResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
    }


}
