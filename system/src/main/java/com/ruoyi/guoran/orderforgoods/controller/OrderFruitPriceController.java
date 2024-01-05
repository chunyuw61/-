package com.ruoyi.guoran.orderforgoods.controller;


import com.ruoyi.guoran.orderforgoods.service.impl.OrderShoppriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 15:48
 */
@RestController
@RequestMapping("/fruitPrice")
public class OrderFruitPriceController {

    @Autowired
    private OrderShoppriceServiceImpl orderShoppriceService;

    @GetMapping("/getPriceByCode")
    public Double getPriceByCode(@RequestParam String code, @RequestParam String sNumber) {
        return orderShoppriceService.selectPriceBySNumberAndCode(sNumber, code);
    }
}