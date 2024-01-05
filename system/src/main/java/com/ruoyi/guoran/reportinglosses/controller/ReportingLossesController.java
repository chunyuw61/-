package com.ruoyi.guoran.reportinglosses.controller;

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
import com.ruoyi.guoran.reportinglosses.domain.ReportingLosses;
import com.ruoyi.guoran.reportinglosses.service.IReportingLossesService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报损信息Controller
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
@Controller
@RequestMapping("/reportinglosses/reportinglosses")
public class ReportingLossesController extends BaseController
{
    private String prefix = "reportinglosses/reportinglosses";

    @Autowired
    private IReportingLossesService reportingLossesService;

    @RequiresPermissions("reportinglosses:reportinglosses:view")
    @GetMapping()
    public String reportinglosses()
    {
        return prefix + "/reportinglosses";
    }

    /**
     * 查询报损信息列表
     */
    @RequiresPermissions("reportinglosses:reportinglosses:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ReportingLosses reportingLosses)
    {
        startPage();
        List<ReportingLosses> list = reportingLossesService.selectReportingLossesList(reportingLosses);
        return getDataTable(list);
    }

    /**
     * 导出报损信息列表
     */
    @RequiresPermissions("reportinglosses:reportinglosses:export")
    @Log(title = "报损信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ReportingLosses reportingLosses)
    {
        List<ReportingLosses> list = reportingLossesService.selectReportingLossesList(reportingLosses);
        ExcelUtil<ReportingLosses> util = new ExcelUtil<ReportingLosses>(ReportingLosses.class);
        return util.exportExcel(list, "报损信息数据");
    }

    /**
     * 新增报损信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报损信息
     */
    @RequiresPermissions("reportinglosses:reportinglosses:add")
    @Log(title = "报损信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ReportingLosses reportingLosses)
    {
        return toAjax(reportingLossesService.insertReportingLosses(reportingLosses));
    }

    /**
     * 修改报损信息
     */
    @RequiresPermissions("reportinglosses:reportinglosses:edit")
    @GetMapping("/edit/{rId}")
    public String edit(@PathVariable("rId") Long rId, ModelMap mmap)
    {
        ReportingLosses reportingLosses = reportingLossesService.selectReportingLossesByRId(rId);
        mmap.put("reportingLosses", reportingLosses);
        return prefix + "/edit";
    }

    /**
     * 修改保存报损信息
     */
    @RequiresPermissions("reportinglosses:reportinglosses:edit")
    @Log(title = "报损信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ReportingLosses reportingLosses)
    {
        return toAjax(reportingLossesService.updateReportingLosses(reportingLosses));
    }

    /**
     * 删除报损信息
     */
    @RequiresPermissions("reportinglosses:reportinglosses:remove")
    @Log(title = "报损信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(reportingLossesService.deleteReportingLossesByRIds(ids));
    }
}
