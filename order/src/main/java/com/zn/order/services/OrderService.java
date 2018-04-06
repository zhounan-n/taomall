package com.zn.order.services;

import com.taomall.common.entities.TaotaoResult;
import com.taomall.entities.TbOrder;
import com.taomall.entities.TbOrderItem;
import com.taomall.entities.TbOrderShipping;

import java.util.List;

/**
 * Created by zhoun on 2018/4/6.
 **/
public interface OrderService {

    TaotaoResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);

}
