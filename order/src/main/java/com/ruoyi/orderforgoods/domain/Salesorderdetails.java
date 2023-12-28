package com.ruoyi.orderforgoods.domain;

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
public class Salesorderdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    @Excel(name = "主键id")
    private Long salesorderdetailsId;

    /** 订单编号 销售订单的外键 */
    @Excel(name = "订单编号 销售订单的外键")
    private String oId;

    /** 水果编号 水果价格表的外键 */
    @Excel(name = "水果编号 水果价格表的外键")
    private String fruitpriceId;

    /** 数量 购买水果的数量 */
    @Excel(name = "重量 购买水果的重量")
    private BigDecimal count;

    /** 单品金额 水果单价 */
    @Excel(name = "单品金额 水果单价")
    private BigDecimal money;

    /** 金额 数量X单价 */
    @Excel(name = "金额 数量X单价")
    private BigDecimal totalmoney;

    /** 消费时间 购买时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "消费时间 购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datetime;

    /** 乐观锁 */
    @Excel(name = "乐观锁")
    private Long REVISION;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    /** 更新人 */
    @Excel(name = "更新人")
    private String updatedBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedTime;


    public Salesorderdetails() {
    }

    public Salesorderdetails(long serialVersionUID, Long salesorderdetailsId, String oId, String fruitpriceId, BigDecimal count, BigDecimal money, BigDecimal totalmoney, Date datetime, Long REVISION, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {

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
    }

    /**
     * 获取
     * @return salesorderdetailsId
     */
    public Long getSalesorderdetailsId() {
        return salesorderdetailsId;
    }

    /**
     * 设置
     * @param salesorderdetailsId
     */
    public void setSalesorderdetailsId(Long salesorderdetailsId) {
        this.salesorderdetailsId = salesorderdetailsId;
    }

    /**
     * 获取
     * @return oId
     */
    public String getOId() {
        return oId;
    }

    /**
     * 设置
     * @param oId
     */
    public void setOId(String oId) {
        this.oId = oId;
    }

    /**
     * 获取
     * @return fruitpriceId
     */
    public String getFruitpriceId() {
        return fruitpriceId;
    }

    /**
     * 设置
     * @param fruitpriceId
     */
    public void setFruitpriceId(String fruitpriceId) {
        this.fruitpriceId = fruitpriceId;
    }

    /**
     * 获取
     * @return count
     */
    public BigDecimal getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(BigDecimal count) {
        this.count = count;
    }

    /**
     * 获取
     * @return money
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 获取
     * @return totalmoney
     */
    public BigDecimal getTotalmoney() {
        return totalmoney;
    }

    /**
     * 设置
     * @param totalmoney
     */
    public void setTotalmoney(BigDecimal totalmoney) {
        this.totalmoney = totalmoney;
    }

    /**
     * 获取
     * @return datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * 设置
     * @param datetime
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * 获取
     * @return REVISION
     */
    public Long getREVISION() {
        return REVISION;
    }

    /**
     * 设置
     * @param REVISION
     */
    public void setREVISION(Long REVISION) {
        this.REVISION = REVISION;
    }

    /**
     * 获取
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取
     * @return createdTime
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置
     * @param createdTime
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取
     * @return updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取
     * @return updatedTime
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置
     * @param updatedTime
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String toString() {
        return "Salesorderdetails{serialVersionUID = " + serialVersionUID + ", salesorderdetailsId = " + salesorderdetailsId + ", oId = " + oId + ", fruitpriceId = " + fruitpriceId + ", count = " + count + ", money = " + money + ", totalmoney = " + totalmoney + ", datetime = " + datetime + ", REVISION = " + REVISION + ", createdBy = " + createdBy + ", createdTime = " + createdTime + ", updatedBy = " + updatedBy + ", updatedTime = " + updatedTime + "}";
    }
}
