package com.ruoyi.orderforgoods.service;


import com.ruoyi.orderforgoods.domain.ReturnParticulars;

import java.util.List;

/**
 * 退货详情Service接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public interface IReturnParticularsService 
{
    /**
     * 查询退货详情
     * 
     * @param mId 退货详情主键
     * @return 退货详情
     */
    public ReturnParticulars selectReturnParticularsByMId(Long mId);

    /**
     * 查询退货详情列表
     * 
     * @param returnParticulars 退货详情
     * @return 退货详情集合
     */
    public List<ReturnParticulars> selectReturnParticularsList(ReturnParticulars returnParticulars);

    /**
     * 新增退货详情
     * 
     * @param returnParticulars 退货详情
     * @return 结果
     */
    public int insertReturnParticulars(ReturnParticulars returnParticulars);

    /**
     * 修改退货详情
     * 
     * @param returnParticulars 退货详情
     * @return 结果
     */
    public int updateReturnParticulars(ReturnParticulars returnParticulars);

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
    List<ReturnParticulars> getReturnParticularsBySIdAndFruitId(String sId, String fruitId);
}
