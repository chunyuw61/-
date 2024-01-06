package com.ruoyi.guoran.orderforgoods.service;



import com.ruoyi.guoran.orderforgoods.domain.OrderReturnParticulars;

import java.util.List;

/**
 * 退货详情Service接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public interface OrderIReturnParticularsService
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
     * 批量删除退货详情
     * 
     * @param mIds 需要删除的退货详情主键集合
     * @return 结果
     */
    public int deleteReturnParticularsByMIds(String mIds);

    /**
     * 删除退货详情信息
     * 
     * @param mId 退货详情主键
     * @return 结果
     */
    public int deleteReturnParticularsByMId(Long mId);

    /*条件查询*/
    List<OrderReturnParticulars> getReturnParticularsBySIdAndFruitId(String sId, String fruitId);
}
