package com.ruoyi.guoran.orderforgoods.service;




import com.ruoyi.guoran.orderforgoods.domain.OrderReturnStatistics;

import java.util.List;

/**
 * 退货统计Service接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public interface OrderIReturnStatisticsService
{
    /**
     * 查询退货统计
     * 
     * @param id 退货统计主键
     * @return 退货统计
     */
    public OrderReturnStatistics selectReturnStatisticsById(Long id);

    /**
     * 查询退货统计列表
     * 
     * @param returnStatistics 退货统计
     * @return 退货统计集合
     */
    public List<OrderReturnStatistics> selectReturnStatisticsList(OrderReturnStatistics returnStatistics);

    /**
     * 新增退货统计
     * 
     * @param returnStatistics 退货统计
     * @return 结果
     */
    public int insertReturnStatistics(OrderReturnStatistics returnStatistics);

    /**
     * 修改退货统计
     * 
     * @param returnStatistics 退货统计
     * @return 结果
     */
    public int updateReturnStatistics(OrderReturnStatistics returnStatistics);

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
    int updateReturnStatisticsBySIdAndFruitId(OrderReturnStatistics returnStatistics);
}
