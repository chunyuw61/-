package com.ruoyi.guoran.orderforgoods.mapper;


import com.ruoyi.guoran.orderforgoods.domain.OrderReturnParticulars;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 退货详情Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Mapper
public interface OrderReturnParticularsMapper
{
    /**
     * 查询退货详情
     * 
     * @param mId 退货详情主键
     * @return 退货详情
     */
    public OrderReturnParticulars selectReturnParticularsByMId(Long mId);

    /**
     * 查询退货详情列表
     * 
     * @param returnParticulars 退货详情
     * @return 退货详情集合
     */
    public List<OrderReturnParticulars> selectReturnParticularsList(OrderReturnParticulars returnParticulars);

    /**
     * 新增退货详情
     * 
     * @param returnParticulars 退货详情
     * @return 结果
     */
    public int insertReturnParticulars(OrderReturnParticulars returnParticulars);

    /**
     * 修改退货详情
     * 
     * @param returnParticulars 退货详情
     * @return 结果
     */
    public int updateReturnParticulars(OrderReturnParticulars returnParticulars);

    /**
     * 删除退货详情
     * 
     * @param mId 退货详情主键
     * @return 结果
     */
    public int deleteReturnParticularsByMId(Long mId);

    /**
     * 批量删除退货详情
     * 
     * @param mIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReturnParticularsByMIds(String[] mIds);

    /*条件查询*/
    List<OrderReturnParticulars> selectReturnParticularsBySIdAndFruitId(@Param("sId") String sId, @Param("fruitId") String fruitId);
}
