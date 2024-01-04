package com.ruoyi.guoran.orderforgood.utility;

import java.util.Calendar;
import java.util.Date;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 20:28
 */

public class TimeUtil {

    /**
     * 获取当前时间
     * @return 当前时间，精确到时分秒
     */
    public static Date getCurrentTime() {
        return new Date();
    }

    /**
     * 获取当前日期
     * @return 当前日期，精确到日
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
