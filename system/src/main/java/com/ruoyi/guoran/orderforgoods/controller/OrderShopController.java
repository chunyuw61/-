package com.ruoyi.guoran.orderforgoods.controller;


import com.ruoyi.guoran.orderforgoods.domain.OrderShop;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/29 15:17
 */
@RestController
@RequestMapping("/shop")
public class OrderShopController {

    @Autowired
    private OrderShopServiceImpl shopService;

    @GetMapping("/list1")
    public ResponseEntity<List<OrderShop>> getAllShops() {
        OrderShop shop = new OrderShop();

        List<OrderShop> shops = shopService.selectShopList(shop);
        for (OrderShop shop1 : shops) {
            System.out.println(shop1);
        }
        return ResponseEntity.ok(shops);
    }
}