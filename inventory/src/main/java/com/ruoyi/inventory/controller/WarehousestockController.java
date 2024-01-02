package com.ruoyi.inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.inventory.domain.Warehouse;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.inventory.domain.Warehousestock;
import com.ruoyi.inventory.service.IWarehousestockService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 出货单Controller
 * 
 * @author ruoyi
 * @date 2023-12-26
 */
@Controller
@RequestMapping("/inventory/warehousestock")
public class WarehousestockController extends BaseController
{
    private String prefix = "inventory/warehousestock";

    @Autowired
    private IWarehousestockService warehousestockService;

    @RequiresPermissions("inventory:warehousestock:view")
    @GetMapping()
    public String warehousestock()
    {
        return prefix + "/warehousestock";
    }

    /**
     * 查询库存明细列表
     */
    @RequiresPermissions("inventory:warehousestock:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warehousestock warehousestock)
    {
        startPage();
        List<Warehousestock> list = warehousestockService.selectWarehousestockList(warehousestock);
        return getDataTable(list);
    }

    /**
     * 查询对应仓库中的水果编号
     */
    @PostMapping("/selectFruitId")
    @ResponseBody
    public ResponseEntity<Map<String, List<String>>> selectFruitId(@RequestParam String wId) {
        Map<String, List<String>> response = new HashMap<>();
        List<String> wIdOfFruitIdList = warehousestockService.selectFruitId(wId);
        response.put("wIdOfFruitIdList", wIdOfFruitIdList);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据仓库编号 查询仓库名称
     */
    @PostMapping("/selectWareHouseName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectWareHouseName(@RequestParam String wNumber) {
        Map<String, String> response = new HashMap<>();
        String wareHouseName = warehousestockService.selectWareHouseName(wNumber);
        response.put("wareHouseName", wareHouseName);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据水果种类编号 查询水果种类名称
     */
    @PostMapping("/selectFruitTypeName")
    @ResponseBody
        public ResponseEntity<Map<String, String>> selectFruitTypeName(@RequestParam String code) {
        Map<String, String> response = new HashMap<>();
        String fruitTypeName = warehousestockService.selectFruitTypeName(code);
        response.put("fruitTypeName", fruitTypeName);
        return ResponseEntity.ok(response);
    }

    /**
     * 查询仓库编号
     */
    @PostMapping("/selectWid")
    @ResponseBody
    public ResponseEntity<Map<String, List<Warehouse>>> selectWid() {
        Map<String, List<Warehouse>> response = new HashMap<>();
        List<Warehouse> warehouse = warehousestockService.selectWid();
        response.put("warehouse", warehouse);
        return ResponseEntity.ok(response);
    }

    /**
     * 新增库存明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存明细
     */
    @RequiresPermissions("inventory:warehousestock:add")
    @Log(title = "库存明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warehousestock warehousestock)
    {
        int insertprice = warehousestockService.insertprice(warehousestock);
        int inserted = warehousestockService.insertWarehousestock(warehousestock);
        int i = 0;
        if (insertprice > 0 && inserted > 0) {
            i = 1;
        }
        return toAjax(i);
    }

    /**
     * 修改库存明细
     */
    @RequiresPermissions("inventory:warehousestock:edit")
    @GetMapping("/edit/{whId}")
    public String edit(@PathVariable("whId") Long whId, ModelMap mmap)
    {
        Warehousestock warehousestock = warehousestockService.selectWarehousestockByWhId(whId);
        mmap.put("warehousestock", warehousestock);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存明细
     */
    @RequiresPermissions("inventory:warehousestock:edit")
    @Log(title = "库存明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warehousestock warehousestock)
    {
        return toAjax(warehousestockService.updateWarehousestock(warehousestock));
    }

    /**
     * 库存批量清零
     */
    @RequiresPermissions("inventory:warehousestock:remove")
    @Log(title = "库存明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warehousestockService.deleteWarehousestockByWhIds(ids));
    }


    /**
     * 库存清零
     */
    @PostMapping("/whCountClear")
    @ResponseBody
    public AjaxResult whCountClearWhId(@RequestParam Long whId) {
        return toAjax(warehousestockService.whCountClearWhId(whId));
    }

}
