package com.ruoyi.orderforgoods.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.ruoyi.orderforgoods.config.AlipayConfig;
import com.ruoyi.orderforgoods.domain.Doororder;
import com.ruoyi.orderforgoods.domain.SalesStatistics;
import com.ruoyi.orderforgoods.domain.Salesorderdetails;
import com.ruoyi.orderforgoods.service.impl.DoororderServiceImpl;
import com.ruoyi.orderforgoods.service.impl.SalesStatisticsServiceImpl;
import com.ruoyi.orderforgoods.service.impl.SalesorderdetailsServiceImpl;
import com.ruoyi.orderforgoods.utility.OrderUtil;
import com.ruoyi.orderforgoods.utility.ShopUtil;
import com.ruoyi.orderforgoods.utility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 19:25
 */

@RestController
@RequestMapping("/salesorderdetails")
public class FruitOrderFormController {
    @Autowired
    private SalesorderdetailsServiceImpl salesorderdetailsService;

    @Autowired
    private DoororderServiceImpl doororderService;

    @Autowired
    private SalesStatisticsServiceImpl salesStatisticsService;

    // 使用@PostMapping注解来处理POST请求
    @PostMapping("/insert")
    public ResponseEntity<Void> insertSalesorderdetails(@RequestBody List<Salesorderdetails> salesorderdetailsList) {
        // 生成订单号
        String i = OrderUtil.generateOrderNumber();
        // 获取当前时间
        Date j = TimeUtil.getCurrentTime();
        // 创建一个新的Doororder对象
        Doororder doororder = new Doororder();
        // 设置门店ID
        doororder.setsId(ShopUtil.shopName());
        // 设置订单号
        doororder.setoNum(i);
        // 初始化总金额
        BigDecimal b = null;
        // 遍历销售订单明细列表
        for (Salesorderdetails salesorderdetails : salesorderdetailsList) {
            // 设置订单ID
            salesorderdetails.setOId(i);
            // 设置日期时间
            salesorderdetails.setDatetime(j);
            // 如果总金额为空，则设置总金额为当前销售订单明细的总金额
            if (b == null) {
                b = salesorderdetails.getTotalmoney();
            }
            // 插入销售订单明细
            salesorderdetailsService.insertSalesorderdetails(salesorderdetails);
        }
        // 设置Doororder的金额
        doororder.setMoney(b);
        // 插入Doororder
        int i1 = doororderService.insertDoororder(doororder);
        if (b == null) {
            System.out.println("金额为空,不算客流量");
        } else {
            //获取当前时间精确到天
            Date time = TimeUtil.getCurrentDate();
            System.out.println(time);
            //查询订单的所有信息
            SalesStatistics salesStatistics = new SalesStatistics();
            salesStatistics.setDate(time);
            salesStatistics.setSId(doororder.getsId());
            List<SalesStatistics> list = salesStatisticsService.selectSalesStatisticsList(salesStatistics);
            if (list.size() == 0) {
                //如果没有查询到，则插入一条数据(店名 日期 营业额 客流量 平均销售额 )
                SalesStatistics salesStatistics1 = new SalesStatistics();
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
                SalesStatistics salesStatistics2 = list.get(0);
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


    @RequestMapping("/payy")
    public void hello(HttpServletRequest request, HttpServletResponse out) throws AlipayApiException, IOException {

        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = request.getParameter("WIDout_trade_no");
        //付款金额，必填
        String total_amount = request.getParameter("WIDtotal_amount");
        //订单名称，必填
        String subject = request.getParameter("WIDsubject");
        //商品描述，可空
        String body = request.getParameter("WIDbody");

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"body\":\"" + body + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //输出
        out.getWriter().println(result);
        /*out.println(result);*/
    }
}