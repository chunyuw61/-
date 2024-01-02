package com.ruoyi.orderforgoods.controller;

import com.ruoyi.orderforgoods.domain.Fruits;
import com.ruoyi.orderforgoods.domain.Storeinventory;
import com.ruoyi.orderforgoods.service.impl.FruitsServiceImpl;
import com.ruoyi.orderforgoods.service.impl.StoreinventoryServiceImpl;
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
 * @date 2023/12/26 10:36
 */
@CrossOrigin
@RestController
@RequestMapping("/Fruits")
public class FruitsController {
    @Autowired
    private FruitsServiceImpl fruitsService;

    @Autowired
    private StoreinventoryServiceImpl storeinventoryService;

    @RequestMapping("/inquireByFruittypesId")
    public ResponseEntity<List<Fruits>> inquireByFruittypesId(@RequestParam String fruittypesId){
        Storeinventory storeinventory = new Storeinventory();
        storeinventory.setFruittypesId(fruittypesId);
        List<Fruits> fruits = new ArrayList<>();
        List<Storeinventory> storeinventoryList = storeinventoryService.selectStoreinventoryList(storeinventory);
        System.out.println("storeinventoryList: " + storeinventoryList);
        for (Storeinventory storeinventory1 : storeinventoryList) {
            Fruits fruits1=new Fruits();
            fruits1.setCode(storeinventory1.getFruitId());
            List<Fruits> fruitsList = fruitsService.selectFruitsList(fruits1);
            System.out.println("fruitsList: " + fruitsList);
            for (Fruits fruits2 : fruitsList) {
                //添加计数器判断是否有重复
                int sum = 0;
                for (Fruits fruit : fruits) {
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
        for (Fruits fruit : fruits) {
            System.out.println(fruit);
        }
        return ResponseEntity.ok(fruits);
    }


}