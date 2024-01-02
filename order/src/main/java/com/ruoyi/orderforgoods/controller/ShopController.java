package com.ruoyi.orderforgoods.controller;

import com.ruoyi.orderforgoods.domain.Shop;
import com.ruoyi.orderforgoods.service.impl.ShopServiceImpl;
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
public class ShopController {

    @Autowired
    private ShopServiceImpl shopService;

    @GetMapping("/list")
    public ResponseEntity<List<Shop>> getAllShops() {
        Shop shop = new Shop();
        List<Shop> shops = shopService.selectShopList(shop);
        for (Shop shop1 : shops) {
            System.out.println(shop1);
        }
        return ResponseEntity.ok(shops);
    }
}