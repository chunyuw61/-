package com.ruoyi.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 退货单明细对象 returnorderdetails
 * 
 * @author chunyuw61
 * @date 2023-12-28
 */
public class Returnorderdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long rdId;

    /** 门店编号 门店外键 */
    @Excel(name = "门店编号 门店外键")
    private String sId;

    /** 入库单编号 入库单外键 */
    @Excel(name = "入库单编号 入库单外键")
    private Long warehousingId;

    /** 退货编号 退货单外键 */
    @Excel(name = "退货编号 退货单外键")
    private String rdNumber;

    /** 水果类型 */
    @Excel(name = "水果类型")
    private String fruittypesId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal rdCount;

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

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isStatus;

    /** 审批 */
    @Excel(name = "审批")
    private Integer examine;


    public Returnorderdetails() {
    }

    public Returnorderdetails(long serialVersionUID, Long rdId, String sId, Long warehousingId, String rdNumber, String fruittypesId, String fruitId, BigDecimal rdCount, Long REVISION, String createdBy, Date createdTime, String updatedBy, Date updatedTime, Long isStatus, Integer examine) {

        this.rdId = rdId;
        this.sId = sId;
        this.warehousingId = warehousingId;
        this.rdNumber = rdNumber;
        this.fruittypesId = fruittypesId;
        this.fruitId = fruitId;
        this.rdCount = rdCount;
        this.REVISION = REVISION;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.isStatus = isStatus;
        this.examine = examine;
    }

    /**
     * 获取
     * @return rdId
     */
    public Long getRdId() {
        return rdId;
    }

    /**
     * 设置
     * @param rdId
     */
    public void setRdId(Long rdId) {
        this.rdId = rdId;
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
     * @return warehousingId
     */
    public Long getWarehousingId() {
        return warehousingId;
    }

    /**
     * 设置
     * @param warehousingId
     */
    public void setWarehousingId(Long warehousingId) {
        this.warehousingId = warehousingId;
    }

    /**
     * 获取
     * @return rdNumber
     */
    public String getRdNumber() {
        return rdNumber;
    }

    /**
     * 设置
     * @param rdNumber
     */
    public void setRdNumber(String rdNumber) {
        this.rdNumber = rdNumber;
    }

    /**
     * 获取
     * @return fruittypesId
     */
    public String getFruittypesId() {
        return fruittypesId;
    }

    /**
     * 设置
     * @param fruittypesId
     */
    public void setFruittypesId(String fruittypesId) {
        this.fruittypesId = fruittypesId;
    }

    /**
     * 获取
     * @return fruitId
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * 设置
     * @param fruitId
     */
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * 获取
     * @return rdCount
     */
    public BigDecimal getRdCount() {
        return rdCount;
    }

    /**
     * 设置
     * @param rdCount
     */
    public void setRdCount(BigDecimal rdCount) {
        this.rdCount = rdCount;
    }

    /**
     * 获取
     * @return REVISION
     */
    public Long getREVISION() {
        return REVISION;
    }

    /**
     * 设置
     * @param REVISION
     */
    public void setREVISION(Long REVISION) {
        this.REVISION = REVISION;
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

    /**
     * 获取
     * @return updatedBy
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取
     * @return updatedTime
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置
     * @param updatedTime
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
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
     * @return examine
     */
    public Integer getExamine() {
        return examine;
    }

    /**
     * 设置
     * @param examine
     */
    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public String toString() {
        return "Returnorderdetails{serialVersionUID = " + serialVersionUID + ", rdId = " + rdId + ", sId = " + sId + ", warehousingId = " + warehousingId + ", rdNumber = " + rdNumber + ", fruittypesId = " + fruittypesId + ", fruitId = " + fruitId + ", rdCount = " + rdCount + ", REVISION = " + REVISION + ", createdBy = " + createdBy + ", createdTime = " + createdTime + ", updatedBy = " + updatedBy + ", updatedTime = " + updatedTime + ", isStatus = " + isStatus + ", examine = " + examine + "}";
    }
}
