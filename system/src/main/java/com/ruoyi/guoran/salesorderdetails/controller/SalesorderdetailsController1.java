package com.ruoyi.guoran.salesorderdetails.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.guoran.domain.SalesStatistics;
import com.ruoyi.guoran.reportinglosses.domain.ReportingLosses;
import com.ruoyi.guoran.reportinglosses.service.IReportingLossesService;
import com.ruoyi.guoran.statistics.service.ISalesStatisticsService;
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
import com.ruoyi.guoran.domain.Salesorderdetails;
import com.ruoyi.guoran.salesorderdetails.service.ISalesorderdetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门店退单Controller
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
@Controller
@RequestMapping("/salesorderdetails/salesorderdetails")
public class SalesorderdetailsController1 extends BaseController
{
    private String prefix = "salesorderdetails/salesorderdetails";

    @Autowired
    private ISalesorderdetailsService salesorderdetailsService;
    @Autowired
    private ISalesStatisticsService salesStatisticsService;
    @Autowired
    private IReportingLossesService reportingLossesService;


    @PostMapping("/chargeback")
    @ResponseBody
    public String chargeBack(Long id ,String oId,String totalMoney,String sId){

        System.out.println("前端获取的值：："+id+">>"+oId+">>"+totalMoney+">>"+sId);

        String newDate = oId.substring(0, 8).replace("-", "");

        BigDecimal decimalMoney = new BigDecimal(totalMoney);

        List<SalesStatistics> salesStatisticsList = salesStatisticsService.selectSalesStatisticsList(null);


        String loginName = ShiroUtils.getSysUser().getLoginName();

        Salesorderdetails salesorderdetails = new Salesorderdetails(id,loginName,new Date());
        // 更新当前单状态
        int i1 = salesorderdetailsService.updateSalesorderdetails(salesorderdetails);

        if ( i1 == 1){
            // 更新退单状态
            salesorderdetailsService.deleteSalesorderdetailsBySalesorderdetailsId(id);

            Salesorderdetails backOrder = salesorderdetailsService.selectSalesorderdetailsBySalesorderdetailsId(id);
            // 门店编号
            String backOrdersId = backOrder.getsId();
            // 订单号
            String backOrderoId = backOrder.getoId();
            // 水果编号
            String backOrderFruitId = backOrder.getFruitpriceId();
            // 数量
            BigDecimal backOrderCount = backOrder.getCount();
            // 单价
            BigDecimal backOrderMoney = backOrder.getMoney();
            // 总价
            BigDecimal backOrderTotalMoney = backOrder.getTotalmoney();
            // 时间
            Date backOrderUpdatedTime = backOrder.getUpdatedTime();
            // 创建条件对象
            ReportingLosses reportingLosses = new ReportingLosses(backOrdersId,backOrderoId,backOrderUpdatedTime,backOrderFruitId,backOrderCount,backOrderMoney,backOrderTotalMoney,"短期内内部变质");
            // 插入新数据
            reportingLossesService.insertReportingLosses(reportingLosses);

            // 改变当前单数额对总销售额影响
            for (int i = 0; i < salesStatisticsList.size(); i++) {
                String format = new SimpleDateFormat("yyyyMMdd").format(salesStatisticsList.get(i).getDate());
                if (format.equals(newDate)){
                    // 获取门店id
                    String newId = salesStatisticsList.get(i).getSId();
                    System.out.println(newId);

                    if (newId!= null && newId.equals(sId)){
                        SalesStatistics salesStatistics = salesStatisticsList.get(i);
                        // 拿到总营业额
                        BigDecimal turnover = salesStatistics.getTurnover();
                        // 拿到客流量
                        Integer passengerFlow = salesStatistics.getPassengerFlow();
                        // 更新总营业额
                        salesStatistics.setTurnover((turnover.subtract(decimalMoney)));
                        // 更新客流量
                        salesStatistics.setPassengerFlow(passengerFlow-1);
                        int i11 = passengerFlow - 1;
                        BigDecimal bigDecimal = new BigDecimal(i11);
                        // 更新平均营业额
                        salesStatistics.setAvgSales((turnover.subtract(decimalMoney)).divide(bigDecimal,2,BigDecimal.ROUND_UP));

                        int i2 = salesStatisticsService.updateSalesStatistics(salesStatistics);

                        if (i2 == 1){
                            return "yes";
                        }
                    }
                }

            }

        }
        return "no";
    }

    @RequiresPermissions("salesorderdetails:salesorderdetails:view")
    @GetMapping()
    public String salesorderdetails()
    {
        return prefix + "/salesorderdetails";
    }

    /**
     * 查询门店退单列表
     */
    @RequiresPermissions("salesorderdetails:salesorderdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Salesorderdetails salesorderdetails)
    {
        startPage();
        List<Salesorderdetails> list = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
        return getDataTable(list);
    }

    /**
     * 导出门店退单列表
     */
    @RequiresPermissions("salesorderdetails:salesorderdetails:export")
    @Log(title = "门店退单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Salesorderdetails salesorderdetails)
    {
        List<Salesorderdetails> list = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
        ExcelUtil<Salesorderdetails> util = new ExcelUtil<Salesorderdetails>(Salesorderdetails.class);
        return util.exportExcel(list, "门店退单数据");
    }

    /**
     * 新增门店退单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存门店退单
     */
    @RequiresPermissions("salesorderdetails:salesorderdetails:add")
    @Log(title = "门店退单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Salesorderdetails salesorderdetails)
    {
        return toAjax(salesorderdetailsService.insertSalesorderdetails(salesorderdetails));
    }

    /**
     * 修改门店退单
     */
    @RequiresPermissions("salesorderdetails:salesorderdetails:edit")
    @GetMapping("/edit/{salesorderdetailsId}")
    public String edit(@PathVariable("salesorderdetailsId") Long salesorderdetailsId, ModelMap mmap)
    {
        Salesorderdetails salesorderdetails = salesorderdetailsService.selectSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
        mmap.put("salesorderdetails", salesorderdetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店退单
     */
    @RequiresPermissions("salesorderdetails:salesorderdetails:edit")
    @Log(title = "门店退单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Salesorderdetails salesorderdetails)
    {
        return toAjax(salesorderdetailsService.updateSalesorderdetails(salesorderdetails));
    }

    /**
     * 删除门店退单
     */
    @RequiresPermissions("salesorderdetails:salesorderdetails:remove")
    @Log(title = "门店退单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(salesorderdetailsService.deleteSalesorderdetailsBySalesorderdetailsIds(ids));
    }
}
