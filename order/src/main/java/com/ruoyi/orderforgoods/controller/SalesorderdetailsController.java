package com.ruoyi.orderforgoods.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.orderforgoods.domain.OrderFruittypes;
import com.ruoyi.orderforgoods.domain.Salesorderdetails;
import com.ruoyi.orderforgoods.service.ISalesorderdetailsService;
import com.ruoyi.orderforgoods.service.impl.OrderFruittypesServiceImpl;
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
public class SalesorderdetailsController extends BaseController
{
    private String prefix = "orderforgooda/salesorderdetails";

    @Autowired
    private ISalesorderdetailsService salesorderdetailsService;

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
    public TableDataInfo list(Salesorderdetails salesorderdetails)
    {
        startPage();
        List<Salesorderdetails> list = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
        return getDataTable(list);
    }

    /**
     * 导出销售订单明细列表
     */
    @RequiresPermissions("orderforgooda:salesorderdetails:export")
    @Log(title = "销售订单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Salesorderdetails salesorderdetails)
    {
        List<Salesorderdetails> list = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
        ExcelUtil<Salesorderdetails> util = new ExcelUtil<Salesorderdetails>(Salesorderdetails.class);
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
    public AjaxResult addSave(Salesorderdetails salesorderdetails)
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
        Salesorderdetails salesorderdetails = salesorderdetailsService.selectSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
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
    public AjaxResult editSave(Salesorderdetails salesorderdetails)
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
