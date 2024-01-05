package com.ruoyi.guoran.orderforgoods.controller;

import com.ruoyi.guoran.orderforgoods.domain.OrderFruits;
import com.ruoyi.guoran.orderforgoods.domain.OrderStoreinventory;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderFruitsServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderStoreinventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 10:36
 */
@CrossOrigin
@RestController
@RequestMapping("/Fruits")
public class OrderFruitsController {
    @Autowired
    private OrderFruitsServiceImpl fruitsService;

    @Autowired
    private OrderStoreinventoryServiceImpl storeinventoryService;

    @RequestMapping("/inquireByFruittypesId")
    public ResponseEntity<List<OrderFruits>> inquireByFruittypesId(@RequestParam String fruittypesId){
        OrderStoreinventory storeinventory = new OrderStoreinventory();
        storeinventory.setFruittypesId(fruittypesId);
        List<OrderFruits> fruits = new ArrayList<>();
        List<OrderStoreinventory> storeinventoryList = storeinventoryService.selectStoreinventoryList(storeinventory);
        System.out.println("storeinventoryList: " + storeinventoryList);
        for (OrderStoreinventory storeinventory1 : storeinventoryList) {
            OrderFruits fruits1=new OrderFruits();
            fruits1.setCode(storeinventory1.getFruitId());
            List<OrderFruits> fruitsList = fruitsService.selectFruitsList(fruits1);
            System.out.println("fruitsList: " + fruitsList);
            for (OrderFruits fruits2 : fruitsList) {
                //添加计数器判断是否有重复
                int sum = 0;
                for (OrderFruits fruit : fruits) {
                    if (fruits2.getCode().equals(fruit.getCode())){
                        sum++;
                    }
                }
                System.out.println("sum: " + sum);
                if (sum == 0){
                    fruits.add(fruits2);
                }
            }
        }
        for (OrderFruits fruit : fruits) {
            System.out.println(fruit);
        }
        return ResponseEntity.ok(fruits);
    }


    @RequestMapping("/number")
    public ResponseEntity<BigDecimal> number(@RequestBody OrderStoreinventory storeinventory){
        BigDecimal bigDecimal = storeinventoryService.selectNumberByFruitIdAndFruittypesId(storeinventory.getFruitId(), storeinventory.getFruittypesId());
        return ResponseEntity.ok(bigDecimal);
    }


}