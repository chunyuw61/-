package com.ruoyi.guoran.inventory.controller;

import java.util.*;

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
        List<Purchaseorderdetails> list = new ArrayList<>();
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
        if (subject.hasRole("DragonWarehouseAdministrator")) { // 如果当前用户是仓库管理员权限
            SysDept sysDept = new SysDept(); // 部门表的对象
            sysDept.setAncestors(dept.getAncestors()); // 设置菜单列表id
            // 搜索框搜索门店编号
            if (purchaseorderdetails.getsId() != null && !purchaseorderdetails.getsId().isEmpty()) {
                Long deptId = Long.valueOf(purchaseorderdetails.getsId()); // 将传入的门店id传入SysDept类中
                sysDept.setDeptId(deptId);
            }
            list = purchaseorderdetailsService.selectPurchaseorderdetailsByWareAncestors(sysDept);
            System.out.println(dept.getDeptName() + "下属的门店对象集合:" + list);
            System.out.println("当前用户有仓库管理员角色权限");
        } else {
            Long[] roleIds = ShiroUtils.getSysUser().getRoleIds();
            list = purchaseorderdetailsService.selectPurchaseorderdetailsList(purchaseorderdetails);
            System.out.println("当前用户有" + Arrays.toString(roleIds) +"角色权限");
        }
        return getDataTable(list);
    }


    /**
     * 根据门店名称 查询门店编号
     */
    @PostMapping( "/selectShopId")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectShopId(@RequestParam String sName) {
        Map<String, String> response = new HashMap<>();
        String shopId = purchaseorderdetailsService.selectShopId(sName);
        response.put("shopId", shopId);
        return ResponseEntity.ok(response);
    }

    /**
     * 根据门店编号 查询门店名称
     */
    @PostMapping( "/selectShopName")
    @ResponseBody
    public ResponseEntity<Map<String, String>> selectShopName(@RequestParam String sNumber) {
        Map<String, String> response = new HashMap<>();
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
        SysDept sysDept = new SysDept();
        sysDept.setDeptId(Long.valueOf(sNumber));
        if (subject.hasRole("DragonWarehouseAdministrator")) { // 如果当前用户是仓库管理员权限
            sysDept.setAncestors(dept.getAncestors());
            response.put("admin", "DragonWarehouseAdministrator");
        }
        String shopName = purchaseorderdetailsService.selectShopName(sysDept);
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
