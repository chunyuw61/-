package com.ruoyi.guoran.orderforgood.utility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 20:20
 */
public class OrderUtil {

    /**
     * 生成订单编号
     * 规则：当前时间的年月日时分秒+四位随机数
     * @return 订单编号
     */
    public static String generateOrderNumber() {
        // 获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());

        // 生成四位随机数
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;

        // 拼接成订单编号
        String orderNumber =  dateStr + rannum;

        return orderNumber;
    }
}