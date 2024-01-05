package com.ruoyi.guoran.orderforgoods.mapper;



import com.ruoyi.guoran.orderforgoods.domain.OrderSalesorderdetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 销售订单明细Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Mapper
public interface OrderSalesorderdetailsMapper
{
    /**
     * 查询销售订单明细
     * 
     * @param salesorderdetailsId 销售订单明细主键
     * @return 销售订单明细
     */
    public OrderSalesorderdetails selectSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId);

    /**
     * 查询销售订单明细列表
     * 
     * @param salesorderdetails 销售订单明细
     * @return 销售订单明细集合
     */
    public List<OrderSalesorderdetails> selectSalesorderdetailsList(OrderSalesorderdetails salesorderdetails);

    /**
     * 新增销售订单明细
     * 
     * @param salesorderdetails 销售订单明细
     * @return 结果
     */
    public int insertSalesorderdetails(OrderSalesorderdetails salesorderdetails);

    /**
     * 修改销售订单明细
     * 
     * @param salesorderdetails 销售订单明细
     * @return 结果
     */
    public int updateSalesorderdetails(OrderSalesorderdetails salesorderdetails);

    /**
     * 删除销售订单明细
     * 
     * @param salesorderdetailsId 销售订单明细主键
     * @return 结果
     */
    public int deleteSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId);

    /**
     * 批量删除销售订单明细
     * 
     * @param salesorderdetailsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSalesorderdetailsBySalesorderdetailsIds(String[] salesorderdetailsIds);



}
