package com.ruoyi.orderforgoods.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 退货统计对象 return_statistics
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Getter
public class ReturnStatistics extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 门店id */
    @Excel(name = "门店id")
   private String sId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 退货重量 */
    @Excel(name = "退货重量")
    private BigDecimal rdCount;

    /** 退货审批通过时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "退货审批通过时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date returnTime;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isStatus;

    /** 仓房id */
    @Excel(name = "仓房id")
    private String warehouseId;


    public ReturnStatistics() {
    }

    public ReturnStatistics(long serialVersionUID, Long id, String sId, String fruitId, BigDecimal rdCount, Date returnTime, Integer isStatus, String warehouseId) {

        this.id = id;
        this.sId = sId;
        this.fruitId = fruitId;
        this.rdCount = rdCount;
        this.returnTime = returnTime;
        this.isStatus = isStatus;
        this.warehouseId = warehouseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getFruitId() {
        return fruitId;
    }

    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    public BigDecimal getRdCount() {
        return rdCount;
    }

    public void setRdCount(BigDecimal rdCount) {
        this.rdCount = rdCount;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public Integer getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Integer isStatus) {
        this.isStatus = isStatus;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Override
    public String toString() {
        return "ReturnStatistics{" +
                "id=" + id +
                ", sId='" + sId + '\'' +
                ", fruitId='" + fruitId + '\'' +
                ", rdCount=" + rdCount +
                ", returnTime=" + returnTime +
                ", isStatus=" + isStatus +
                ", warehouseId='" + warehouseId + '\'' +
                '}';
    }
}
