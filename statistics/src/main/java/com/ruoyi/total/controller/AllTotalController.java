package com.ruoyi.total.controller;

import java.util.List;

import com.ruoyi.statistics.domain.SalesStatistics;
import com.ruoyi.statistics.service.ISalesStatisticsService;
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
import com.ruoyi.total.domain.AllTotal;
import com.ruoyi.total.service.IAllTotalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门店总销售额表Controller
 * 
 * @author ruoyi
 * @date 2023-12-29
 */
@Controller
@RequestMapping("/total/total")
public class AllTotalController extends BaseController
{
    private String prefix = "total/total";

    @Autowired
    private IAllTotalService allTotalService;


    @GetMapping("/total")
    public String test(){
        return prefix + "/total";
    }

//    @RequiresPermissions("total:total:view")
//    @GetMapping()
//    public String total()
//    {
//        return prefix + "/total";
//    }



    /**
     * 查询门店总销售额表列表
     */
    @RequiresPermissions("total:total:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(AllTotal allTotal)
    {
        startPage();
        List<AllTotal> list = allTotalService.countAll();
        return getDataTable(list) ;
    }

    /**
     * 导出门店总销售额表列表
     */
    @RequiresPermissions("total:total:export")
    @Log(title = "门店总销售额表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(AllTotal allTotal)
    {
        List<AllTotal> list = allTotalService.selectAllTotalList(allTotal);
        ExcelUtil<AllTotal> util = new ExcelUtil<AllTotal>(AllTotal.class);
        return util.exportExcel(list, "门店总销售额表数据");
    }

    /**
     * 新增门店总销售额表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店总销售额表
     */
    @RequiresPermissions("total:total:add")
    @Log(title = "门店总销售额表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(AllTotal allTotal)
    {
        return toAjax(allTotalService.insertAllTotal(allTotal));
    }

    /**
     * 修改门店总销售额表
     */
    @RequiresPermissions("total:total:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        AllTotal allTotal = allTotalService.selectAllTotalById(id);
        mmap.put("allTotal", allTotal);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店总销售额表
     */
    @RequiresPermissions("total:total:edit")
    @Log(title = "门店总销售额表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(AllTotal allTotal)
    {
        return toAjax(allTotalService.updateAllTotal(allTotal));
    }

    /**
     * 删除门店总销售额表
     */
    @RequiresPermissions("total:total:remove")
    @Log(title = "门店总销售额表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(allTotalService.deleteAllTotalByIds(ids));
    }
}
