package com.ruoyi.orderforgoods.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.orderforgoods.domain.SalesStatistics;
import com.ruoyi.orderforgoods.mapper.SalesStatisticsMapper;
import com.ruoyi.orderforgoods.service.ISalesStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class SalesStatisticsServiceImpl implements ISalesStatisticsService
{
    @Autowired
    private SalesStatisticsMapper salesStatisticsMapper;

    /**
     * 查询销售统计
     * 
     * @param salesStatisticId 销售统计主键
     * @return 销售统计
     */
    @Override
    public SalesStatistics selectSalesStatisticsBySalesStatisticId(Long salesStatisticId)
    {
        return salesStatisticsMapper.selectSalesStatisticsBySalesStatisticId(salesStatisticId);
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
        return salesStatisticsMapper.selectSalesStatisticsList(salesStatistics);
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
        return salesStatisticsMapper.insertSalesStatistics(salesStatistics);
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
        return salesStatisticsMapper.updateSalesStatistics(salesStatistics);
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
        return salesStatisticsMapper.deleteSalesStatisticsBySalesStatisticIds(Convert.toStrArray(salesStatisticIds));
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
        return salesStatisticsMapper.deleteSalesStatisticsBySalesStatisticId(salesStatisticId);
    }
}
