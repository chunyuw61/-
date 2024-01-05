package com.ruoyi.guoran.orderforgoods.controller;


import com.ruoyi.guoran.orderforgoods.domain.*;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderDoororderServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderSalesStatisticsServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderSalesorderdetailsServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderStoreinventoryServiceImpl;
import com.ruoyi.guoran.orderforgoods.trade.Cs;
import com.ruoyi.guoran.orderforgoods.utility.ByteStream;
import com.ruoyi.guoran.orderforgoods.utility.DeleteFile;
import com.ruoyi.guoran.orderforgoods.utility.OrderUtil;
import com.ruoyi.guoran.orderforgoods.utility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 19:25
 */

@RestController
@RequestMapping("/salesorderdetails")
public class OrderFruitOrderFormController {
    @Autowired
    private OrderSalesorderdetailsServiceImpl salesorderdetailsService;

    @Autowired
    private OrderDoororderServiceImpl doororderService;

    @Autowired
    private OrderSalesStatisticsServiceImpl salesStatisticsService;

    @Autowired
    private OrderStoreinventoryServiceImpl orderStoreinventoryService;

    // 使用@PostMapping注解来处理POST请求
    @PostMapping("/insert")
    public ResponseEntity<Void> insertSalesorderdetails(@RequestBody List<OrderSalesorderdetails> salesorderdetailsList) {
        String i = OrderUtil.generateOrderNumber();
        Date j = TimeUtil.getCurrentTime();
        OrderDoororder doororder = new OrderDoororder();
        doororder.setoNum(i);
        BigDecimal b = null;
        for (OrderSalesorderdetails salesorderdetails : salesorderdetailsList) {
            System.out.println(salesorderdetails);
            System.out.println("salesorderdetails.getSId()" + salesorderdetails.getsId());
            doororder.setsId(salesorderdetails.getsId());
            System.out.println("---------------门店id是---------------" + doororder.getsId());
            salesorderdetails.setoId(i);
            salesorderdetails.setDatetime(j);
            if (b == null) {
                b = salesorderdetails.getTotalmoney();
            }
            salesorderdetailsService.insertSalesorderdetails(salesorderdetails);
            //将对应的库存减掉
            OrderStoreinventory orderStoreinventory = new OrderStoreinventory();
            orderStoreinventory.setShopId(salesorderdetails.getsId());
            orderStoreinventory.setFruitId(salesorderdetails.getFruitpriceId());
            for (OrderStoreinventory storeinventory : orderStoreinventoryService.selectStoreinventoryList(orderStoreinventory)) {
                System.out.println("门店的库存是" + storeinventory);
                storeinventory.setNumber(storeinventory.getNumber().subtract(salesorderdetails.getCount()));
                int i1 = orderStoreinventoryService.updateStoreinventory(storeinventory);
                if (i1 == 0) {
                    System.out.println("门店库存更新失败");
                } else {
                    System.out.println("门店库存更新成功");
                }
            }
        }
        doororder.setMoney(b);
        int i1 = doororderService.insertDoororder(doororder);
        if (b == null) {
            System.out.println("金额为空,不算客流量");
        } else {
            //获取当前时间精确到天
            Date time = TimeUtil.getCurrentDate();
            System.out.println(time);
            //查询订单的所有信息
            OrderSalesStatistics salesStatistics = new OrderSalesStatistics();
            salesStatistics.setDate(time);
            salesStatistics.setSId(doororder.getsId());
            List<OrderSalesStatistics> list = salesStatisticsService.selectSalesStatisticsList(salesStatistics);
            if (list.size() == 0) {
                //如果没有查询到，则插入一条数据(店名 日期 营业额 客流量 平均销售额 )
                OrderSalesStatistics salesStatistics1 = new OrderSalesStatistics();
                salesStatistics1.setSId(doororder.getsId());
                salesStatistics1.setDate(time);
                salesStatistics1.setTurnover(b);
                salesStatistics1.setPassengerFlow(1);
                //divide()方法的第一个参数是除数，第二个参数是舍入模式。BigDecimal.ROUND_HALF_UP表示四舍五入
                BigDecimal passengerFlow = new BigDecimal(salesStatistics1.getPassengerFlow());
                salesStatistics1.setAvgSales(b.divide(passengerFlow, BigDecimal.ROUND_HALF_UP));
                //插入一条数据
                int i2 = salesStatisticsService.insertSalesStatistics(salesStatistics1);
                if (i2 > 0) {
                    System.out.println("插入成功salesStatistics1");
                } else {
                    System.out.println("插入失败salesStatistics1");
                }
            } else {
                OrderSalesStatistics salesStatistics2 = list.get(0);
                //总金额
                BigDecimal turnover = salesStatistics2.getTurnover();
                //客流量
                Integer passengerFlow = salesStatistics2.getPassengerFlow();
                //更新这条数据
                salesStatistics2.setTurnover(turnover.add(b));
                BigDecimal turnover1 = salesStatistics2.getTurnover();
                salesStatistics2.setPassengerFlow(passengerFlow + 1);
                BigDecimal passengerFlow2 = new BigDecimal(salesStatistics2.getPassengerFlow());
                salesStatistics2.setAvgSales(turnover1.divide(passengerFlow2, BigDecimal.ROUND_HALF_UP));
                int i3 = salesStatisticsService.updateSalesStatistics(salesStatistics2);
                if (i3 > 0) {
                    System.out.println("成功更新salesStatistics2");
                } else {
                    System.out.println("更新失败salesStatistics2");
                }
            }
        }
        // 返回成功的响应
        return ResponseEntity.ok().build();
    }


    //支付宝支付
    @PostMapping("/alipay")
    public ResponseEntity<List<String>> alipay(@RequestBody OrderPaymentInfo paymentInfo) {
        // 你现在可以访问paymentInfo中的数据了
        String shopName = paymentInfo.getShopName();
        String sum = paymentInfo.getSum();
        String quantity = paymentInfo.getQuantity();
        String orderNumber = OrderUtil.generateOrderNumber();
        System.out.println(shopName + " " + sum + " " + quantity + " " + orderNumber);
        //调用alipay接口进行支付
        String s = Cs.test_trade_precreate(shopName, sum, quantity, orderNumber);
        System.out.println(s);
        //设置定时任务(定时删除生成的二维码)
        DeleteFile.del(s);//定时任务30分钟
        List<String> list = new ArrayList<>();
        list.add(orderNumber);
        //将图片转换成字节流
        byte[] bytes = ByteStream.imageToBytes(s);
        System.out.println(Arrays.toString(bytes));
        if (s == null) {
            list.add("异常");
            return ResponseEntity.ok(list);
        } else {
            String base64Image = Base64.getEncoder().encodeToString(bytes);
            list.add(base64Image);
            return ResponseEntity.ok(list);
        }
    }

    @PostMapping("/selectalipay")
    public ResponseEntity<String> selectalipay(String numberPart) {
        //查询订单
        System.out.println(numberPart);
        String s = Cs.test_trade_query(numberPart);
        System.out.println(s);
        return ResponseEntity.ok(s);
    }
}