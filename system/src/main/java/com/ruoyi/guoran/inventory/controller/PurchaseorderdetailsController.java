package com.ruoyi.guoran.inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.guoran.domain.Purchaseorderdetails;
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
        List<Purchaseorderdetails> list = purchaseorderdetailsService.selectPurchaseorderdetailsList(purchaseorderdetails);
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


        return toAjax(purchaseorderdetailsService.auditByPId(purchaseorderdetails));
    }
}
