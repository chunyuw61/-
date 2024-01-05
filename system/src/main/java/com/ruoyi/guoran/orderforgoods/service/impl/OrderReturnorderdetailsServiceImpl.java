package com.ruoyi.guoran.orderforgoods.service.impl;

import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderReturnorderdetails;
import com.ruoyi.guoran.orderforgoods.mapper.OrderReturnorderdetailsMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIReturnorderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退货单明细Service业务层处理
 * 
 * @author chunyuw61
 * @date 2023-12-28
 */
@Service
public class OrderReturnorderdetailsServiceImpl implements OrderIReturnorderdetailsService
{
    @Autowired
    private OrderReturnorderdetailsMapper returnorderdetailsMapper;

    /**
     * 查询退货单明细
     * 
     * @param rdId 退货单明细主键
     * @return 退货单明细
     */
    @Override
    public OrderReturnorderdetails selectReturnorderdetailsByRdId(Long rdId)
    {
        return returnorderdetailsMapper.selectReturnorderdetailsByRdId(rdId);
    }

    /**
     * 查询退货单明细列表
     * 
     * @param returnorderdetails 退货单明细
     * @return 退货单明细
     */
    @Override
    public List<OrderReturnorderdetails> selectReturnorderdetailsList(OrderReturnorderdetails returnorderdetails)
    {
        return returnorderdetailsMapper.selectReturnorderdetailsList(returnorderdetails);
    }

    /**
     * 新增退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    @Override
    public int insertReturnorderdetails(OrderReturnorderdetails returnorderdetails)
    {
        return returnorderdetailsMapper.insertReturnorderdetails(returnorderdetails);
    }

    /**
     * 修改退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    @Override
    public int updateReturnorderdetails(OrderReturnorderdetails returnorderdetails)
    {
        return returnorderdetailsMapper.updateReturnorderdetails(returnorderdetails);
    }

    /**
     * 批量删除退货单明细
     * 
     * @param rdIds 需要删除的退货单明细主键
     * @return 结果
     */
    @Override
    public int deleteReturnorderdetailsByRdIds(String rdIds)
    {
        return returnorderdetailsMapper.deleteReturnorderdetailsByRdIds(Convert.toStrArray(rdIds));
    }

    /**
     * 删除退货单明细信息
     * 
     * @param rdId 退货单明细主键
     * @return 结果
     */
    @Override
    public int deleteReturnorderdetailsByRdId(Long rdId)
    {
        return returnorderdetailsMapper.deleteReturnorderdetailsByRdId(rdId);
    }
}
