package com.ruoyi.inventory.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门店进货单明细和仓库出货单明细对象 purchaseorderdetails
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public class Purchaseorderdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    @Excel(name = "序号")
    private Long pId;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sId;

    /** 水果进货单号 */
    @Excel(name = "水果进货单号")
    private String pNumber;

    /** 水果种类 */
    @Excel(name = "水果种类编号")
    private String fruittypesId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String fruitName;

    /** 数量 来货数量 */
    @Excel(name = "数量 来货数量")
    private Double number;

    /** 进货单价 来货价 */
    @Excel(name = "进货单价 来货价")
    private BigDecimal price;

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

    /** 订单状态 */
    @Excel(name = "订单状态")
    private Long isStatus;

    public void setpId(Long pId) 
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }
    public void setsId(String sId)
    {
        this.sId = sId;
    }

    public String getsId()
    {
        return sId;
    }
    public void setpNumber(String pNumber)
    {
        this.pNumber = pNumber;
    }

    public String getpNumber()
    {
        return pNumber;
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
    public void setFruitName(String fruitName) 
    {
        this.fruitName = fruitName;
    }

    public String getFruitName() 
    {
        return fruitName;
    }
    public void setNumber(Double number)
    {
        this.number = number;
    }

    public Double getNumber()
    {
        return number;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pId", getpId())
            .append("sId", getsId())
            .append("pNumber", getpNumber())
            .append("fruittypesId", getFruittypesId())
            .append("fruitId", getFruitId())
            .append("fruitName", getFruitName())
            .append("number", getNumber())
            .append("price", getPrice())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("isStatus", getIsStatus())
            .toString();
    }
}
