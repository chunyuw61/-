package com.ruoyi.warehouse.controller;

import java.util.List;
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
import com.ruoyi.warehouse.domain.Warehouse;
import com.ruoyi.warehouse.service.IWarehouseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 仓库信息Controller
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
@Controller
@RequestMapping("/warehouse/warehouse")
public class WarehouseController extends BaseController
{
    private String prefix = "warehouse/warehouse";

    @Autowired
    private IWarehouseService warehouseService;

    @RequiresPermissions("warehouse:warehouse:view")
    @GetMapping()
    public String warehouse()
    {
        return prefix + "/warehouse";
    }

    /**
     * 查询仓库信息列表
     */
    @RequiresPermissions("warehouse:warehouse:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Warehouse warehouse)
    {
        startPage();
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        return getDataTable(list);
    }

    /**
     * 导出仓库信息列表
     */
    @RequiresPermissions("warehouse:warehouse:export")
    @Log(title = "仓库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Warehouse warehouse)
    {
        List<Warehouse> list = warehouseService.selectWarehouseList(warehouse);
        ExcelUtil<Warehouse> util = new ExcelUtil<Warehouse>(Warehouse.class);
        return util.exportExcel(list, "仓库信息数据");
    }

    /**
     * 新增仓库信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存仓库信息
     */
    @RequiresPermissions("warehouse:warehouse:add")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Warehouse warehouse)
    {
        return toAjax(warehouseService.insertWarehouse(warehouse));
    }

    /**
     * 修改仓库信息
     */
    @RequiresPermissions("warehouse:warehouse:edit")
    @GetMapping("/edit/{wId}")
    public String edit(@PathVariable("wId") Long wId, ModelMap mmap)
    {
        Warehouse warehouse = warehouseService.selectWarehouseByWId(wId);
        mmap.put("warehouse", warehouse);
        return prefix + "/edit";
    }

    /**
     * 修改保存仓库信息
     */
    @RequiresPermissions("warehouse:warehouse:edit")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Warehouse warehouse)
    {
        return toAjax(warehouseService.updateWarehouse(warehouse));
    }

    /**
     * 删除仓库信息
     */
    @RequiresPermissions("warehouse:warehouse:remove")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(warehouseService.deleteWarehouseByWIds(ids));
    }
}
