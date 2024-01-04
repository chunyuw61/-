package com.ruoyi.guoran.storeOperations.returnorderdetails.controller;

import java.util.List;

import com.ruoyi.guoran.domain.Returnorderdetails;
import com.ruoyi.guoran.storeOperations.returnorderdetails.service.IReturnorderdetailsService;
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
 * 退货单明细Controller
 * 
 * @author 24k纯帅
 * @date 2023-12-28
 */
@Controller
@RequestMapping("/returnorderdetails/returnorderdetails")
public class ReturnorderdetailsController1 extends BaseController
{
    private String prefix = "returnorderdetails/returnorderdetails";

    @Autowired
    private IReturnorderdetailsService returnorderdetailsService;

    @RequiresPermissions("returnorderdetails:returnorderdetails:view")
    @GetMapping()
    public String returnorderdetails()
    {
        return prefix + "/returnorderdetails";
    }

    /**
     * 查询退货单明细列表
     */
    @RequiresPermissions("returnorderdetails:returnorderdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Returnorderdetails returnorderdetails)
    {
        startPage();
        List<Returnorderdetails> list = returnorderdetailsService.selectReturnorderdetailsList(returnorderdetails);
        return getDataTable(list);
    }

    /**
     * 导出退货单明细列表
     */
    @RequiresPermissions("returnorderdetails:returnorderdetails:export")
    @Log(title = "退货单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Returnorderdetails returnorderdetails)
    {
        List<Returnorderdetails> list = returnorderdetailsService.selectReturnorderdetailsList(returnorderdetails);
        ExcelUtil<Returnorderdetails> util = new ExcelUtil<Returnorderdetails>(Returnorderdetails.class);
        return util.exportExcel(list, "退货单明细数据");
    }

    /**
     * 新增退货单明细
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存退货单明细
     */
    @RequiresPermissions("returnorderdetails:returnorderdetails:add")
    @Log(title = "退货单明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Returnorderdetails returnorderdetails)
    {
        return toAjax(returnorderdetailsService.insertReturnorderdetails(returnorderdetails));
    }

    /**
     * 修改退货单明细
     */
    @RequiresPermissions("returnorderdetails:returnorderdetails:edit")
    @GetMapping("/edit/{rdId}")
    public String edit(@PathVariable("rdId") Long rdId, ModelMap mmap)
    {
        Returnorderdetails returnorderdetails = returnorderdetailsService.selectReturnorderdetailsByRdId(rdId);
        mmap.put("returnorderdetails", returnorderdetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存退货单明细
     */
    @RequiresPermissions("returnorderdetails:returnorderdetails:edit")
    @Log(title = "退货单明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Returnorderdetails returnorderdetails)
    {
        return toAjax(returnorderdetailsService.updateReturnorderdetails(returnorderdetails));
    }

    /**
     * 删除退货单明细
     */
    @RequiresPermissions("returnorderdetails:returnorderdetails:remove")
    @Log(title = "退货单明细", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(returnorderdetailsService.deleteReturnorderdetailsByRdIds(ids));
    }
}
