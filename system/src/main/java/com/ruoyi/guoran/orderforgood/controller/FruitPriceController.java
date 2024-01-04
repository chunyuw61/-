package com.ruoyi.guoran.orderforgood.controller;

import com.ruoyi.guoran.orderforgood.service.impl.FruitPriceServiceImpl;
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
public class FruitPriceController {
    @Autowired
    private FruitPriceServiceImpl fruitPriceService;

    @GetMapping("/getPriceByCode")
    public Double getPriceByCode(@RequestParam String code) {
        return fruitPriceService.getPriceByCode(code);

    }
}