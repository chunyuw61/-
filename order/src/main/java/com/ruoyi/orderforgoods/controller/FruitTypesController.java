package com.ruoyi.orderforgoods.controller;

import com.ruoyi.orderforgoods.domain.Fruittypes;
import com.ruoyi.orderforgoods.service.impl.FruittypesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class FruitTypesController {
    @Autowired
    private FruittypesServiceImpl fruittypesService;

    @RequestMapping("/inquireAll")
    public ResponseEntity<Map<String, List<Fruittypes>>> inquireAll(){
        Map<String, List<Fruittypes>> response = new HashMap<>();
        List<Fruittypes> fruittypesList = fruittypesService.selectAllFruittypes();
        response.put("type", fruittypesList);
        System.out.println(fruittypesList);
        return ResponseEntity.ok(response);
    }
}
