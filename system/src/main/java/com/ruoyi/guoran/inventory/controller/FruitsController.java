package com.ruoyi.guoran.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.guoran.domain.Storeinventory;
import com.ruoyi.guoran.inventory.service.IFruitsService;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.guoran.domain.Fruits;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水果 水果Controller
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Controller
@RequestMapping("/inventory/fruits")
public class FruitsController extends BaseController
{
    private String prefix = "inventory/fruits";
    
    @Autowired
    private IFruitsService fruitsService;
/*    @Autowired
    private StoreInventoryServiceImpl storeinventoryService;*/

    @RequiresPermissions("inventory:fruits:view")
    @GetMapping()
    public String fruits()
    {
        return prefix + "/fruits";
    }

    /**
     * 查询水果 水果列表
     */
    @RequiresPermissions("inventory:fruits:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fruits fruits)
    {
        startPage();
        List<Fruits> list = fruitsService.selectFruitsList(fruits);
        return getDataTable(list);
    }

    /**
     * 根据水果种类名称查询水果种类编号
     */
    @PostMapping("/selectFruitTypeId")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectFruitTypeId(@RequestParam String name) {
        Map<String, String> response = new HashMap<>();
        String fruitTypeId = fruitsService.selectFruitTypeId(name);
        response.put("fruitTypeId", fruitTypeId);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据水果种类编号查询水果种类名称
     */
    @PostMapping("/selectFruitTypeName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectFruitTypeName(@RequestParam String code) {
        Map<String, String> response = new HashMap<>();
        String fruitTypeName = fruitsService.selectFruitTypeName(code);
        response.put("fruitTypeName", fruitTypeName);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据传入值查询水果编号和水果名称
     */
    @PostMapping("/selectFruit")
    @ResponseBody
    public ResponseEntity<Map<String, List<Fruits>>> selectFruit(Fruits fruits) {
        Map<String, List<Fruits>> response = new HashMap<>();
        List<Fruits> list = fruitsService.selectFruitsList(fruits);
        response.put("fruits", list);
        return ResponseEntity.ok(response);
    }

    /**
     * 导出水果 水果列表
     */
    @RequiresPermissions("inventory:fruits:export")
    @Log(title = "水果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fruits fruits)
    {
        List<Fruits> list = fruitsService.selectFruitsList(fruits);
        ExcelUtil<Fruits> util = new ExcelUtil<Fruits>(Fruits.class);
        return util.exportExcel(list, "水果 水果数据");
    }

    /**
     * 新增水果
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存水果
     */
    @RequiresPermissions("inventory:fruits:add")
    @Log(title = "水果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fruits fruits)
    {
        return toAjax(fruitsService.insertFruits(fruits));
    }

    /**
     * 修改水果
     */
    @RequiresPermissions("inventory:fruits:edit")
    @GetMapping("/edit/{fruitId}")
    public String edit(@PathVariable("fruitId") Long fruitId, ModelMap mmap)
    {
        Fruits fruits = fruitsService.selectFruitsByFruitId(fruitId);
        mmap.put("fruits", fruits);
        return prefix + "/edit";
    }

    /**
     * 修改保存水果
     */
    @RequiresPermissions("inventory:fruits:edit")
    @Log(title = "水果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fruits fruits)
    {
        return toAjax(fruitsService.updateFruits(fruits));
    }

    /**
     * 删除水果
     */
    @RequiresPermissions("inventory:fruits:remove")
    @Log(title = "水果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fruitsService.deleteFruitsByFruitIds(ids));
    }

/*    @RequestMapping("/inquireByFruittypesId")
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
    }*/

}
