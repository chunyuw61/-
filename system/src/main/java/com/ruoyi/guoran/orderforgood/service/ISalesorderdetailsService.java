package com.ruoyi.guoran.orderforgood.service;

import com.ruoyi.guoran.domain.Salesorderdetails;

import java.util.List;

/**
 * 销售订单明细Service接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public interface ISalesorderdetailsService 
{
    /**
     * 查询销售订单明细
     * 
     * @param salesorderdetailsId 销售订单明细主键
     * @return 销售订单明细
     */
    public Salesorderdetails selectSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId);

    /**
     * 查询销售订单明细列表
     * 
     * @param salesorderdetails 销售订单明细
     * @return 销售订单明细集合
     */
    public List<Salesorderdetails> selectSalesorderdetailsList(Salesorderdetails salesorderdetails);

    /**
     * 新增销售订单明细
     * 
     * @param salesorderdetails 销售订单明细
     * @return 结果
     */
    public int insertSalesorderdetails(Salesorderdetails salesorderdetails);

    /**
     * 修改销售订单明细
     * 
     * @param salesorderdetails 销售订单明细
     * @return 结果
     */
    public int updateSalesorderdetails(Salesorderdetails salesorderdetails);

    /**
     * 批量删除销售订单明细
     * 
     * @param salesorderdetailsIds 需要删除的销售订单明细主键集合
     * @return 结果
     */
    public int deleteSalesorderdetailsBySalesorderdetailsIds(String salesorderdetailsIds);

    /**
     * 删除销售订单明细信息
     * 
     * @param salesorderdetailsId 销售订单明细主键
     * @return 结果
     */
    public int deleteSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId);
}