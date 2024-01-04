package com.ruoyi.guoran.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.guoran.domain.Shop;
import com.ruoyi.guoran.domain.Storeinventory;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.inventory.service.IStoreinventoryService;
import com.ruoyi.guoran.domain.Warehouse;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门店库存Controller
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
@Controller
@RequestMapping("/inventory/storeinventory")
public class StoreinventoryController extends BaseController
{
    private String prefix = "inventory/storeinventory";

    @Autowired
    private IStoreinventoryService storeinventoryService;

    @RequiresPermissions("inventory:storeinventory:view")
    @GetMapping()
    public String storeinventory()
    {
        return prefix + "/storeinventory";
    }

    /**
     * 查询门店库存列表
     */
    @RequiresPermissions("inventory:storeinventory:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Storeinventory storeinventory)
    {
        startPage();
        List<Storeinventory> list = storeinventoryService.selectStoreinventoryList(storeinventory);
        return getDataTable(list);
    }

    /**
     * 查询每个仓库中有的水果 (状态正常的水果) 和水果种类编号
     */
    @PostMapping("/selectWareHouseStockFruit")
    @ResponseBody
    public ResponseEntity<Map<String, List<Warehousestock>>> selectWareHouseStockFruit(@RequestParam String wId) {
        Map<String, List<Warehousestock>> response = new HashMap<>();
        List<Warehousestock> wareHouseList = storeinventoryService.selectWareHouseStockFruit(wId);
        response.put("wareHouseList", wareHouseList);
        return ResponseEntity.ok(response);
    }

    /**
     * 查询对应门店编号中所有的水果编号
     */
    @PostMapping("/selectFruitId")
    @ResponseBody
    public ResponseEntity<Map<String, List<String>>> selectFruitId(@RequestParam String shopId) {
        Map<String, List<String>> response = new HashMap<>();
        List<String> shopIdOfFruitId = storeinventoryService.selectFruitId(shopId);
        response.put("shopIdOfFruitId", shopIdOfFruitId);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据水果种类编号查询水果种类名称
     */
    @PostMapping("/selectFruitTypeName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectFruitTypeName(@RequestParam String code) {
        Map<String, String> response = new HashMap<>();
        String fruitTypeName = storeinventoryService.selectFruitTypeName(code);
        response.put("fruitTypeName", fruitTypeName);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据水果编号查询水果名称
     */
    @PostMapping("/selectFruitNameByFruitId")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectFruitNameByFruitId(@RequestParam String code) {
        Map<String, String> response = new HashMap<>();
        String fruitName = storeinventoryService.selectFruitName(code);
        response.put("fruitName", fruitName);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据门店编号查询门店名称
     */
    @PostMapping("/selectShopName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectShopName(@RequestParam String sNumber) {
        Map<String, String> response = new HashMap<>();
        String shopName = storeinventoryService.selectShopName(sNumber);
        response.put("shopName", shopName);
        return ResponseEntity.ok(response);
    }

    /**
     * 查询所有仓库编号和仓库名称
     */
    @PostMapping("/selectWareHouseId")
    @ResponseBody
    public ResponseEntity<Map<String, List<Warehouse>>> selectWareHouseId() {
        Map<String, List<Warehouse>> response = new HashMap<>();
        SysUser currentUser = ShiroUtils.getSysUser();
        String userName = currentUser.getUserName(); // 得到登录用户的用户名称
        SysDept dept = currentUser.getDept(); // 得到登录用户的部门信息对象
        System.out.println("--------------------------------------------------");
        System.out.println(userName + "的部门id:" + currentUser.getDeptId());
        System.out.println(userName + "的所属部门:" + dept.getDeptName());
        System.out.println(userName + "的父级菜单id:" + dept.getParentId());
        System.out.println(userName + "的部门信息对象:" + dept);
        System.out.println("--------------------------------------------------");
        int parentId = storeinventoryService.selectParentIdByParentId(Math.toIntExact(dept.getParentId()));
        System.out.println(userName + "的父级id的父级部门id:" + parentId);
        List<Warehouse> warehouseList = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        Subject subject = ShiroUtils.getSubject();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("manger");
        boolean hasAnyRole = false;
        for (String role : roles) {
            if (subject.hasRole(role)) {
                hasAnyRole = true;
                break;
            }
        }
        if (hasAnyRole) { // 如果当前用户有admin角色权限或者总经理角色权限的任意一个
            warehouseList = storeinventoryService.selectWareHouseId();
            System.out.println("当前用户有admin角色权限");
        } else {
            if (parentId == 101) { // 如果该店的父级id的父级部门id是101(太原总公司)
                warehouse.setwNumber("203");
                warehouse.setwName("龙城仓库");
                warehouseList.add(warehouse);
            } else if (parentId == 102) { // 如果该店的父级id的父级部门id是102(北京分公司)
                warehouse.setwNumber("205");
                warehouse.setwName("首都仓库");
                warehouseList.add(warehouse);
            }
        }
        System.out.println(warehouseList);
        response.put("wareHouse", warehouseList);
        return ResponseEntity.ok(response);
    }

    /**
     * 查询所有门店编号
     */
    @PostMapping("/selectShopId")
    @ResponseBody
    public ResponseEntity<Map<String, List<Shop>>> selectShopId() {
        Map<String, List<Shop>> response = new HashMap<>();
        SysUser currentUser = ShiroUtils.getSysUser();
        String userName = currentUser.getUserName(); // 得到登录用户的用户名称
        SysDept dept = currentUser.getDept(); // 得到登录用户的部门信息对象
        System.out.println("--------------------------------------------------");
        System.out.println(userName + "的部门id:" + currentUser.getDeptId());
        System.out.println(userName + "的所属部门:" + dept.getDeptName());
        System.out.println("--------------------------------------------------");
        List<Shop> shopList = new ArrayList<>();
        Subject subject = ShiroUtils.getSubject();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("manger");
        boolean hasAnyRole = false;
        for (String role : roles) {
            if (subject.hasRole(role)) {
                hasAnyRole = true;
                break;
            }
        }
        if (hasAnyRole) { // 如果当前用户有admin角色权限或者总经理角色权限的任意一个
            shopList = storeinventoryService.selectShopId();
            System.out.println("当前用户有admin角色权限");
        } else {
            Shop shop = new Shop();
            shop.setsNumber(String.valueOf(currentUser.getDeptId()));
            shop.setsName(dept.getDeptName());
            shopList.add(shop); // 将类写入集合
        }
        response.put("shop", shopList);
        return ResponseEntity.ok(response);
    }

    /**
     * 导出门店库存列表
     */
    @RequiresPermissions("inventory:storeinventory:export")
    @Log(title = "门店库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Storeinventory storeinventory)
    {
        List<Storeinventory> list = storeinventoryService.selectStoreinventoryList(storeinventory);
        ExcelUtil<Storeinventory> util = new ExcelUtil<Storeinventory>(Storeinventory.class);
        return util.exportExcel(list, "门店库存数据");
    }

    /**
     * 新增门店库存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店库存
     */
    @RequiresPermissions("inventory:storeinventory:add")
    @Log(title = "门店库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Storeinventory storeinventory)
    {
        return toAjax(storeinventoryService.insertStoreinventory(storeinventory));
    }

    /**
     * 修改门店库存
     */
    @RequiresPermissions("inventory:storeinventory:edit")
    @GetMapping("/edit/{inentorydetailsId}")
    public String edit(@PathVariable("inentorydetailsId") Long inentorydetailsId, ModelMap mmap)
    {
        Storeinventory storeinventory = storeinventoryService.selectStoreinventoryByInentorydetailsId(inentorydetailsId);
        mmap.put("storeinventory", storeinventory);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店库存
     */
    @RequiresPermissions("inventory:storeinventory:edit")
    @Log(title = "门店库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Storeinventory storeinventory)
    {
        return toAjax(storeinventoryService.updateStoreinventory(storeinventory));
    }

    /**
     * 删除门店库存
     */
    @RequiresPermissions("inventory:storeinventory:remove")
    @Log(title = "门店库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(storeinventoryService.deleteStoreinventoryByInentorydetailsIds(ids));
    }
}
