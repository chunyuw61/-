package com.ruoyi.guoran.statistics.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.guoran.domain.SalesStatistics;
import com.ruoyi.guoran.statistics.mapper.SalesStatisticsMapper1;
import com.ruoyi.guoran.statistics.service.ISalesStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.text.Convert;

/**
 * 销售统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class SalesStatisticsServiceImpl1 implements ISalesStatisticsService
{
    @Autowired
    private SalesStatisticsMapper1 salesStatisticsMapper1;


    /**
     * 查询销售统计
     * 
     * @param salesStatisticId 销售统计主键
     * @return 销售统计
     */
    @Override
    public SalesStatistics selectSalesStatisticsBySalesStatisticId(Long salesStatisticId)
    {
        return salesStatisticsMapper1.selectSalesStatisticsBySalesStatisticId(salesStatisticId);
    }

    /**
     * 查询销售统计列表
     * 
     * @param salesStatistics 销售统计
     * @return 销售统计
     */
    @Override
    public List<SalesStatistics> selectSalesStatisticsList(SalesStatistics salesStatistics)
    {
        return salesStatisticsMapper1.selectSalesStatisticsList(salesStatistics);
    }

    /**
     * 新增销售统计
     * 
     * @param salesStatistics 销售统计
     * @return 结果
     */
    @Override
    public int insertSalesStatistics(SalesStatistics salesStatistics)
    {
        return salesStatisticsMapper1.insertSalesStatistics(salesStatistics);
    }

    /**
     * 修改销售统计
     * 
     * @param salesStatistics 销售统计
     * @return 结果
     */
    @Override
    public int updateSalesStatistics(SalesStatistics salesStatistics)
    {
        salesStatistics.setUpdateTime(DateUtils.getNowDate());
        return salesStatisticsMapper1.updateSalesStatistics(salesStatistics);
    }

    /**
     * 批量删除销售统计
     * 
     * @param salesStatisticIds 需要删除的销售统计主键
     * @return 结果
     */
    @Override
    public int deleteSalesStatisticsBySalesStatisticIds(String salesStatisticIds)
    {
        return salesStatisticsMapper1.deleteSalesStatisticsBySalesStatisticIds(Convert.toStrArray(salesStatisticIds));
    }

    /**
     * 删除销售统计信息
     * 
     * @param salesStatisticId 销售统计主键
     * @return 结果
     */
    @Override
    public int deleteSalesStatisticsBySalesStatisticId(Long salesStatisticId)
    {
        return salesStatisticsMapper1.deleteSalesStatisticsBySalesStatisticId(salesStatisticId);
    }

}
