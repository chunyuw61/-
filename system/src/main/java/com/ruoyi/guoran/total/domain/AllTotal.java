package com.ruoyi.guoran.total.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 门店总销售额表对象 all_total
 * 
 * @author ruoyi
 * @date 2023-12-29
 */
public class AllTotal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 门店编号 */
    @Excel(name = "门店编号")
    private String sId;

    /** 销售总额 */
    @Excel(name = "销售总额")
    private BigDecimal total;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setsId(String sId) 
    {
        this.sId = sId;
    }

    public String getsId() 
    {
        return sId;
    }
    public void setTotal(BigDecimal total) 
    {
        this.total = total;
    }

    public BigDecimal getTotal() 
    {
        return total;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sId", getsId())
            .append("total", getTotal())
            .toString();
    }
}
