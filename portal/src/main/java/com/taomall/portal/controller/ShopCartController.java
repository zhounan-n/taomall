package com.taomall.portal.controller;

import com.taomall.common.entities.TaotaoResult;
import com.taomall.portal.entities.CartItem;
import com.taomall.portal.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhoun on 2018/4/3.
 **/
@Controller
@RequestMapping(value = "/cart")
public class ShopCartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/add/{itemId}")
    public String addCartItem(@PathVariable Long itemId,
                              @RequestParam(defaultValue="1")Integer num,
                              HttpServletRequest request, HttpServletResponse response) {
        TaotaoResult result = cartService.addCartItem(itemId, num, request, response);
        return "redirect:/cart/success.html";
    }

    @RequestMapping("/success")
    public String showSuccess() {
        return "cartSuccess";
    }

    @RequestMapping("/cart")
    public String showCart(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<CartItem> list = cartService.getCartItemList(request, response);
        model.addAttribute("cartList", list);
        return "cart";
    }

    @RequestMapping("/delete/{itemId}")
    public String deleteCartItem(@PathVariable Long itemId, HttpServletRequest request, HttpServletResponse response) {
        cartService.deleteCartItem(itemId, request, response);
        return "redirect:/cart/cart.html";
    }


}
