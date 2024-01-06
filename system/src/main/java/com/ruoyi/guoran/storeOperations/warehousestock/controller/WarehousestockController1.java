package com.ruoyi.guoran.storeOperations.warehousestock.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.storeOperations.warehousestock.service.IWarehousestockService;
import com.ruoyi.guoran.domain.Purchaseorderdetails;
import com.ruoyi.guoran.storeOperations.purchaseorderdetails.mapper.PurchaseorderdetailsMapper1;
import com.ruoyi.guoran.storeOperations.warehousestock.mapper.WarehousestockMapper1;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订货Controller
 * 
 * @author 24K纯帅
 * @date 2023-12-26
 */
@Controller
@RequestMapping("/warehousestock/warehousestock")
public class WarehousestockController1 extends BaseController
{

    @Autowired
    WarehousestockMapper1 warehousestockMapper1;

    @Autowired
    PurchaseorderdetailsMapper1 purchaseorderdetailsMapper1;
    private String prefix = "warehousestock/warehousestock";

    @Autowired
    private IWarehousestockService warehousestockService;

    @RequiresPermissions("warehousestock:warehousestock:view")
    @GetMapping()
    public String warehousestock()
    {
        return prefix + "/warehousestock";
    }

    /**
     * 查询订货列表
     */
    @RequiresPermissions("warehousestock:warehousestock:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warehousestock warehousestock)
    {
        startPage();
        List<Warehousestock> list = warehousestockService.selectWarehousestockList(warehousestock);
        System.out.println(list.indexOf(14));
        System.out.println(list);


        return getDataTable(list);
    }

    /**
     * 导出订货列表
     */
    @RequiresPermissions("warehousestock:warehousestock:export")
    @Log(title = "订货", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Warehousestock warehousestock)
    {
        List<Warehousestock> list = warehousestockService.selectWarehousestockList(warehousestock);
        ExcelUtil<Warehousestock> util = new ExcelUtil<Warehousestock>(Warehousestock.class);
        return util.exportExcel(list, "订货数据");
    }

    /**
     * 新增订货
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订货
     */
    @RequiresPermissions("warehousestock:warehousestock:add")
    @Log(title = "订货", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warehousestock warehousestock)
    {
        return toAjax(warehousestockService.insertWarehousestock(warehousestock));
    }

    /**
     * 修改订货
     */
    @RequiresPermissions("warehousestock:warehousestock:edit")
    @GetMapping("/edit/{whId}")
    public String edit(@PathVariable("whId") Long whId, ModelMap mmap)
    {
        Warehousestock warehousestock = warehousestockService.selectWarehousestockByWhId(whId);
        mmap.put("warehousestock", warehousestock);
        return prefix + "/edit";
    }

    /**
     * 修改保存订货
     */
    @RequiresPermissions("warehousestock:warehousestock:edit")
    @Log(title = "订货", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warehousestock warehousestock)
    {
        return toAjax(warehousestockService.updateWarehousestock(warehousestock));
    }

    /**
     * 删除订货
     */
    @RequiresPermissions("warehousestock:warehousestock:remove")
    @Log(title = "订货", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warehousestockService.deleteWarehousestockByWhIds(ids));
    }

    /**
     *
     * 订货
     * @param id
     * @param input
     * @param value
     * @return
     */
    @PostMapping("addOthers")
    @ResponseBody
    public int addOthers(Long id , Double input, String value){

        System.out.println("    ------------------ "+id);
        SysUser sysUser = ShiroUtils.getSysUser();
        System.out.println("当前登录的用户" + sysUser.getUserName());
        Long deptId = sysUser.getDept().getDeptId();
        System.out.println("当前用户的部门id:" + deptId);
        String deptName = sysUser.getDept().getDeptName();
        System.out.println("当前用户的部门:" + deptName);


        // 获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
            String dateStr = sdf.format(new Date());

            // 生成四位随机数
            Random random = new Random();
            int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;

        int a = 0;

        Warehousestock warehousestock = warehousestockMapper1.selectWarehousestockByWhId(id);
        System.out.println(warehousestock);

        Purchaseorderdetails purchaseorderdetails = new Purchaseorderdetails();
        purchaseorderdetails.setsId(String.valueOf(deptId));
        purchaseorderdetails.setpNumber(value); // 订单号
        purchaseorderdetails.setFruittypesId(warehousestock.getFruittypesId());
        purchaseorderdetails.setFruitId(warehousestock.getFruitId());
        purchaseorderdetails.setFruitName(warehousestock.getFruitName());
        purchaseorderdetails.setNumber(input); // 进货数量
        purchaseorderdetails.setPrice(warehousestock.getJinjia());

        int i = purchaseorderdetailsMapper1.insertPurchaseorderdetails(purchaseorderdetails);
        System.out.println("==================="+i);
        if(i>0){
            a =1;
            return a;
        }
        return a;
    }

}
