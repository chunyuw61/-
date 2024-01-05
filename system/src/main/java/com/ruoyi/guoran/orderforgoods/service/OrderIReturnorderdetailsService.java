package com.ruoyi.guoran.orderforgoods.service;



import com.ruoyi.guoran.orderforgoods.domain.OrderReturnorderdetails;

import java.util.List;

/**
 * 退货单明细Service接口
 * 
 * @author chunyuw61
 * @date 2023-12-28
 */
public interface OrderIReturnorderdetailsService
{
    /**
     * 查询退货单明细
     * 
     * @param rdId 退货单明细主键
     * @return 退货单明细
     */
    public OrderReturnorderdetails selectReturnorderdetailsByRdId(Long rdId);

    /**
     * 查询退货单明细列表
     * 
     * @param returnorderdetails 退货单明细
     * @return 退货单明细集合
     */
    public List<OrderReturnorderdetails> selectReturnorderdetailsList(OrderReturnorderdetails returnorderdetails);

    /**
     * 新增退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    public int insertReturnorderdetails(OrderReturnorderdetails returnorderdetails);

    /**
     * 修改退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    public int updateReturnorderdetails(OrderReturnorderdetails returnorderdetails);

    /**
     * 批量删除退货单明细
     * 
     * @param rdIds 需要删除的退货单明细主键集合
     * @return 结果
     */
    public int deleteReturnorderdetailsByRdIds(String rdIds);

    /**
     * 删除退货单明细信息
     * 
     * @param rdId 退货单明细主键
     * @return 结果
     */
    public int deleteReturnorderdetailsByRdId(Long rdId);
}
