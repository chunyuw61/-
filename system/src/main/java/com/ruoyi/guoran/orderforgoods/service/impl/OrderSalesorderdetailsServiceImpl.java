package com.ruoyi.guoran.orderforgoods.service.impl;

import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderSalesorderdetails;
import com.ruoyi.guoran.orderforgoods.mapper.OrderSalesorderdetailsMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderISalesorderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售订单明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class OrderSalesorderdetailsServiceImpl implements OrderISalesorderdetailsService
{
    @Autowired
    private OrderSalesorderdetailsMapper salesorderdetailsMapper;

    /**
     * 查询销售订单明细
     * 
     * @param salesorderdetailsId 销售订单明细主键
     * @return 销售订单明细
     */
    @Override
    public OrderSalesorderdetails selectSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId)
    {
        return salesorderdetailsMapper.selectSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
    }

    /**
     * 查询销售订单明细列表
     * 
     * @param salesorderdetails 销售订单明细
     * @return 销售订单明细
     */
    @Override
    public List<OrderSalesorderdetails> selectSalesorderdetailsList(OrderSalesorderdetails salesorderdetails)
    {
        return salesorderdetailsMapper.selectSalesorderdetailsList(salesorderdetails);
    }

    /**
     * 新增销售订单明细
     * 
     * @param salesorderdetails 销售订单明细
     * @return 结果
     */
    @Override
    public int insertSalesorderdetails(OrderSalesorderdetails salesorderdetails)
    {
        return salesorderdetailsMapper.insertSalesorderdetails(salesorderdetails);
    }

    /**
     * 修改销售订单明细
     * 
     * @param salesorderdetails 销售订单明细
     * @return 结果
     */
    @Override
    public int updateSalesorderdetails(OrderSalesorderdetails salesorderdetails)
    {
        return salesorderdetailsMapper.updateSalesorderdetails(salesorderdetails);
    }

    /**
     * 批量删除销售订单明细
     * 
     * @param salesorderdetailsIds 需要删除的销售订单明细主键
     * @return 结果
     */
    @Override
    public int deleteSalesorderdetailsBySalesorderdetailsIds(String salesorderdetailsIds)
    {
        return salesorderdetailsMapper.deleteSalesorderdetailsBySalesorderdetailsIds(Convert.toStrArray(salesorderdetailsIds));
    }

    /**
     * 删除销售订单明细信息
     * 
     * @param salesorderdetailsId 销售订单明细主键
     * @return 结果
     */
    @Override
    public int deleteSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId)
    {
        return salesorderdetailsMapper.deleteSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
    }
}
