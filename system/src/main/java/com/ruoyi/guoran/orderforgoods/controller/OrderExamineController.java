package com.ruoyi.guoran.orderforgoods.controller;


import com.ruoyi.guoran.orderforgoods.domain.OrderReturnParticulars;
import com.ruoyi.guoran.orderforgoods.domain.OrderReturnStatistics;
import com.ruoyi.guoran.orderforgoods.domain.OrderReturnorderdetails;
import com.ruoyi.guoran.orderforgoods.domain.OrderStoreinventory;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderReturnParticularsServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderReturnStatisticsServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderReturnorderdetailsServiceImpl;
import com.ruoyi.guoran.orderforgoods.service.impl.OrderStoreinventoryServiceImpl;
import com.ruoyi.guoran.orderforgoods.utility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/28 10:36
 */

@RestController
@CrossOrigin
@RequestMapping("/examine")
public class OrderExamineController {
    @Autowired
    private OrderReturnorderdetailsServiceImpl returnorderdetailsService;
    @Autowired
    private OrderReturnStatisticsServiceImpl rs;
    @Autowired
    private OrderReturnParticularsServiceImpl rp;
    @Autowired
    private OrderStoreinventoryServiceImpl si;

    @PostMapping("/pass")
    public ResponseEntity<String> pssss(@RequestBody OrderReturnorderdetails returnorderdetails) {
        OrderReturnorderdetails returnorderdetails1 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails.getRdId());
        System.out.println(returnorderdetails1);
        returnorderdetails1.setExamine(1);
        int i = returnorderdetailsService.updateReturnorderdetails(returnorderdetails1);
        if (i > 0) {
            OrderReturnorderdetails returnorderdetails2 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails.getRdId());
            Date time = TimeUtil.getCurrentTime();
            //退货统计
            OrderReturnStatistics returnStatistics = new OrderReturnStatistics();
            //退货: 门店 水果编号 重量 最后更新时间
            returnStatistics.setsId(returnorderdetails2.getSId());
            returnStatistics.setFruitId(returnorderdetails2.getFruitId());
            List<OrderReturnStatistics> lr = rs.selectReturnStatisticsList(returnStatistics);
            if (!lr.isEmpty()) {
                for (OrderReturnStatistics statistics : lr) {
                    returnStatistics.setRdCount(statistics.getRdCount().add(returnorderdetails2.getRdCount()));
                    returnStatistics.setReturnTime(time);
                    int i1 = rs.updateReturnStatisticsBySIdAndFruitId(returnStatistics);
                    if (i1 > 0) {
                        System.out.println("returnStatistics更新成功");
                    } else {
                        System.out.println("returnStatistics更新失败");
                    }
                }
            } else {
                returnStatistics.setRdCount(returnorderdetails2.getRdCount());
                returnStatistics.setReturnTime(time);
                int i12 = rs.insertReturnStatistics(returnStatistics);
                if (i12 > 0) {
                    System.out.println("returnStatistics添加成功");
                } else {
                    System.out.println("returnStatistics添加失败");
                }
            }

            //详情
            OrderReturnParticulars returnParticulars = new OrderReturnParticulars();
            returnParticulars.setRdNumber(returnorderdetails2.getRdNumber());
            returnParticulars.setTime(time);
            returnParticulars.setJudge(0);
            returnParticulars.setSId(returnorderdetails2.getSId());
            returnParticulars.setFruitId(returnorderdetails2.getFruitId());
            returnParticulars.setRdCount(returnorderdetails2.getRdCount());
            int i2 = rp.insertReturnParticulars(returnParticulars);
            if (i2 > 0) {
                System.out.println("returnParticulars添加成功");
            } else {
                System.out.println("returnParticulars添加失败");
            }
            return ResponseEntity.ok("审核成功");
        } else {
            return ResponseEntity.ok("审核失败");
        }
    }

    @PostMapping("/nopass")
    public ResponseEntity<String> nppass(@RequestBody OrderReturnorderdetails returnorderdetails) {
        OrderReturnorderdetails returnorderdetails1 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails.getRdId());
        returnorderdetails1.setExamine(2);
        int i = returnorderdetailsService.updateReturnorderdetails(returnorderdetails1);
        if (i > 0) {
            OrderReturnorderdetails returnorderdetails3 = new OrderReturnorderdetails();
            returnorderdetails3.setRdId(returnorderdetails.getRdId());
            //查询退货单详情
            OrderReturnorderdetails returnorderdetails2 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails3.getRdId());
            Date time = TimeUtil.getCurrentTime();
            OrderReturnParticulars returnParticulars = new OrderReturnParticulars();
            returnParticulars.setRdNumber(returnorderdetails2.getRdNumber());
            returnParticulars.setTime(time);
            returnParticulars.setJudge(1);
            returnParticulars.setSId(returnorderdetails2.getSId());
            returnParticulars.setFruitId(returnorderdetails2.getFruitId());
            returnParticulars.setRdCount(returnorderdetails2.getRdCount());
            int i2 = rp.insertReturnParticulars(returnParticulars);
            if (i2 > 0) {
                System.out.println("returnParticulars添加成功");
            } else {
                System.out.println("returnParticulars添加失败");
            }
            //向门店返回数据
            OrderStoreinventory storeinventory = new OrderStoreinventory();
            //根据FruitId(水果id)查询
            storeinventory.setFruitId(returnorderdetails2.getFruitId());
            for (OrderStoreinventory storeinventory1 : si.selectStoreinventoryList(storeinventory)) {
                //更新库存
                BigDecimal number = storeinventory1.getNumber();
                BigDecimal rdCount = returnorderdetails2.getRdCount();
                storeinventory1.setNumber(number.add(rdCount));
                int i1 = si.updateStoreinventory(storeinventory1);
                if (i1 > 0) {
                    System.out.println(storeinventory1);
                    System.out.println("storeinventory更新成功");
                } else {
                    System.out.println("storeinventory更新失败");
                }
            }
            return ResponseEntity.ok("审核成功,未通过");
        } else {
            return ResponseEntity.ok("审核失败");
        }
    }

    @PostMapping("/your")
    public ResponseEntity<List<OrderReturnParticulars>> getReturnStatistics(@RequestBody Map<String, String> params) {
        String sId = params.get("sId");
        System.out.println(sId+"*************************************************");
        String fruitId = params.get("fruitId");
        System.out.println(fruitId);
        OrderReturnParticulars returnParticulars= new OrderReturnParticulars();
        returnParticulars.setSId(sId);
        returnParticulars.setFruitId(fruitId);
        List<OrderReturnParticulars> list =rp.getReturnParticularsBySIdAndFruitId(returnParticulars.getSId(),returnParticulars.getFruitId());
        for (OrderReturnParticulars statistics : list) {
            System.out.println(statistics);
        }
        return ResponseEntity.ok(list);
    }
}
