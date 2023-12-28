package com.ruoyi.orderforgoods.domain;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 10:20
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 设价对象 fruits
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public class Fruits extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id 主键 */
    private Long fruitId;

    /** 水果种类编号 水果种类表外键 */
    @Excel(name = "水果种类编号 水果种类表外键")
    private String fruittypesId;

    /** 水果编号 水果编号 */
    @Excel(name = "水果编号 水果编号")
    private String code;

    /** 水果名称 水果名称 */
    @Excel(name = "水果名称 水果名称")
    private String name;

    /** 水果图片 */
    @Excel(name = "水果图片")
    private String img;

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

    /**  */
    @Excel(name = "")
    private Long isStatus;


    public Fruits() {
    }

    public Fruits(long serialVersionUID, Long fruitId, String fruittypesId, String code, String name, String img, Long REVISION, String createdBy, Date createdTime, String updatedBy, Date updatedTime, Long isStatus) {

        this.fruitId = fruitId;
        this.fruittypesId = fruittypesId;
        this.code = code;
        this.name = name;
        this.img = img;
        this.REVISION = REVISION;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.isStatus = isStatus;
    }

    /**
     * 获取
     * @return fruitId
     */
    public Long getFruitId() {
        return fruitId;
    }

    /**
     * 设置
     * @param fruitId
     */
    public void setFruitId(Long fruitId) {
        this.fruitId = fruitId;
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
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
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

    public String toString() {
        return "Fruits{serialVersionUID = " + serialVersionUID + ", fruitId = " + fruitId + ", fruittypesId = " + fruittypesId + ", code = " + code + ", name = " + name + ", img = " + img + ", REVISION = " + REVISION + ", createdBy = " + createdBy + ", createdTime = " + createdTime + ", updatedBy = " + updatedBy + ", updatedTime = " + updatedTime + ", isStatus = " + isStatus + "}";
    }
}