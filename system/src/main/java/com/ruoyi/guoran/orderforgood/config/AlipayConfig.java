package com.ruoyi.guoran.orderforgood.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {
    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "9021000132658674";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC7pNg1/LPKu24oNWPGzagVWDG4DUev0exH+bInnYyWn2Qchy04iRghvBqCk5QMglDWWbemRTFzNuUJmjcvfiM3VbQdvFl7W5c5O3E5eqVgSEnEc4pNtPZ+JuNJX8hAOrOnOIJTAqk2iUjbx7NPTrBuxR2Rnsm8Bjvbf7Ya2JRdJcY7jRC+Qebv2n1FLys/+HGnK6xyRZDQZYkf0yri5oZFu5WTomSyUfYscJmmXq/JM9XR9bLKTXIZBpqEF8N9XzSqIjyxdrgTZgqQdyCLE99KJfwizKCtr9MztXMYzTRQ4mqnKWytqAVsYWKllBWlFxfb6EcrKmMW7j8cntDuDNkZAgMBAAECggEAOZHiz/V/B+Unb+ipexYfyqSrZGeWpefHEXIXabYZqyCt617BzgWpxLfcflFe69OTj6ApCzdRa6Lc9Gw/IDAYB+MghrsBzSoVpHaLT3JEiNzE3SQBu8OYmK2/sARWAPbBpb1dprA7UEMgemWzqtJeqS2K2+GWzTwwYzC0o1ntcwIbHXKkxtzMTbLpR6Ld4rL0f23sYM56NLJhJZUMvRR3IrHAzs2jOqUwQQN3hicZStQntyrHcSPDEdvAVI98fJZcA80XJZPMkGdGdwh4P0QjZWmZNl2C4C22A2LcpYbqRC35PocnGVzVbjt8eFYvEwX2yPAdPvsU2MbTFLVTXLutvQKBgQD7zwHc9KqaCqQAfFECEBV8hmjGcPo/KeYMFoABLR3JB2aRPeZBAA2wWN9DdYTMKqFXwbVSa+z4NQ5R68Pk0AcH9CCGoH4X8bLx2+2zUgm1bMBBSXN3sbtiMIOZBsoMlKTM0rgMjUYtILzoDoa1sci8QboJla2lEAEZacTPtViqVwKBgQC+xGwbsTpEMXLZfcK0TRh0U8xPTRoInjpBIiZHaXQyX/IYtikZNuOwobNS77GznwMcnAqQUWaFZ6u2LKTHxYLyNLaK9dpcKpAi7MzDE8gDUYMh8IYZv4JV+0BqrJU+VUzjru3/+0HDYEtvlEf2Ml3a3xY9Fg/52yIDCSFg+i1SDwKBgBibDc+NiO4shAIYI8JT2AWnDK33dDyf137u4+s5gWOXeYpPxiQr4SqORKLO5P8eW027+//l0+4dIR0YMLg3K7i3PkZpgGjOkXHYz81qAtDbo529k67qiyj5HKLjavL3w3LQVHPFikn2nP8ADGHM0ZSzx34QRjuO6MyW7UhurA9ZAoGBAI5Z9HIVpe0NGS7CcXApt33WqjbiyfJ0X/QKj5XqUxLkFbvq8nAmTXGYuD/DLU9j8OaAakGW/HHAEpo2Zh/MexJR04WOQAtWl4f4PDO1pyMSyE+jM+4ywgd3HXJ8pkGFVYLxHhhOXZx1VtVESQ6mNvMEVYvv0qwXoSGyxn2fMgJxAoGBANUpr1yFzNCpPXwjFv0VNPDMhxsusfMIlyhdYgVnTIWNoNK0a2rBuYYs6a+mLriRaBtfUuUJyxkIdk1Z6Q5fx88yq5Uy5KvpI3p/wSiDmG29tJVazg8nTedSTQJVzWj7z4M56r6FAc/o4BhLsesCKEI/Qi+Ywa2BRyEXqTTeXIb2";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArUkrYORNN9G20KlClexw+P+1iXWmG5wEXjawxTsP3cJ6p9cOjQl2pLqFlh17F1m+ijvsAp+KK9zZlWlWEUoQqoW3J+x55k16QfBv8pRz4XFs33+6JGehuTpLF2vqpVvrHGi8HONdeU+8hOhc0aQ7Tw3V4qJu1e1YdGeuKXnn9fikF/Z/Anx/TSf9ODqce0l8b760gjuXaAdbSEWXzSut2lRRjlI7atVe628eRsWvvqkOR8WSw6gH8P7+6h2k415yb9pod5n3KbM2oH9fKW2+bylZEJhbjXNcbLFYtWv+f9XoZtKQqLciSpHPffaoeso/T43ceAqYfoAo1R5wolq6MwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /*public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";*/
    public static String notify_url = "http://chunyuw61-1.shanghai-01.dayunet.com:10120/index.html";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://18403553355.gnway.cc:80/success.html";


    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
