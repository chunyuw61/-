package com.ruoyi.guoran.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * orderforgoods对象 shopprice
 * 
 * @author chunyuw61
 * @date 2024-01-02
 */
public class OrderShopprice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long shoppriceId;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sNumber;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String code;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String name;

    /** 水果零售价 */
    @Excel(name = "水果零售价")
    private double price;

    /** 折扣 */
    @Excel(name = "折扣")
    private BigDecimal zhekou;

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

    public OrderShopprice() {
    }

    public OrderShopprice(Long shoppriceId, String sNumber, String code, String name, double price, BigDecimal zhekou, Long REVISION, String createdBy, Date createdTime, String updatedBy, Date updatedTime) {
        this.shoppriceId = shoppriceId;
        this.sNumber = sNumber;
        this.code = code;
        this.name = name;
        this.price = price;
        this.zhekou = zhekou;
        this.REVISION = REVISION;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
    }

    public Long getShoppriceId() {
        return shoppriceId;
    }

    public void setShoppriceId(Long shoppriceId) {
        this.shoppriceId = shoppriceId;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BigDecimal getZhekou() {
        return zhekou;
    }

    public void setZhekou(BigDecimal zhekou) {
        this.zhekou = zhekou;
    }

    public Long getREVISION() {
        return REVISION;
    }

    public void setREVISION(Long REVISION) {
        this.REVISION = REVISION;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "OrderShopprice{" +
                "shoppriceId=" + shoppriceId +
                ", sNumber='" + sNumber + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", zhekou=" + zhekou +
                ", REVISION=" + REVISION +
                ", createdBy='" + createdBy + '\'' +
                ", createdTime=" + createdTime +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }
}
