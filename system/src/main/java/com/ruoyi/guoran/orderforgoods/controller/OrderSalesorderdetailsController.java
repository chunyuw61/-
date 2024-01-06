package com.ruoyi.guoran.orderforgoods.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.guoran.orderforgoods.domain.OrderFruittypes;
import com.ruoyi.guoran.orderforgoods.domain.OrderSalesorderdetails;
import com.ruoyi.guoran.orderforgoods.service.OrderISalesorderdetailsService;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderFruittypesServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售订单明细Controller
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Controller
@RequestMapping("/orderforgooda/salesorderdetails")
public class OrderSalesorderdetailsController extends BaseController
{
    private String prefix = "orderforgooda/salesorderdetails";

    @Autowired
    private OrderISalesorderdetailsService salesorderdetailsService;

    @RequiresPermissions("orderforgooda:salesorderdetails:view")
    @GetMapping()
    public String salesorderdetails()
    {
        return prefix + "/salesorderdetails";
    }

    /**
     * 查询销售订单明细列表
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderSalesorderdetails salesorderdetails)
    {
        startPage();
        List<OrderSalesorderdetails> list = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
        return getDataTable(list);
    }

    /**
     * 导出销售订单明细列表
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:export")
    @Log(title = "销售订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderSalesorderdetails salesorderdetails)
    {
        List<OrderSalesorderdetails> list = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
        ExcelUtil<OrderSalesorderdetails> util = new ExcelUtil<OrderSalesorderdetails>(OrderSalesorderdetails.class);
        return util.exportExcel(list, "销售订单明细数据");
    }

    /**
     * 新增销售订单明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存销售订单明细
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:add")
    @Log(title = "销售订单明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderSalesorderdetails salesorderdetails)
    {
        return toAjax(salesorderdetailsService.insertSalesorderdetails(salesorderdetails));
    }

    /**
     * 修改销售订单明细
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:edit")
    @GetMapping("/edit/{salesorderdetailsId}")
    public String edit(@PathVariable("salesorderdetailsId") Long salesorderdetailsId, ModelMap mmap)
    {
        OrderSalesorderdetails salesorderdetails = salesorderdetailsService.selectSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
        mmap.put("salesorderdetails", salesorderdetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售订单明细
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:edit")
    @Log(title = "销售订单明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderSalesorderdetails salesorderdetails)
    {
        return toAjax(salesorderdetailsService.updateSalesorderdetails(salesorderdetails));
    }

    /**
     * 删除销售订单明细
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:remove")
    @Log(title = "销售订单明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(salesorderdetailsService.deleteSalesorderdetailsBySalesorderdetailsIds(ids));
    }

    @Autowired
    private OrderFruittypesServiceImpl fruittypesService;

    @RequestMapping("/inquireAll")
    public ResponseEntity<Map<String, List<OrderFruittypes>>> inquireAll(){
        Map<String, List<OrderFruittypes>> response = new HashMap<>();
        List<OrderFruittypes> fruittypesList = fruittypesService.selectAllFruittypes();
        response.put("type", fruittypesList);
        System.out.println(fruittypesList);
        return ResponseEntity.ok(response);
    }
}
