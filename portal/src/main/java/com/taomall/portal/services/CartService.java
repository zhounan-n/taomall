package com.taomall.portal.services;


import com.taomall.common.entities.TaotaoResult;
import com.taomall.portal.entities.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface CartService {

	TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}
