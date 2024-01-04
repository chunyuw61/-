package com.ruoyi.guoran.orderforgood.controller;

import com.ruoyi.guoran.orderforgood.service.impl.ReturnParticularsServiceImpl;
import com.ruoyi.guoran.domain.ReturnParticulars;
import com.ruoyi.guoran.domain.ReturnStatistics;
import com.ruoyi.guoran.domain.Returnorderdetails;
import com.ruoyi.guoran.domain.Storeinventory;
import com.ruoyi.guoran.orderforgood.service.impl.ReturnStatisticsServiceImpl;
import com.ruoyi.guoran.orderforgood.service.impl.ReturnorderdetailsServiceImpl;
import com.ruoyi.guoran.orderforgood.service.impl.StoreInventoryServiceImpl;
import com.ruoyi.guoran.orderforgood.utility.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
public class ExamineController {
    @Autowired
    private ReturnorderdetailsServiceImpl returnorderdetailsService;
    @Autowired
    private ReturnStatisticsServiceImpl rs;
    @Autowired
    private ReturnParticularsServiceImpl rp;
    @Autowired
    private StoreInventoryServiceImpl si;

    @PostMapping("/pass")
    public ResponseEntity<String> pssss(@RequestBody Returnorderdetails returnorderdetails) {
        Returnorderdetails returnorderdetails1 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails.getRdId());
        System.out.println(returnorderdetails1);
        returnorderdetails1.setExamine(1);
        int i = returnorderdetailsService.updateReturnorderdetails(returnorderdetails1);
        if (i > 0) {
            Returnorderdetails returnorderdetails2 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails.getRdId());
            Date time = TimeUtil.getCurrentTime();
            //退货统计
            ReturnStatistics returnStatistics = new ReturnStatistics();
            //退货: 门店 水果编号 重量 最后更新时间
            returnStatistics.setsId(returnorderdetails2.getSId());
            returnStatistics.setFruitId(returnorderdetails2.getFruitId());
            List<ReturnStatistics> lr = rs.selectReturnStatisticsList(returnStatistics);
            if (!lr.isEmpty()) {
                for (ReturnStatistics statistics : lr) {
                    returnStatistics.setRdCount(statistics.getRdCount() + returnorderdetails2.getRdCount());
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
            ReturnParticulars returnParticulars = new ReturnParticulars();
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
    public ResponseEntity<String> nppass(@RequestBody Returnorderdetails returnorderdetails) {
        Returnorderdetails returnorderdetails1 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails.getRdId());
        returnorderdetails1.setExamine(2);
        int i = returnorderdetailsService.updateReturnorderdetails(returnorderdetails1);
        if (i > 0) {
            Returnorderdetails returnorderdetails3 = new Returnorderdetails();
            returnorderdetails3.setRdId(returnorderdetails.getRdId());
            //查询退货单详情
            Returnorderdetails returnorderdetails2 = returnorderdetailsService.selectReturnorderdetailsByRdId(returnorderdetails3.getRdId());
            Date time = TimeUtil.getCurrentTime();
            ReturnParticulars returnParticulars = new ReturnParticulars();
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
            Storeinventory storeinventory = new Storeinventory();
            //根据FruitId(水果id)查询
            storeinventory.setFruitId(returnorderdetails2.getFruitId());
            for (Storeinventory storeinventory1 : si.selectStoreinventoryList(storeinventory)) {
                //更新库存
                Double number = storeinventory1.getNumber();
                Double rdCount = returnorderdetails2.getRdCount();
                storeinventory1.setNumber(number + rdCount);
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
    public ResponseEntity<List<ReturnParticulars>> getReturnStatistics(@RequestBody Map<String, String> params) {
        String sId = params.get("sId");
        System.out.println(sId+"*************************************************");
        String fruitId = params.get("fruitId");
        System.out.println(fruitId);
        ReturnParticulars returnParticulars= new ReturnParticulars();
        returnParticulars.setSId(sId);
        returnParticulars.setFruitId(fruitId);
        List<ReturnParticulars> list =rp.getReturnParticularsBySIdAndFruitId(returnParticulars.getSId(),returnParticulars.getFruitId());
        for (ReturnParticulars statistics : list) {
            System.out.println(statistics);
        }
        return ResponseEntity.ok(list);
    }
}
