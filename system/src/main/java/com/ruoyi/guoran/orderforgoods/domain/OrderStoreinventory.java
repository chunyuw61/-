package com.ruoyi.guoran.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 门店库存对象 storeinventory
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public class OrderStoreinventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long inentorydetailsId;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String shopId;

    /** 水果种类编号 */
    @Excel(name = "水果种类编号")
    private String fruittypesId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 重量 */
    @Excel(name = "重量")
    private BigDecimal number;

    /** 状态 */
    @Excel(name = "状态")
    private Long isStatus;

    /** 乐观锁 */
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

    public void setInentorydetailsId(Long inentorydetailsId) 
    {
        this.inentorydetailsId = inentorydetailsId;
    }

    public Long getInentorydetailsId() 
    {
        return inentorydetailsId;
    }
    public void setShopId(String shopId) 
    {
        this.shopId = shopId;
    }

    public String getShopId() 
    {
        return shopId;
    }
    public void setFruittypesId(String fruittypesId) 
    {
        this.fruittypesId = fruittypesId;
    }

    public String getFruittypesId() 
    {
        return fruittypesId;
    }
    public void setFruitId(String fruitId) 
    {
        this.fruitId = fruitId;
    }

    public String getFruitId() 
    {
        return fruitId;
    }
    public void setNumber(BigDecimal number) 
    {
        this.number = number;
    }

    public BigDecimal getNumber() 
    {
        return number;
    }
    public void setIsStatus(Long isStatus) 
    {
        this.isStatus = isStatus;
    }

    public Long getIsStatus() 
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
            .append("inentorydetailsId", getInentorydetailsId())
            .append("shopId", getShopId())
            .append("fruittypesId", getFruittypesId())
            .append("fruitId", getFruitId())
            .append("number", getNumber())
            .append("isStatus", getIsStatus())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
