package com.ruoyi.guoran.orderforgoods.service.impl;


import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderReturnParticulars;
import com.ruoyi.guoran.orderforgoods.mapper.OrderReturnParticularsMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIReturnParticularsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退货详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class OrderReturnParticularsServiceImpl implements OrderIReturnParticularsService
{
    @Autowired
    private OrderReturnParticularsMapper returnParticularsMapper;

    /**
     * 查询退货详情
     * 
     * @param mId 退货详情主键
     * @return 退货详情
     */
    @Override
    public OrderReturnParticulars selectReturnParticularsByMId(Long mId)
    {
        return returnParticularsMapper.selectReturnParticularsByMId(mId);
    }

    /**
     * 查询退货详情列表
     * 
     * @param returnParticulars 退货详情
     * @return 退货详情
     */
    @Override
    public List<OrderReturnParticulars> selectReturnParticularsList(OrderReturnParticulars returnParticulars)
    {
        return returnParticularsMapper.selectReturnParticularsList(returnParticulars);
    }

    /**
     * 新增退货详情
     * 
     * @param returnParticulars 退货详情
     * @return 结果
     */
    @Override
    public int insertReturnParticulars(OrderReturnParticulars returnParticulars)
    {
        return returnParticularsMapper.insertReturnParticulars(returnParticulars);
    }

    /**
     * 修改退货详情
     * 
     * @param returnParticulars 退货详情
     * @return 结果
     */
    @Override
    public int updateReturnParticulars(OrderReturnParticulars returnParticulars)
    {
        return returnParticularsMapper.updateReturnParticulars(returnParticulars);
    }

    /**
     * 批量删除退货详情
     * 
     * @param mIds 需要删除的退货详情主键
     * @return 结果
     */
    @Override
    public int deleteReturnParticularsByMIds(String mIds)
    {
        return returnParticularsMapper.deleteReturnParticularsByMIds(Convert.toStrArray(mIds));
    }

    /**
     * 删除退货详情信息
     * 
     * @param mId 退货详情主键
     * @return 结果
     */
    @Override
    public int deleteReturnParticularsByMId(Long mId)
    {
        return returnParticularsMapper.deleteReturnParticularsByMId(mId);
    }

    /*条件查询*/
    @Override
    public List<OrderReturnParticulars> getReturnParticularsBySIdAndFruitId(String sId, String fruitId) {
        return returnParticularsMapper.selectReturnParticularsBySIdAndFruitId(sId, fruitId);
    }

}
