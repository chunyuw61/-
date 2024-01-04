package com.ruoyi.guoran.orderforgood.service;


import com.ruoyi.guoran.domain.ReturnStatistics;

import java.util.List;

/**
 * 退货统计Service接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public interface IReturnStatisticsService 
{
    /**
     * 查询退货统计
     * 
     * @param id 退货统计主键
     * @return 退货统计
     */
    public ReturnStatistics selectReturnStatisticsById(Long id);

    /**
     * 查询退货统计列表
     * 
     * @param returnStatistics 退货统计
     * @return 退货统计集合
     */
    public List<ReturnStatistics> selectReturnStatisticsList(ReturnStatistics returnStatistics);

    /**
     * 新增退货统计
     * 
     * @param returnStatistics 退货统计
     * @return 结果
     */
    public int insertReturnStatistics(ReturnStatistics returnStatistics);

    /**
     * 修改退货统计
     * 
     * @param returnStatistics 退货统计
     * @return 结果
     */
    public int updateReturnStatistics(ReturnStatistics returnStatistics);

    /**
     * 批量删除退货统计
     * 
     * @param ids 需要删除的退货统计主键集合
     * @return 结果
     */
    public int deleteReturnStatisticsByIds(String ids);

    /**
     * 删除退货统计信息
     * 
     * @param id 退货统计主键
     * @return 结果
     */
    public int deleteReturnStatisticsById(Long id);

    /*条件更新*/
    int updateReturnStatisticsBySIdAndFruitId(ReturnStatistics returnStatistics);
}
