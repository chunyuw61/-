package com.ruoyi.orderforgoods.controller;

import com.ruoyi.orderforgoods.domain.Fruittypes;
import com.ruoyi.orderforgoods.domain.Storeinventory;
import com.ruoyi.orderforgoods.service.impl.FruittypesServiceImpl;
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
 * @date 2023/12/25 19:52
 */

@CrossOrigin
@RestController
@RequestMapping("/FruitTypes")
public class FruitTypesController {
    @Autowired
    private FruittypesServiceImpl fruittypesService;
    @Autowired
    private StoreinventoryServiceImpl storeinventoryService;

    @RequestMapping("/inquireAll")
    public ResponseEntity<List<Fruittypes>> inquireAll(@RequestParam("shopId") String shopId) {
        Storeinventory storeinventory = new Storeinventory();
        storeinventory.setShopId(shopId);
        List<Fruittypes> fruittypes = new ArrayList<>();
        //根据店名查找所有信息
        for (Storeinventory storeinventory1 : storeinventoryService.selectStoreinventoryList(storeinventory)) {
            //拿到水果id
            Fruittypes  fs = new Fruittypes();
            fs.setCode(storeinventory1.getFruittypesId());
            //根据id查询水果名字
            List<Fruittypes> fruittypesList = fruittypesService.selectFruittypesList(fs);
            for (Fruittypes fruittypes1 : fruittypesList) {
                //添加计数器判断是否有重复
                int sum = 0;
                for (Fruittypes fruittype : fruittypes) {
                    if (fruittype.getCode().equals(fruittypes1.getCode())){
                        sum++;
                    }
                }
                if (sum == 0){
                    fruittypes.add(fruittypes1);
                }
            }
        }
        for (Fruittypes fruittype : fruittypes) {
            System.out.println(fruittype);
        }
        return ResponseEntity.ok(fruittypes);
    }


}
