package com.ruoyi.guoran.fruits.controller;

import java.util.List;

import com.ruoyi.guoran.domain.Fruits;
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
import com.ruoyi.guoran.fruits.service.IFruitsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水果 水果Controller
 * 
 * @author ruoyi
 * @date 2024-01-02
 */
@Controller
@RequestMapping("/fruits/fruits")
public class FruitsController1 extends BaseController
{
    private String prefix = "fruits/fruits";

    @Autowired
    private IFruitsService fruitsService;

    @RequiresPermissions("fruits:fruits:view")
    @GetMapping()
    public String fruits()
    {
        return prefix + "/fruits";
    }

    /**
     * 查询水果 水果列表
     */
    @RequiresPermissions("fruits:fruits:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fruits fruits)
    {
        startPage();
        List<Fruits> list = fruitsService.selectFruitsList(fruits);
        return getDataTable(list);
    }

    /**
     * 导出水果 水果列表
     */
    @RequiresPermissions("fruits:fruits:export")
    @Log(title = "水果 水果", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fruits fruits)
    {
        List<Fruits> list = fruitsService.selectFruitsList(fruits);
        ExcelUtil<Fruits> util = new ExcelUtil<Fruits>(Fruits.class);
        return util.exportExcel(list, "水果 水果数据");
    }

    /**
     * 新增水果 水果
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存水果 水果
     */
    @RequiresPermissions("fruits:fruits:add")
    @Log(title = "水果 水果", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fruits fruits)
    {
        return toAjax(fruitsService.insertFruits(fruits));
    }

    /**
     * 修改水果 水果
     */
    @RequiresPermissions("fruits:fruits:edit")
    @GetMapping("/edit/{fruitId}")
    public String edit(@PathVariable("fruitId") Long fruitId, ModelMap mmap)
    {
        Fruits fruits = fruitsService.selectFruitsByFruitId(fruitId);
        mmap.put("fruits", fruits);
        return prefix + "/edit";
    }

    /**
     * 修改保存水果 水果
     */
    @RequiresPermissions("fruits:fruits:edit")
    @Log(title = "水果 水果", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fruits fruits)
    {
        return toAjax(fruitsService.updateFruits(fruits));
    }

    /**
     * 删除水果 水果
     */
    @RequiresPermissions("fruits:fruits:remove")
    @Log(title = "水果 水果", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fruitsService.deleteFruitsByFruitIds(ids));
    }
}
