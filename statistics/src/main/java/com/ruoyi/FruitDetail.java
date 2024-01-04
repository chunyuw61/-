package com.ruoyi;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 类的描述：
 * 作者：wmy
 * 时间：2024/1/2
 */

public class FruitDetail implements Serializable {

    // 水果订单编号
    private String fruitNum;

    // 水果名称
    private String fruitName;

    // 水果购买量
    private BigDecimal fruitCount;

    // 水果单价
    private BigDecimal unitPrice;

    // 水果总价
    private String allMoney;

    public FruitDetail(String fruitNum, String fruitName, BigDecimal fruitCount, BigDecimal unitPrice, String allMoney) {
        this.fruitNum = fruitNum;
        this.fruitName = fruitName;
        this.fruitCount = fruitCount;
        this.unitPrice = unitPrice;
        this.allMoney = allMoney;
    }

    public String getFruitNum() {
        return fruitNum;
    }

    public void setFruitNum(String fruitNum) {
        this.fruitNum = fruitNum;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public BigDecimal getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(BigDecimal fruitCount) {
        this.fruitCount = fruitCount;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(String allMoney) {
        this.allMoney = allMoney;
    }

    @Override
    public String toString() {
        return "FruitDetail{" +
                "fruitNum='" + fruitNum + '\'' +
                ", fruitName='" + fruitName + '\'' +
                ", fruitCount=" + fruitCount +
                ", unitPrice=" + unitPrice +
                ", allMoney='" + allMoney + '\'' +
                '}';
    }
}
