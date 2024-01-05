package com.ruoyi.guoran.doororder.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.guoran.domain.Doororder;
import com.ruoyi.guoran.doororder.service.IDoororderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门店顶单Controller
 * 
 * @author wmy
 * @date 2023-12-27
 */
@Controller
@RequestMapping("/doororder/doororder")
public class DoororderController extends BaseController
{
    private String prefix = "doororder/doororder";

    @Autowired
    private IDoororderService doororderService;

    @RequiresPermissions("doororder:doororder:view")
    @GetMapping()
    public String doororder()
    {
        return prefix + "/doororder";
    }

    /**
     * 查询门店顶单列表
     */
    @RequiresPermissions("doororder:doororder:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Doororder doororder)
    {
        startPage();
        List<Doororder> list = doororderService.selectDoororderList(doororder);
        return getDataTable(list);
    }

    /**
     * 导出门店顶单列表
     */
    @RequiresPermissions("doororder:doororder:export")
    @Log(title = "门店顶单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Doororder doororder)
    {
        List<Doororder> list = doororderService.selectDoororderList(doororder);
        ExcelUtil<Doororder> util = new ExcelUtil<Doororder>(Doororder.class);
        return util.exportExcel(list, "门店顶单数据");
    }

    /**
     * 新增门店顶单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店顶单
     */
    @RequiresPermissions("doororder:doororder:add")
    @Log(title = "门店顶单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Doororder doororder)
    {
        return toAjax(doororderService.insertDoororder(doororder));
    }

    /**
     * 修改门店顶单
     */
    @RequiresPermissions("doororder:doororder:edit")
    @GetMapping("/edit/{oId}")
    public String edit(@PathVariable("oId") Long oId, ModelMap mmap)
    {
        Doororder doororder = doororderService.selectDoororderByOId(oId);
        mmap.put("doororder", doororder);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店顶单
     */
    @RequiresPermissions("doororder:doororder:edit")
    @Log(title = "门店顶单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Doororder doororder)
    {
        return toAjax(doororderService.updateDoororder(doororder));
    }

    /**
     * 删除门店顶单
     */
    @RequiresPermissions("doororder:doororder:remove")
    @Log(title = "门店顶单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(doororderService.deleteDoororderByOIds(ids));
    }
}
