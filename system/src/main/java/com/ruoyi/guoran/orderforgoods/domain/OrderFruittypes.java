package com.ruoyi.guoran.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 水果种类 水果的种类对象 fruittypes
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public class OrderFruittypes extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 主键id */
    private Long fruittypesId;

    /** 水果种类名称 */
    @Excel(name = "水果种类名称")
    private String name;

    /** 水果种类编号 */
    @Excel(name = "水果种类编号")
    private String code;

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

    /** 乐观锁 */
    @Excel(name = "乐观锁")
    private Long REVISION;

    /** 水果种类状态 */
    @Excel(name = "水果种类状态")
    private Long isStatus;


    public OrderFruittypes() {
    }

    public OrderFruittypes(long serialVersionUID, Long fruittypesId, String name, String code, String createdBy, Date createdTime, String updatedBy, Date updatedTime, Long REVISION, Long isStatus) {

        this.fruittypesId = fruittypesId;
        this.name = name;
        this.code = code;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.REVISION = REVISION;
        this.isStatus = isStatus;
    }

    /**
     * 获取
     * @return fruittypesId
     */
    public Long getFruittypesId() {
        return fruittypesId;
    }

    /**
     * 设置
     * @param fruittypesId
     */
    public void setFruittypesId(Long fruittypesId) {
        this.fruittypesId = fruittypesId;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
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

    public String toString() {
        return "Fruittypes{serialVersionUID = " + serialVersionUID + ", fruittypesId = " + fruittypesId + ", name = " + name + ", code = " + code + ", createdBy = " + createdBy + ", createdTime = " + createdTime + ", updatedBy = " + updatedBy + ", updatedTime = " + updatedTime + ", REVISION = " + REVISION + ", isStatus = " + isStatus + "}";
    }
}
