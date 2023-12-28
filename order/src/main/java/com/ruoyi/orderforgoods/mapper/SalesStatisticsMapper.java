package com.ruoyi.orderforgoods.mapper;


import com.ruoyi.orderforgoods.domain.SalesStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 销售统计Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Mapper
public interface SalesStatisticsMapper 
{
    /**
     * 查询销售统计
     * 
     * @param salesStatisticId 销售统计主键
     * @return 销售统计
     */
    public SalesStatistics selectSalesStatisticsBySalesStatisticId(Long salesStatisticId);

    /**
     * 查询销售统计列表
     * 
     * @param salesStatistics 销售统计
     * @return 销售统计集合
     */
    public List<SalesStatistics> selectSalesStatisticsList(SalesStatistics salesStatistics);

    /**
     * 新增销售统计
     * 
     * @param salesStatistics 销售统计
     * @return 结果
     */
    public int insertSalesStatistics(SalesStatistics salesStatistics);

    /**
     * 修改销售统计
     * 
     * @param salesStatistics 销售统计
     * @return 结果
     */
    public int updateSalesStatistics(SalesStatistics salesStatistics);

    /**
     * 删除销售统计
     * 
     * @param salesStatisticId 销售统计主键
     * @return 结果
     */
    public int deleteSalesStatisticsBySalesStatisticId(Long salesStatisticId);

    /**
     * 批量删除销售统计
     * 
     * @param salesStatisticIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSalesStatisticsBySalesStatisticIds(String[] salesStatisticIds);
}
