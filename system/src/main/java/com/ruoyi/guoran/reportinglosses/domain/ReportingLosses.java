package com.ruoyi.guoran.reportinglosses.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.guoran.domain.Fruits;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报损信息对象 reportinglosses
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
public class ReportingLosses extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long rId;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sId;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String oId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date datetime;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitsId;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal number;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    /** 单品总价 */
    @Excel(name = "单品总价")
    private BigDecimal totalPrice;

    /** 报损原因 */
    @Excel(name = "报损原因")
    private String cause;

    /** 状态 */
    @Excel(name = "状态")
    private Integer isStatus;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updatedTime;

    private Fruits fruits;

    public Fruits getFruits() {
        return fruits;
    }

    public void setFruits(Fruits fruits) {
        this.fruits = fruits;
    }

    public ReportingLosses() {
    }

    public ReportingLosses(String sId, String oId, Date datetime, String fruitsId, BigDecimal number, BigDecimal unitPrice, BigDecimal totalPrice, String cause) {
        this.sId = sId;
        this.oId = oId;
        this.datetime = datetime;
        this.fruitsId = fruitsId;
        this.number = number;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.cause = cause;
    }



    public void setrId(Long rId) 
    {
        this.rId = rId;
    }

    public Long getrId() 
    {
        return rId;
    }
    public void setsId(String sId) 
    {
        this.sId = sId;
    }

    public String getsId() 
    {
        return sId;
    }
    public void setoId(String oId) 
    {
        this.oId = oId;
    }

    public String getoId() 
    {
        return oId;
    }
    public void setDatetime(Date datetime) 
    {
        this.datetime = datetime;
    }

    public Date getDatetime() 
    {
        return datetime;
    }
    public void setFruitsId(String fruitsId) 
    {
        this.fruitsId = fruitsId;
    }

    public String getFruitsId() 
    {
        return fruitsId;
    }
    public void setNumber(BigDecimal number) 
    {
        this.number = number;
    }

    public BigDecimal getNumber() 
    {
        return number;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setTotalPrice(BigDecimal totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice()
    {
        return totalPrice;
    }
    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }
    public void setIsStatus(Integer isStatus) 
    {
        this.isStatus = isStatus;
    }

    public Integer getIsStatus() 
    {
        return isStatus;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rId", getrId())
            .append("sId", getsId())
            .append("oId", getoId())
            .append("datetime", getDatetime())
            .append("fruitsId", getFruitsId())
            .append("number", getNumber())
            .append("unitPrice", getUnitPrice())
            .append("totalPrice", getTotalPrice())
            .append("cause", getCause())
            .append("isStatus", getIsStatus())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
