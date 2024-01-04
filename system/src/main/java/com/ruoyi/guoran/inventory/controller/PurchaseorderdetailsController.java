package com.ruoyi.guoran.inventory.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.domain.Purchaseorderdetails;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.guoran.inventory.service.IPurchaseorderdetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门店进货单明细和仓库出货单明细Controller
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Controller
@RequestMapping("/inventory/purchaseorderdetails")
public class PurchaseorderdetailsController extends BaseController
{
    private String prefix = "inventory/purchaseorderdetails";

    @Autowired
    private IPurchaseorderdetailsService purchaseorderdetailsService;

    @RequiresPermissions("inventory:purchaseorderdetails:view")
    @GetMapping()
    public String purchaseorderdetails()
    {
        return prefix + "/purchaseorderdetails";
    }

    /**
     * 查询门店进货单明细和仓库出货单明细列表
     */
    @RequiresPermissions("inventory:purchaseorderdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Purchaseorderdetails purchaseorderdetails)
    {
        startPage();
        List<Purchaseorderdetails> list;
        SysUser currentUser = ShiroUtils.getSysUser();
        String userName = currentUser.getUserName(); // 得到登录用户的用户名称
        SysDept dept = currentUser.getDept(); // 得到登录用户的部门信息对象
        System.out.println("--------------------------------------------------");
        System.out.println(userName + "的部门id:" + currentUser.getDeptId());
        System.out.println(userName + "的所属部门:" + dept.getDeptName());
        System.out.println(userName + "的菜单列表id:" + dept.getAncestors());
        System.out.println(userName + "的部门信息对象:" + dept);
        System.out.println("--------------------------------------------------");
        Subject subject = ShiroUtils.getSubject();
        List<String> roles = new ArrayList<>();
        roles.add("admin");
        roles.add("manger"); // 总经理权限
        roles.add("WarehouseManager"); // 仓库经理权限
        boolean hasAnyRole = false;
        for (String role : roles) {
            if (subject.hasRole(role)) {
                hasAnyRole = true;
                break;
            }
        }
        if (hasAnyRole) { // 如果当前用户有权限的任意一个
            list = purchaseorderdetailsService.selectPurchaseorderdetailsList(purchaseorderdetails);
            System.out.println("当前用户有admin角色权限");
        } else {
            SysDept sysDept = new SysDept(); // 部门表的对象
            sysDept.setAncestors(dept.getAncestors());
            list = purchaseorderdetailsService.selectPurchaseorderdetailsByWareAncestors(sysDept);
            System.out.println(dept.getDeptName() + "下属的门店对象集合:" + list);
        }
        return getDataTable(list);
    }

    /**
     * 根据门店编号 查询门店名称
     */
    @PostMapping( "/selectShopName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectShopName(@RequestParam String sNumber) {
        Map<String, String> response = new HashMap<>();
        String shopName = purchaseorderdetailsService.selectShopName(sNumber);
        response.put("shopName", shopName);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据水果种类编号 查询水果种类名称
     */
    @PostMapping( "/selectFruitTypeName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectFruitTypeName(@RequestParam String code) {
        Map<String, String> response = new HashMap<>();
        String fruitTypeName = purchaseorderdetailsService.selectFruitTypeName(code);
        response.put("fruitTypeName", fruitTypeName);
        return ResponseEntity.ok(response);
    }

    /**
     * 审核门店订货订单
     */
    @PostMapping( "/audit")
    @ResponseBody
    public AjaxResult remove(Purchaseorderdetails purchaseorderdetails)
    {
        SysUser currentUser = ShiroUtils.getSysUser();
        String userName = currentUser.getUserName(); // 得到登录用户的用户名称
        SysDept dept = currentUser.getDept(); // 得到登录用户的部门信息对象
        System.out.println("--------------------------------------------------");
        System.out.println(userName + "的部门id:" + currentUser.getDeptId());
        System.out.println(userName + "的所属部门:" + dept.getDeptName());
        System.out.println("--------------------------------------------------");
        if (purchaseorderdetails.getIsStatus() == 3) { // 如果是点击的确认送达
            String wId = String.valueOf(currentUser.getDeptId()); // 仓库id
            String fruitId = purchaseorderdetails.getFruitId(); // 要确认的水果id
            Double number = purchaseorderdetails.getNumber(); // 要减少的数量
            Warehousestock warehousestock = new Warehousestock();
            warehousestock.setwId(wId);
            warehousestock.setFruitId(fruitId);
            warehousestock.setWhCount(number);
            boolean b = purchaseorderdetailsService.reduceInventoryByWidAndFruitId(warehousestock);
            int i = purchaseorderdetailsService.auditByPId(purchaseorderdetails);
            if (b && i != 0) {
                return success();
            } else {
                return error();
            }
        } else {
            return toAjax(purchaseorderdetailsService.auditByPId(purchaseorderdetails));
        }
    }
}
