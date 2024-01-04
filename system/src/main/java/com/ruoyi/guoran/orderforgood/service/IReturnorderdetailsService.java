package com.ruoyi.guoran.orderforgood.service;

import com.ruoyi.guoran.domain.Returnorderdetails;

import java.util.List;

/**
 * 退货单明细Service接口
 * 
 * @author chunyuw61
 * @date 2023-12-28
 */
public interface IReturnorderdetailsService 
{
    /**
     * 查询退货单明细
     * 
     * @param rdId 退货单明细主键
     * @return 退货单明细
     */
    public Returnorderdetails selectReturnorderdetailsByRdId(Long rdId);

    /**
     * 查询退货单明细列表
     * 
     * @param returnorderdetails 退货单明细
     * @return 退货单明细集合
     */
    public List<Returnorderdetails> selectReturnorderdetailsList(Returnorderdetails returnorderdetails);

    /**
     * 新增退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    public int insertReturnorderdetails(Returnorderdetails returnorderdetails);

    /**
     * 修改退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    public int updateReturnorderdetails(Returnorderdetails returnorderdetails);

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
