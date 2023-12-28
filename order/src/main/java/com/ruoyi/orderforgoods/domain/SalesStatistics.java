package com.ruoyi.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售统计对象 sales_statistics
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public class SalesStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long salesStatisticId;

    /** 订单表id */
    @Excel(name = "订单表id")
    private Long oId;

    /** 门店信息表id */
    @Excel(name = "门店信息表id")
    private String sId;

    /** 日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date date;

    /** 营业额 */
    @Excel(name = "营业额")
    private BigDecimal turnover;

    /** 客流量 */
    @Excel(name = "客流量")
    private Integer passengerFlow;

    /** 平均销售额 由来客人数/营业额 */
    @Excel(name = "平均销售额 由来客人数/营业额")
    private BigDecimal avgSales;

    /** 乐观锁 */
    @Excel(name = "乐观锁")
    private Long revision;

    /** 是否被删除

 */
    @Excel(name = "是否被删除 ")
    private Long isStatus;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;


    public SalesStatistics() {
    }

    public SalesStatistics(long serialVersionUID, Long salesStatisticId, Long oId, String sId, Date date, BigDecimal turnover, Integer passengerFlow, BigDecimal avgSales, Long revision, Long isStatus, String createdBy, Date createdTime) {

        this.salesStatisticId = salesStatisticId;
        this.oId = oId;
        this.sId = sId;
        this.date = date;
        this.turnover = turnover;
        this.passengerFlow = passengerFlow;
        this.avgSales = avgSales;
        this.revision = revision;
        this.isStatus = isStatus;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
    }

    /**
     * 获取
     * @return salesStatisticId
     */
    public Long getSalesStatisticId() {
        return salesStatisticId;
    }

    /**
     * 设置
     * @param salesStatisticId
     */
    public void setSalesStatisticId(Long salesStatisticId) {
        this.salesStatisticId = salesStatisticId;
    }

    /**
     * 获取
     * @return oId
     */
    public Long getOId() {
        return oId;
    }

    /**
     * 设置
     * @param oId
     */
    public void setOId(Long oId) {
        this.oId = oId;
    }

    /**
     * 获取
     * @return sId
     */
    public String getSId() {
        return sId;
    }

    /**
     * 设置
     * @param sId
     */
    public void setSId(String sId) {
        this.sId = sId;
    }

    /**
     * 获取
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 获取
     * @return turnover
     */
    public BigDecimal getTurnover() {
        return turnover;
    }

    /**
     * 设置
     * @param turnover
     */
    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    /**
     * 获取
     * @return passengerFlow
     */
    public Integer getPassengerFlow() {
        return passengerFlow;
    }

    /**
     * 设置
     * @param passengerFlow
     */
    public void setPassengerFlow(Integer passengerFlow) {
        this.passengerFlow = passengerFlow;
    }

    /**
     * 获取
     * @return avgSales
     */
    public BigDecimal getAvgSales() {
        return avgSales;
    }

    /**
     * 设置
     * @param avgSales
     */
    public void setAvgSales(BigDecimal avgSales) {
        this.avgSales = avgSales;
    }

    /**
     * 获取
     * @return revision
     */
    public Long getRevision() {
        return revision;
    }

    /**
     * 设置
     * @param revision
     */
    public void setRevision(Long revision) {
        this.revision = revision;
    }

    /**
     * 获取
     * @return isStatus
     */
    public Long getIsStatus() {
        return isStatus;
    }

    /**
     * 设置
     * @param isStatus
     */
    public void setIsStatus(Long isStatus) {
        this.isStatus = isStatus;
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

    public String toString() {
        return "SalesStatistics{serialVersionUID = " + serialVersionUID + ", salesStatisticId = " + salesStatisticId + ", oId = " + oId + ", sId = " + sId + ", date = " + date + ", turnover = " + turnover + ", passengerFlow = " + passengerFlow + ", avgSales = " + avgSales + ", revision = " + revision + ", isStatus = " + isStatus + ", createdBy = " + createdBy + ", createdTime = " + createdTime + "}";
    }
}
