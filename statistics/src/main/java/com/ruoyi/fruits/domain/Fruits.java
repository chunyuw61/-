package com.ruoyi.fruits.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水果 水果对象 fruits
 * 
 * @author ruoyi
 * @date 2024-01-02
 */
public class Fruits extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long fruitId;

    /** 水果种类表外键 */
    @Excel(name = "水果种类表外键")
    private String fruittypesId;

    /** 水果编号 */
    @Excel(name = "水果编号")
    private String code;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String name;

    /** 水果图片 */
    @Excel(name = "水果图片")
    private String img;

    /**  */
    @Excel(name = "")
    private Long isStatus;

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


    public Fruits(String code) {
        this.code = code;
    }

    public void setFruitId(Long fruitId)
    {
        this.fruitId = fruitId;
    }

    public Long getFruitId() 
    {
        return fruitId;
    }
    public void setFruittypesId(String fruittypesId) 
    {
        this.fruittypesId = fruittypesId;
    }

    public String getFruittypesId() 
    {
        return fruittypesId;
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
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setIsStatus(Long isStatus) 
    {
        this.isStatus = isStatus;
    }

    public Long getIsStatus() 
    {
        return isStatus;
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
            .append("fruitId", getFruitId())
            .append("fruittypesId", getFruittypesId())
            .append("code", getCode())
            .append("name", getName())
            .append("img", getImg())
            .append("isStatus", getIsStatus())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
