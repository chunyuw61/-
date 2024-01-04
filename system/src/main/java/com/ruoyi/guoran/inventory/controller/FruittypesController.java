package com.ruoyi.guoran.inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.guoran.inventory.service.IFruittypesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.guoran.domain.Fruittypes;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 水果的种类Controller
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Controller
@RequestMapping("/inventory/fruittypes")
public class FruittypesController extends BaseController
{
    private String prefix = "inventory/fruittypes";

    @Autowired
    private IFruittypesService fruittypesService;

    @RequiresPermissions("inventory:fruittypes:view")
    @GetMapping()
    public String fruittypes()
    {
        return prefix + "/fruittypes";
    }

    /**
     * 查询水果的种类列表
     */
    @RequiresPermissions("inventory:fruittypes:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fruittypes fruittypes)
    {
        startPage();
        List<Fruittypes> list = fruittypesService.selectFruittypesList(fruittypes);
        return getDataTable(list);
    }

    /**
     * 根据传入值水果种类名称
     */
    @PostMapping("/selectFruitTypes")
    @ResponseBody
    public ResponseEntity<Map<String, List<Fruittypes>>> selectFruit(Fruittypes fruittypes) {
        Map<String, List<Fruittypes>> response = new HashMap<>();
        List<Fruittypes> list = fruittypesService.selectFruittypesList(fruittypes);
        response.put("fruittypes", list);
        return ResponseEntity.ok(response);
    }

    /**
     * 查询所有正常状态的水果种类
     */
    @PostMapping("/name")
    @ResponseBody
    public ResponseEntity<Map<String, List<Fruittypes>>> name() {
        Map<String, List<Fruittypes>> response = new HashMap<>();
        List<Fruittypes> fruittypesList = fruittypesService.selectFruitName();
        response.put("fruittypes", fruittypesList);
        return ResponseEntity.ok(response);

    }

    /**
     * 导出水果的种类列表
     */
    @RequiresPermissions("inventory:fruittypes:export")
    @Log(title = "水果的种类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fruittypes fruittypes)
    {
        List<Fruittypes> list = fruittypesService.selectFruittypesList(fruittypes);
        ExcelUtil<Fruittypes> util = new ExcelUtil<Fruittypes>(Fruittypes.class);
        return util.exportExcel(list, "水果的种类数据");
    }

    /**
     * 新增水果的种类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存水果的种类
     */
    @RequiresPermissions("inventory:fruittypes:add")
    @Log(title = "水果的种类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fruittypes fruittypes)
    {
        return toAjax(fruittypesService.insertFruittypes(fruittypes));
    }

    /**
     * 修改水果的种类
     */
    @RequiresPermissions("inventory:fruittypes:edit")
    @GetMapping("/edit/{fruittypesId}")
    public String edit(@PathVariable("fruittypesId") Long fruittypesId, ModelMap mmap)
    {
        Fruittypes fruittypes = fruittypesService.selectFruittypesByFruittypesId(fruittypesId);
        mmap.put("fruittypes", fruittypes);
        return prefix + "/edit";
    }

    /**
     * 修改保存水果的种类
     */
    @RequiresPermissions("inventory:fruittypes:edit")
    @Log(title = "水果的种类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fruittypes fruittypes)
    {
        return toAjax(fruittypesService.updateFruittypes(fruittypes));
    }

    /**
     * 删除水果的种类
     */
    @RequiresPermissions("inventory:fruittypes:remove")
    @Log(title = "水果的种类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fruittypesService.deleteFruittypesByFruittypesIds(ids));
    }

}
