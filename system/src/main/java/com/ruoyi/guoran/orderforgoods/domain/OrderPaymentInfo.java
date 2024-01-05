package com.ruoyi.guoran.orderforgoods.domain;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2024/1/3 17:05
 */
public class OrderPaymentInfo {
    //店名
    private String shopName;
    //数量
    private String sum;
    //总金额
    private String quantity;

    public OrderPaymentInfo() {
    }

    public OrderPaymentInfo(String shopName, String sum, String quantity) {
        this.shopName = shopName;
        this.sum = sum;
        this.quantity = quantity;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "shopName='" + shopName + '\'' +
                ", sum='" + sum + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
