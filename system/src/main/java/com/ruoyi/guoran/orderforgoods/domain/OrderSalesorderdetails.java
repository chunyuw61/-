package com.ruoyi.guoran.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售订单明细对象 salesorderdetails
 *
 * @author ruoyi
 * @date 2023-12-25
 */
public class OrderSalesorderdetails extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @Excel(name = "主键id")
    private Long salesorderdetailsId;

    /**
     * 订单编号 销售订单的外键
     */
    @Excel(name = "订单编号 销售订单的外键")
    private String oId;

    /**
     * 水果编号 水果价格表的外键
     */
    @Excel(name = "水果编号 水果价格表的外键")
    private String fruitpriceId;

    /**
     * 数量 购买水果的数量
     */
    @Excel(name = "重量 购买水果的重量")
    private BigDecimal count;

    /**
     * 单品金额 水果单价
     */
    @Excel(name = "单品金额 水果单价")
    private BigDecimal money;

    /**
     * 金额 数量X单价
     */
    @Excel(name = "金额 数量X单价")
    private BigDecimal totalmoney;

    /**
     * 消费时间 购买时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "消费时间 购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datetime;

    /**
     * 乐观锁
     */
    @Excel(name = "乐观锁")
    private Long REVISION;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String createdBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /**
     * 更新人
     */
    @Excel(name = "更新人")
    private String updatedBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;

    /**
     * 门店编号 门店外键
     */
    private String sId;

    public Long getSalesorderdetailsId() {
        return salesorderdetailsId;
    }

    public void setSalesorderdetailsId(Long salesorderdetailsId) {
        this.salesorderdetailsId = salesorderdetailsId;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getFruitpriceId() {
        return fruitpriceId;
    }

    public void setFruitpriceId(String fruitpriceId) {
        this.fruitpriceId = fruitpriceId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Long getREVISION() {
        return REVISION;
    }

    public void setREVISION(Long REVISION) {
        this.REVISION = REVISION;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Salesorderdetails{" +
                "salesorderdetailsId=" + salesorderdetailsId +
                ", oId='" + oId + '\'' +
                ", fruitpriceId='" + fruitpriceId + '\'' +
                ", count=" + count +
                ", money=" + money +
                ", totalmoney=" + totalmoney +
                ", datetime=" + datetime +
                ", REVISION=" + REVISION +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", sId='" + sId + '\'' +
                '}';
    }

    public OrderSalesorderdetails(Long salesorderdetailsId, String oId, String fruitpriceId, BigDecimal count, BigDecimal money, BigDecimal totalmoney, Date datetime, Long REVISION, String createdBy, Date createdTime, String updatedBy, Date updatedTime, String sId) {
        this.salesorderdetailsId = salesorderdetailsId;
        this.oId = oId;
        this.fruitpriceId = fruitpriceId;
        this.count = count;
        this.money = money;
        this.totalmoney = totalmoney;
        this.datetime = datetime;
        this.REVISION = REVISION;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.sId = sId;
    }

    public OrderSalesorderdetails() {
    }
}
