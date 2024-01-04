package com.ruoyi.guoran.orderforgood.mapper;


import com.ruoyi.guoran.domain.ReturnStatistics;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 退货统计Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Mapper
public interface ReturnStatisticsMapper 
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
     * 删除退货统计
     * 
     * @param id 退货统计主键
     * @return 结果
     */
    public int deleteReturnStatisticsById(Long id);

    /**
     * 批量删除退货统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReturnStatisticsByIds(String[] ids);


    /*条件更新*/
    int updateReturnStatisticsBySIdAndFruitId(ReturnStatistics returnStatistics);
}
