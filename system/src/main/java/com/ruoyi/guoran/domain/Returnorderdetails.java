package com.ruoyi.guoran.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 退货单明细对象 returnorderdetails
 * 
 * @author 24k纯帅
 * @date 2023-12-28
 */
public class Returnorderdetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long rdId;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sId;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private Long warehousingId;

    /** 退货编号 */
    @Excel(name = "退货编号")
    private String rdNumber;

    /** 水果类型 */
    @Excel(name = "水果类型")
    private Long fruittypesId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String fruitId;

    /** 重量 */
    @Excel(name = "重量")
    private Double rdCount;

    /** 乐观锁 */
    @Excel(name = "乐观锁")
    private Long REVISION;

    /** 创建人 */
    private String createdBy;

    /** 创建时间 */
    private Date createdTime;

    /** 更新人 */
    private String updatedBy;

    /** 更新时间 */
    private Date updatedTime;

    /** 逻辑删除 */
    private Integer isStatus;

    /** 审批 */
    private Integer examine;

    public Returnorderdetails() {
    }

    public Returnorderdetails(Long rdId, String sId, Long warehousingId, String rdNumber, Long fruittypesId, String fruitId, Double rdCount) {
        this.rdId = rdId;
        this.sId = sId;
        this.warehousingId = warehousingId;
        this.rdNumber = rdNumber;
        this.fruittypesId = fruittypesId;
        this.fruitId = fruitId;
        this.rdCount = rdCount;
    }

    public void setRdId(Long rdId)
    {
        this.rdId = rdId;
    }

    public Long getRdId() 
    {
        return rdId;
    }
    public void setsId(String sId) 
    {
        this.sId = sId;
    }

    public String getsId() 
    {
        return sId;
    }
    public void setWarehousingId(Long warehousingId) 
    {
        this.warehousingId = warehousingId;
    }

    public Long getWarehousingId() 
    {
        return warehousingId;
    }
    public void setRdNumber(String rdNumber) 
    {
        this.rdNumber = rdNumber;
    }

    public String getRdNumber() 
    {
        return rdNumber;
    }
    public void setFruittypesId(Long fruittypesId) 
    {
        this.fruittypesId = fruittypesId;
    }

    public Long getFruittypesId() 
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
    public void setRdCount(Double rdCount)
    {
        this.rdCount = rdCount;
    }

    public Double getRdCount()
    {
        return rdCount;
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
    public void setIsStatus(Integer isStatus) 
    {
        this.isStatus = isStatus;
    }

    public Integer getIsStatus() 
    {
        return isStatus;
    }
    public void setExamine(Integer examine) 
    {
        this.examine = examine;
    }

    public Integer getExamine() 
    {
        return examine;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rdId", getRdId())
            .append("sId", getsId())
            .append("warehousingId", getWarehousingId())
            .append("rdNumber", getRdNumber())
            .append("fruittypesId", getFruittypesId())
            .append("fruitId", getFruitId())
            .append("rdCount", getRdCount())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("isStatus", getIsStatus())
            .append("examine", getExamine())
            .toString();
    }
}
