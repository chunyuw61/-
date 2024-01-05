package com.ruoyi.guoran.orderforgoods.utility;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


public class DeleteFile {
    //设置定时删除
    public static void del(String s) {
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiik");
        // 设置要删除的文件路径
        String filePath = s;

        // 创建一个定时器
        Timer timer = new Timer();

        // 定时任务：删除指定的文件
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                File file = new File(filePath);
                System.out.println("定时删除以启动，二维码30分钟后销毁");
                if (file.exists()) {
                    boolean result = file.delete();
                    if (result) {
                        System.out.println("成功删除文件: " + file.getName());
                    } else {
                        System.out.println("无法删除文件: " + file.getName());
                    }
                }
            }
        };

        // 设置定时器在10秒后执行定时任务
        long delay = 30 * 60 * 1000;  // 定时30分钟
        timer.schedule(task, delay);
    }
}
