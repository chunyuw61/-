package com.ruoyi.guoran.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进货单明细对象 purchaseorderdetails
 * 
 * @author 24k纯帅
 * @date 2023-12-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Purchaseorderdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long pId;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sId;

    /** 水果进货单号 */
    @Excel(name = "水果进货单号")
    private String pNumber;

    /** 水果种类 */
    @Excel(name = "水果种类编号")
    private Long fruittypesId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String fruitName;

    /** 数量 */
    @Excel(name = "数量")
    private Double number;

    /** 进货单价 */
    @Excel(name = "进货单价")
    private BigDecimal price;

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

    /** 状态 */
    private Long isStatus;

    private String s_number;



    public Purchaseorderdetails(Long pId,String sId, String pNumber, Long fruittypesId, String fruitId, String fruitName, Double number, BigDecimal price) {
        this.pId = pId;
        this.sId = sId;
        this.pNumber = pNumber;
        this.fruittypesId = fruittypesId;
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.number = number;
        this.price = price;
    }

    public void setpId(Long pId)
    {
        this.pId = pId;
    }

    public Long getpId() 
    {
        return pId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public Long getFruittypesId() {
        return fruittypesId;
    }

    public void setFruittypesId(Long fruittypesId) {
        this.fruittypesId = fruittypesId;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
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

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }

    @Override
    public String toString() {
        return "Purchaseorderdetails{" +
                "pId=" + pId +
                ", sId='" + sId + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", fruittypesId=" + fruittypesId +
                ", fruitId='" + fruitId + '\'' +
                ", fruitName='" + fruitName + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", REVISION=" + REVISION +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", isStatus=" + isStatus +
                ", s_number='" + s_number + '\'' +
                '}';
    }
}
