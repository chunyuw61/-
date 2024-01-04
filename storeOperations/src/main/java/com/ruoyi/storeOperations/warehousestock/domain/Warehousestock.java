package com.ruoyi.storeOperations.warehousestock.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订货对象 warehousestock
 * 
 * @author 24K纯帅
 * @date 2023-12-26
 */
public class Warehousestock extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long whId;

    /** 仓库编号 */
    @Excel(name = "仓库编号")
    private String wId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 水果种类编号 */
    @Excel(name = "水果种类编号")
    private Long fruittypesId;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String name;

    /** 进价 */
    @Excel(name = "进价")
    private BigDecimal jinjia;

    /** 数量 */
    @Excel(name = "数量")
    private Double whCount;

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

    /**  */
    private Long isStatus;

    private String code;

    private String img;


    public Warehousestock(Long whId, String wId, String img,String fruitId, Long fruittypesId, String name, BigDecimal jinjia, Double whCount) {
        this.whId = whId;
        this.wId = wId;
        this.img = img;
        this.fruitId = fruitId;
        this.fruittypesId = fruittypesId;
        this.name = name;
        this.jinjia = jinjia;
        this.whCount = whCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWhId(Long whId)
    {
        this.whId = whId;
    }

    public Long getWhId() 
    {
        return whId;
    }

    public String getwId() {
        return wId;
    }

    public void setwId(String wId) {
        this.wId = wId;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public Long getFruittypesId() {
        return fruittypesId;
    }

    public void setFruittypesId(Long fruittypesId) {
        this.fruittypesId = fruittypesId;
    }

    public void setFruitName(String name)
    {
        this.name = name;
    }

    public String getFruitName() 
    {
        return name;
    }
    public void setJinjia(BigDecimal jinjia)
    {
        this.jinjia = jinjia;
    }

    public BigDecimal getJinjia()
    {
        return jinjia;
    }
    public void setWhCount(Double whCount)
    {
        this.whCount = whCount;
    }

    public Double getWhCount()
    {
        return whCount;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Warehousestock{" +
                "whId=" + whId +
                ", wId='" + wId + '\'' +
                ", fruitId='" + fruitId + '\'' +
                ", fruittypesId=" + fruittypesId +
                ", name='" + name + '\'' +
                ", jinjia=" + jinjia +
                ", whCount=" + whCount +
                ", REVISION=" + REVISION +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                ", isStatus=" + isStatus +
                ", code='" + code + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
