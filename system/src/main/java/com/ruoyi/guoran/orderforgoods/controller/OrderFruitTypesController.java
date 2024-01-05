package com.ruoyi.guoran.orderforgoods.controller;


import com.ruoyi.guoran.orderforgoods.domain.OrderFruittypes;
import com.ruoyi.guoran.orderforgoods.domain.OrderStoreinventory;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderFruittypesServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderStoreinventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/25 19:52
 */

@CrossOrigin
@RestController
@RequestMapping("/FruitTypes")
public class OrderFruitTypesController {
    @Autowired
    private OrderFruittypesServiceImpl fruittypesService;
    @Autowired
    private OrderStoreinventoryServiceImpl storeinventoryService;

    @RequestMapping("/inquireAll")
    public ResponseEntity<List<OrderFruittypes>> inquireAll(@RequestParam("shopId") String shopId) {
        OrderStoreinventory storeinventory = new OrderStoreinventory();
        storeinventory.setShopId(shopId);
        List<OrderFruittypes> fruittypes = new ArrayList<>();
        //根据店名查找所有信息
        for (OrderStoreinventory storeinventory1 : storeinventoryService.selectStoreinventoryList(storeinventory)) {
            //拿到水果id
            OrderFruittypes fs = new OrderFruittypes();
            fs.setCode(storeinventory1.getFruittypesId());
            //根据id查询水果名字
            List<OrderFruittypes> fruittypesList = fruittypesService.selectFruittypesList(fs);
            for (OrderFruittypes fruittypes1 : fruittypesList) {
                //添加计数器判断是否有重复
                int sum = 0;
                for (OrderFruittypes fruittype : fruittypes) {
                    if (fruittype.getCode().equals(fruittypes1.getCode())){
                        sum++;
                    }
                }
                if (sum == 0){
                    fruittypes.add(fruittypes1);
                }
            }
        }
        for (OrderFruittypes fruittype : fruittypes) {
            System.out.println(fruittype);
        }
        return ResponseEntity.ok(fruittypes);
    }


}
