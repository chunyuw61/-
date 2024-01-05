package com.ruoyi.guoran.orderforgoods.service.impl;


import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderReturnStatistics;
import com.ruoyi.guoran.orderforgoods.mapper.OrderReturnStatisticsMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIReturnStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退货统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class OrderReturnStatisticsServiceImpl implements OrderIReturnStatisticsService
{
    @Autowired
    private OrderReturnStatisticsMapper returnStatisticsMapper;

    /**
     * 查询退货统计
     * 
     * @param id 退货统计主键
     * @return 退货统计
     */
    @Override
    public OrderReturnStatistics selectReturnStatisticsById(Long id)
    {
        return returnStatisticsMapper.selectReturnStatisticsById(id);
    }

    /**
     * 查询退货统计列表
     * 
     * @param returnStatistics 退货统计
     * @return 退货统计
     */
    @Override
    public List<OrderReturnStatistics> selectReturnStatisticsList(OrderReturnStatistics returnStatistics)
    {
        return returnStatisticsMapper.selectReturnStatisticsList(returnStatistics);
    }

    /**
     * 新增退货统计
     * 
     * @param returnStatistics 退货统计
     * @return 结果
     */
    @Override
    public int insertReturnStatistics(OrderReturnStatistics returnStatistics)
    {
        return returnStatisticsMapper.insertReturnStatistics(returnStatistics);
    }

    /**
     * 修改退货统计
     * 
     * @param returnStatistics 退货统计
     * @return 结果
     */
    @Override
    public int updateReturnStatistics(OrderReturnStatistics returnStatistics)
    {
        return returnStatisticsMapper.updateReturnStatistics(returnStatistics);
    }

    /**
     * 批量删除退货统计
     * 
     * @param ids 需要删除的退货统计主键
     * @return 结果
     */
    @Override
    public int deleteReturnStatisticsByIds(String ids)
    {
        return returnStatisticsMapper.deleteReturnStatisticsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除退货统计信息
     * 
     * @param id 退货统计主键
     * @return 结果
     */
    @Override
    public int deleteReturnStatisticsById(Long id)
    {
        return returnStatisticsMapper.deleteReturnStatisticsById(id);
    }

    /*条件更新*/
    @Override
    public int updateReturnStatisticsBySIdAndFruitId(OrderReturnStatistics returnStatistics) {
        return returnStatisticsMapper.updateReturnStatisticsBySIdAndFruitId(returnStatistics);
    }


}
