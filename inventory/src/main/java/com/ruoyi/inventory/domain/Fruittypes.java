package com.ruoyi.inventory.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 水果的种类对象 fruittypes
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public class Fruittypes extends BaseEntity
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

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Long isStatus;

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
    private Long REVISION;

    public void setFruittypesId(Long fruittypesId) 
    {
        this.fruittypesId = fruittypesId;
    }

    public Long getFruittypesId() 
    {
        return fruittypesId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode()
    {
        return code;
    }
    public void setCreatedBy(String createdBy) 
    {
        this.createdBy = createdBy;
    }

    public Long getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Long isStatus) {
        this.isStatus = isStatus;
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
    public void setREVISION(Long REVISION) 
    {
        this.REVISION = REVISION;
    }

    public Long getREVISION() 
    {
        return REVISION;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fruittypesId", getFruittypesId())
            .append("name", getName())
            .append("code", getCode())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
                .append("isStatus", getIsStatus())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("REVISION", getREVISION())
            .toString();
    }
}
