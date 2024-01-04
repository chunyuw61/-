package com.ruoyi.salesorderdetails.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.fruits.domain.Fruits;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门店退单对象 salesorderdetails
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
public class Salesorderdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long salesorderdetailsId;

    /** 订单编号 销售订单的外键 */
    @Excel(name = "订单编号 销售订单的外键")
    private String oId;

    /** 水果编号 水果价格表的外键 */
    @Excel(name = "水果编号 水果价格表的外键")
    private String fruitpriceId;

    /** 重量 购买水果的重量 */
    @Excel(name = "重量 购买水果的重量")
    private BigDecimal count;

    /** 单品金额 水果单价 */
    @Excel(name = "单品金额 水果单价")
    private BigDecimal money;

    /** 金额 数量X单价 */
    @Excel(name = "金额 数量X单价")
    private String totalmoney;

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

    /** 状态 */
    @Excel(name = "状态")
    private Long isStatus;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sId;


    public Salesorderdetails(Long salesorderdetailsId, String updatedBy, Date updatedTime) {
        this.salesorderdetailsId = salesorderdetailsId;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    public Salesorderdetails() {
    }

    private Fruits fruits;

    public Fruits getFruits() {
        return fruits;
    }

    public void setFruits(Fruits fruits) {
        this.fruits = fruits;
    }

    public Salesorderdetails(String oId) {
        this.oId = oId;
    }


    public void setSalesorderdetailsId(Long salesorderdetailsId) 
    {
        this.salesorderdetailsId = salesorderdetailsId;
    }

    public Long getSalesorderdetailsId() 
    {
        return salesorderdetailsId;
    }
    public void setoId(String oId) 
    {
        this.oId = oId;
    }

    public String getoId() 
    {
        return oId;
    }
    public void setFruitpriceId(String fruitpriceId) 
    {
        this.fruitpriceId = fruitpriceId;
    }

    public String getFruitpriceId() 
    {
        return fruitpriceId;
    }
    public void setCount(BigDecimal count) 
    {
        this.count = count;
    }

    public BigDecimal getCount() 
    {
        return count;
    }
    public void setMoney(BigDecimal money) 
    {
        this.money = money;
    }

    public BigDecimal getMoney() 
    {
        return money;
    }
    public void setTotalmoney(String totalmoney) 
    {
        this.totalmoney = totalmoney;
    }

    public String getTotalmoney() 
    {
        return totalmoney;
    }
    public void setDatetime(Date datetime) 
    {
        this.datetime = datetime;
    }

    public Date getDatetime() 
    {
        return datetime;
    }
    public void setREVISION(Long REVISION) 
    {
        this.REVISION = REVISION;
    }

    public Long getREVISION() 
    {
        return REVISION;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public String getCreatedBy() 
    {
        return createdBy;
    }
    public void setCreatedTime(Date createdTime) 
    {
        this.createdTime = createdTime;
    }

    public Date getCreatedTime() 
    {
        return createdTime;
    }
    public void setUpdatedBy(String updatedBy) 
    {
        this.updatedBy = updatedBy;
    }

    public String getUpdatedBy() 
    {
        return updatedBy;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }
    public void setIsStatus(Long isStatus) 
    {
        this.isStatus = isStatus;
    }

    public Long getIsStatus() 
    {
        return isStatus;
    }
    public void setsId(String sId) 
    {
        this.sId = sId;
    }

    public String getsId() 
    {
        return sId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("salesorderdetailsId", getSalesorderdetailsId())
            .append("oId", getoId())
            .append("fruitpriceId", getFruitpriceId())
            .append("count", getCount())
            .append("money", getMoney())
            .append("totalmoney", getTotalmoney())
            .append("datetime", getDatetime())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("isStatus", getIsStatus())
            .append("sId", getsId())
            .toString();
    }
}
