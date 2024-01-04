package com.ruoyi.statistics.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

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

    /** 是否被删除 */
    @Excel(name = "是否被删除")
    private Long isStatus;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createdBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdTime;

    public void setSalesStatisticId(Long salesStatisticId) 
    {
        this.salesStatisticId = salesStatisticId;
    }

    public Long getSalesStatisticId() 
    {
        return salesStatisticId;
    }
    public void setoId(Long oId) 
    {
        this.oId = oId;
    }

    public Long getoId() 
    {
        return oId;
    }
    public void setsId(String sId) 
    {
        this.sId = sId;
    }

    public String getsId() 
    {
        return sId;
    }
    public void setDate(Date date) 
    {
        this.date = date;
    }

    public Date getDate() 
    {
        return date;
    }
    public void setTurnover(BigDecimal turnover) 
    {
        this.turnover = turnover;
    }

    public BigDecimal getTurnover() 
    {
        return turnover;
    }
    public void setPassengerFlow(Integer passengerFlow) 
    {
        this.passengerFlow = passengerFlow;
    }

    public Integer getPassengerFlow() 
    {
        return passengerFlow;
    }
    public void setAvgSales(BigDecimal avgSales) 
    {
        this.avgSales = avgSales;
    }

    public BigDecimal getAvgSales() 
    {
        return avgSales;
    }
    public void setRevision(Long revision) 
    {
        this.revision = revision;
    }

    public Long getRevision() 
    {
        return revision;
    }
    public void setIsStatus(Long isStatus) 
    {
        this.isStatus = isStatus;
    }

    public Long getIsStatus() 
    {
        return isStatus;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("salesStatisticId", getSalesStatisticId())
            .append("oId", getoId())
            .append("sId", getsId())
            .append("date", getDate())
            .append("turnover", getTurnover())
            .append("passengerFlow", getPassengerFlow())
            .append("avgSales", getAvgSales())
            .append("revision", getRevision())
            .append("isStatus", getIsStatus())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
