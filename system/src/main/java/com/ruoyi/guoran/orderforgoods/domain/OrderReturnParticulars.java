package com.ruoyi.guoran.orderforgoods.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 退货详情对象 return_particulars
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public class OrderReturnParticulars extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long mId;

    /** 退货编号 */
    @Excel(name = "退货编号")
    private String rdNumber;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 是否退货成功 */
    @Excel(name = "是否退货成功")
    private Integer judge;

    /** 门店id */
    @Excel(name = "门店id")
    private String sId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 退货重量 */
    @Excel(name = "退货重量")
    private BigDecimal rdCount;


    public OrderReturnParticulars() {
    }

    public OrderReturnParticulars(long serialVersionUID, Long mId, String rdNumber, Date time, Integer judge, String sId, String fruitId, BigDecimal rdCount) {

        this.mId = mId;
        this.rdNumber = rdNumber;
        this.time = time;
        this.judge = judge;
        this.sId = sId;
        this.fruitId = fruitId;
        this.rdCount = rdCount;
    }

    /**
     * 获取
     * @return mId
     */
    public Long getMId() {
        return mId;
    }

    /**
     * 设置
     * @param mId
     */
    public void setMId(Long mId) {
        this.mId = mId;
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
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取
     * @return judge
     */
    public Integer getJudge() {
        return judge;
    }

    /**
     * 设置
     * @param judge
     */
    public void setJudge(Integer judge) {
        this.judge = judge;
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

    public String toString() {
        return "ReturnParticulars{serialVersionUID = " + serialVersionUID + ", mId = " + mId + ", rdNumber = " + rdNumber + ", time = " + time + ", judge = " + judge + ", sId = " + sId + ", fruitId = " + fruitId + ", rdCount = " + rdCount + "}";
    }
}
