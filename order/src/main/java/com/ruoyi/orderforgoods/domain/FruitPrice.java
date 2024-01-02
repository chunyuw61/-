package com.ruoyi.orderforgoods.domain;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 14:59
 */


import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 设价对象 fruit_price
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public class FruitPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long pId;

    /** 水果表外键 */
    private Long fruitId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String code;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String name;

    /** 最大金额 */
    @Excel(name = "最大金额")
    private BigDecimal maxprice;

    /** 零售价 */
    @Excel(name = "零售价")
    private BigDecimal price;

    /** 折扣 */
    @Excel(name = "折扣")
    private BigDecimal zhekou;

    /** 乐观锁 */
    private Long REVISION;

    /** 创建人 */
    private String createdBy;

    /** 创建时间 */
    private Date createdTime;

    /** 更新人 */
    private String updatedBy;

    /** 更新时间 */
    private Date updatedTime;

    public void setpId(Long pId)
    {
        this.pId = pId;
    }

    public Long getpId()
    {
        return pId;
    }
    public void setFruitId(Long fruitId)
    {
        this.fruitId = fruitId;
    }

    public Long getFruitId()
    {
        return fruitId;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setMaxprice(BigDecimal maxprice)
    {
        this.maxprice = maxprice;
    }

    public BigDecimal getMaxprice()
    {
        return maxprice;
    }
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getPrice()
    {
        return price;
    }
    public void setZhekou(BigDecimal zhekou)
    {
        this.zhekou = zhekou;
    }

    public BigDecimal getZhekou()
    {
        return zhekou;
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
                .append("pId", getpId())
                .append("fruitId", getFruitId())
                .append("code", getCode())
                .append("name", getName())
                .append("maxprice", getMaxprice())
                .append("price", getPrice())
                .append("zhekou", getZhekou())
                .append("REVISION", getREVISION())
                .append("createdBy", getCreatedBy())
                .append("createdTime", getCreatedTime())
                .append("updatedBy", getUpdatedBy())
                .append("updatedTime", getUpdatedTime())
                .toString();
    }
}

