package com.ruoyi.statistics.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ruoyi.FruitDetail;
import com.ruoyi.doororder.domain.Doororder;
import com.ruoyi.doororder.service.IDoororderService;
import com.ruoyi.fruits.domain.Fruits;
import com.ruoyi.fruits.service.IFruitsService;
import com.ruoyi.salesorderdetails.domain.Salesorderdetails;
import com.ruoyi.salesorderdetails.service.ISalesorderdetailsService;
import com.ruoyi.statistics.domain.SalesStatistics;
import com.ruoyi.statistics.service.ISalesStatisticsService;
import org.apache.commons.lang3.SystemUtils;
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
 * 销售统计Controller
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Controller
@RequestMapping("/statistics/statistics")
public class SalesStatisticsController extends BaseController
{
    private String prefix = "statistics/statistics";

    @Autowired
    private ISalesStatisticsService salesStatisticsService;
    @Autowired
    private IDoororderService  doororderService;
    @Autowired
    private ISalesorderdetailsService salesorderdetailsService;
    @Autowired
    private IFruitsService fruitsService;


    @PostMapping("/test")
    @ResponseBody
    List<FruitDetail> test(String sid, String date){
        // 处理日期格式
        String newDate = date.substring(0, 10).replace("-", "");

        List<Doororder> doororders = doororderService.selectDoororderList(null);
        List<FruitDetail> fruitDetailList = new ArrayList<>();

        for (Doororder doororder : doororders) {
            // 获取门店id
            String doorOrderSid = doororder.getsId();

            // 判断门店id是否等于传入的门店id
            if (!doorOrderSid.equals(sid)) {
                continue;
            }

            // 获取订单号中的日期
            String doorordersDate = doororder.getoNum().substring(0, 8);
            //  判断日期是否等于传入的日期
            if (!doorordersDate.equals(newDate)) {
                continue;
            }

            // 获取每个目标 单号
            String targetOrder = doororder.getoNum();

            Salesorderdetails salesorderdetails = new Salesorderdetails(targetOrder);
            List<Salesorderdetails> salesorderdetailsList = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);

            for (Salesorderdetails detail : salesorderdetailsList) {
                // 获取每个目标 单号
                String tarOrder = detail.getoId();
                // 获取水果id
                String fruitId = detail.getFruitpriceId();
                // 获取单价
                BigDecimal count = detail.getCount();
                // 获取数量
                BigDecimal money = detail.getMoney();
                // 获取总价
                String totalmoney = detail.getTotalmoney();

                // 创建搜索条件
                Fruits fruits = new Fruits(fruitId);
                // 查询出符合水果id的数据
                List<Fruits> fruitsList = fruitsService.selectFruitsList(fruits);

                for (Fruits fruit : fruitsList) {
                    // 获取符合条件的水果名
                    String fruitName = fruit.getName();

                    FruitDetail fruitDetail = new FruitDetail(tarOrder,fruitName,count,money,totalmoney);
                    fruitDetailList.add(fruitDetail);
                }
            }
        }
        return fruitDetailList;
    }





    @RequiresPermissions("statistics:statistics:view")
    @GetMapping()
    public String statistics()
    {
        return prefix + "/statistics";
    }

    /**
     * 查询销售统计列表
     */
    @RequiresPermissions("statistics:statistics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SalesStatistics salesStatistics)
    {
        startPage();
        List<SalesStatistics> list = salesStatisticsService.selectSalesStatisticsList(salesStatistics);
        return getDataTable(list);
    }

    /**
     * 导出销售统计列表
     */
    @RequiresPermissions("statistics:statistics:export")
    @Log(title = "销售统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SalesStatistics salesStatistics)
    {
        List<SalesStatistics> list = salesStatisticsService.selectSalesStatisticsList(salesStatistics);
        ExcelUtil<SalesStatistics> util = new ExcelUtil<SalesStatistics>(SalesStatistics.class);
        return util.exportExcel(list, "销售统计数据");
    }

    /**
     * 新增销售统计
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存销售统计
     */
    @RequiresPermissions("statistics:statistics:add")
    @Log(title = "销售统计", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SalesStatistics salesStatistics)
    {
        return toAjax(salesStatisticsService.insertSalesStatistics(salesStatistics));
    }

    /**
     * 修改销售统计
     */
    @RequiresPermissions("statistics:statistics:edit")
    @GetMapping("/edit/{salesStatisticId}")
    public String edit(@PathVariable("salesStatisticId") Long salesStatisticId, ModelMap mmap)
    {
        SalesStatistics salesStatistics = salesStatisticsService.selectSalesStatisticsBySalesStatisticId(salesStatisticId);
        mmap.put("salesStatistics", salesStatistics);
        return prefix + "/edit";
    }

    /**
     * 修改保存销售统计
     */
    @RequiresPermissions("statistics:statistics:edit")
    @Log(title = "销售统计", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SalesStatistics salesStatistics)
    {
        return toAjax(salesStatisticsService.updateSalesStatistics(salesStatistics));
    }

    /**
     * 删除销售统计
     */
    @RequiresPermissions("statistics:statistics:remove")
    @Log(title = "销售统计", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(salesStatisticsService.deleteSalesStatisticsBySalesStatisticIds(ids));
    }

//    @PostMapping("/test")
//    @ResponseBody
//    List<FruitDetail> test(String sid, String date){
//        // 处理日期格式
//        String time = date.substring(0, 10);
//        // 替换日期中的横杠
//        String newDate = time.replace("-", "");
//        List<Doororder> doororders = doororderService.selectDoororderList(null);
//        List<FruitDetail> fruitDetailList = new ArrayList<>();
//        for (int i = 0; i < doororders.size(); i++) {
//            // 获取门店id
//            String doorOrderSid = doororders.get(i).getsId();
//            // 判断门店id是否等于传入的门店id
//            if (doorOrderSid.equals(sid)) {
//                // 获取订单号中的日期
//                String doorordersDate = doororders.get(i).getoNum().substring(0, 8);
//                //  判断日期是否等于传入的日期
//                if (doorordersDate.equals(newDate)) {
//                    // 获取每个目标 单号
//                    String targetOrder = doororders.get(i).getoNum();
//                    Salesorderdetails salesorderdetails = new Salesorderdetails(targetOrder);
//                    List<Salesorderdetails> salesorderdetails1 = salesorderdetailsService.selectSalesorderdetailsList(salesorderdetails);
//                    for (int i1 = 0; i1 < salesorderdetails1.size(); i1++) {
//                        salesorderdetails1.get(i1);
//                        // 获取每个目标 单号
//                        String tarOrder = salesorderdetails1.get(i1).getoId();
//                        // 获取水果id
//                        String fruitId = salesorderdetails1.get(i1).getFruitpriceId();
//                        // 获取单价
//                        BigDecimal count = salesorderdetails1.get(i1).getCount();
//                        // 获取数量
//                        BigDecimal money = salesorderdetails1.get(i1).getMoney();
//                        // 获取总价
//                        String totalmoney = salesorderdetails1.get(i1).getTotalmoney();
//                        // 创建搜索条件
//                        Fruits fruits = new Fruits(fruitId);
//                        // 查询出符合水果id的数据
//                        List<Fruits> fruits1 = fruitsService.selectFruitsList(fruits);
//                        for (int i2 = 0; i2 < fruits1.size(); i2++) {
//                            // 获取符合条件的水果名
//                            String fruitName = fruits1.get(i2).getName();
//
//                            FruitDetail fruitDetail = new FruitDetail(tarOrder,fruitName,count,money,totalmoney);
//                            fruitDetailList.add(fruitDetail);
//                        }
//                    }
//                }
//            }
//        }
//        return fruitDetailList;
//    }
}

