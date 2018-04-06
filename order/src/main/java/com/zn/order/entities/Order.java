package com.zn.order.entities;

import com.taomall.entities.TbOrder;
import com.taomall.entities.TbOrderItem;
import com.taomall.entities.TbOrderShipping;

import java.util.List;

/**
 * Created by zhoun on 2018/4/6.
 **/
public class Order extends TbOrder{

    private List<TbOrderItem> orderItems;
    private TbOrderShipping orderShipping;
    public List<TbOrderItem> getOrderItems() {
        return orderItems;
    }
    public void setOrderItems(List<TbOrderItem> orderItems) {
        this.orderItems = orderItems;
    }
    public TbOrderShipping getOrderShipping() {
        return orderShipping;
    }
    public void setOrderShipping(TbOrderShipping orderShipping) {
        this.orderShipping = orderShipping;
    }


}
