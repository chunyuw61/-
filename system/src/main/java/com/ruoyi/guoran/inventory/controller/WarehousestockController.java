package com.ruoyi.guoran.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.guoran.domain.Warehouse;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.inventory.service.IWarehousestockService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
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
        SysUser currentUser = ShiroUtils.getSysUser();
        String userName = currentUser.getUserName(); // 得到登录用户的用户名称
        SysDept dept = currentUser.getDept(); // 得到登录用户的部门信息对象
        System.out.println("--------------------------------------------------");
        System.out.println(userName + "的部门id:" + currentUser.getDeptId());
        System.out.println(userName + "的所属部门:" + dept.getDeptName());
        System.out.println("--------------------------------------------------");
        List<Warehouse> warehouseList = new ArrayList<>();
        Subject subject = ShiroUtils.getSubject();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("WarehouseManager");
        boolean hasAnyRole = false;
        for (String role : roles) {
            if (subject.hasRole(role)) {
                hasAnyRole = true;
                break;
            }
        }
        if (hasAnyRole) { // 如果当前用户有admin角色权限或者仓库经理角色权限的任意一个
            warehouseList = warehousestockService.selectWid();
            System.out.println("当前用户有admin角色权限");
        } else {
            Warehouse warehouse = new Warehouse();
            warehouse.setwNumber(String.valueOf(currentUser.getDeptId()));
            warehouse.setwName(dept.getDeptName());
            warehouseList.add(warehouse); // 将类写入集合
        }
        response.put("warehouse", warehouseList);
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
