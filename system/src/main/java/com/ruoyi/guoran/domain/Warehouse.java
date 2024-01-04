package com.ruoyi.guoran.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 仓库信息对象 warehouse
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
public class Warehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long wId;

    /** 仓库编号 */
    @Excel(name = "仓库编号")
    private String wNumber;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    private String wName;

    /** 仓库地址 */
    @Excel(name = "仓库地址")
    private String wAddress;

    /** 联系电话 员工表的外键 */
    @Excel(name = "联系电话 员工表的外键")
    private String phone;

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

    public void setwId(Long wId) 
    {
        this.wId = wId;
    }

    public Long getwId() 
    {
        return wId;
    }
    public void setwNumber(String wNumber) 
    {
        this.wNumber = wNumber;
    }

    public String getwNumber() 
    {
        return wNumber;
    }
    public void setwName(String wName) 
    {
        this.wName = wName;
    }

    public String getwName() 
    {
        return wName;
    }
    public void setwAddress(String wAddress) 
    {
        this.wAddress = wAddress;
    }

    public String getwAddress() 
    {
        return wAddress;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("wId", getwId())
            .append("wNumber", getwNumber())
            .append("wName", getwName())
            .append("wAddress", getwAddress())
            .append("phone", getPhone())
            .append("REVISION", getREVISION())
            .append("createdBy", getCreatedBy())
            .append("createdTime", getCreatedTime())
            .append("updatedBy", getUpdatedBy())
            .append("updatedTime", getUpdatedTime())
            .append("isStatus", getIsStatus())
            .toString();
    }
}
