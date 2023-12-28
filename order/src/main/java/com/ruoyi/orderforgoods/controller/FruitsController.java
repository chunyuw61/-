package com.ruoyi.orderforgoods.controller;

import com.ruoyi.orderforgoods.domain.Fruits;
import com.ruoyi.orderforgoods.service.impl.FruitsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/inquireByFruittypesId")
    public ResponseEntity<Map<String, List<Fruits>>> inquireByFruittypesId(@RequestParam Long fruittypesId){
        Map<String, List<Fruits>> response = new HashMap<>();
        List<Fruits> fruitsList = fruitsService.selectFruitsByFruittypesId(fruittypesId);
        response.put("fruits", fruitsList);
        System.out.println(fruitsList);
        return ResponseEntity.ok(response);
    }
}