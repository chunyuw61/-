package com.ruoyi.guoran.orderforgoods.controller;


import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.guoran.orderforgoods.domain.OrderShop;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

        SysUser user = ShiroUtils.getSysUser();
        //用户名
        user.getLoginName();
        System.out.println(user);
/*        OrderShop shop = new OrderShop();
        List<OrderShop> shops = shopService.selectShopList(shop);
        for (OrderShop shop1 : shops) {
            System.out.println(shop1);
        }*/
        //货研发部门信息
        SysDept dept = user.getDept();
        System.out.println(dept);
        OrderShop shop = new OrderShop();
        shop.setsNumber(dept.getDeptId().toString());
        shop.setsName(dept.getDeptName());
        List<OrderShop> shops = new ArrayList<>();
        shops.add(shop);
        return ResponseEntity.ok(shops);
    }
}