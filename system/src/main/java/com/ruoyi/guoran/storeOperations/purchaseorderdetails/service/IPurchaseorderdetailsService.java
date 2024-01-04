package com.ruoyi.guoran.storeOperations.purchaseorderdetails.service;

import java.util.List;
import com.ruoyi.guoran.domain.Purchaseorderdetails;

/**
 * 进货单明细Service接口
 * 
 * @author 24k纯帅
 * @date 2023-12-26
 */
public interface IPurchaseorderdetailsService 
{
    /**
     * 查询进货单明细
     * 
     * @param pId 进货单明细主键
     * @return 进货单明细
     */
    public Purchaseorderdetails selectPurchaseorderdetailsByPId(Long pId);

    /**
     * 查询进货单明细列表
     * 
     * @param purchaseorderdetails 进货单明细
     * @return 进货单明细集合
     */
    public List<Purchaseorderdetails> selectPurchaseorderdetailsList(Purchaseorderdetails purchaseorderdetails);

    /**
     * 新增进货单明细
     * 
     * @param purchaseorderdetails 进货单明细
     * @return 结果
     */
    public int insertPurchaseorderdetails(Purchaseorderdetails purchaseorderdetails);

    /**
     * 修改进货单明细
     * 
     * @param purchaseorderdetails 进货单明细
     * @return 结果
     */
    public int updatePurchaseorderdetails(Purchaseorderdetails purchaseorderdetails);

    /**
     * 批量删除进货单明细
     * 
     * @param pIds 需要删除的进货单明细主键集合
     * @return 结果
     */
    public int deletePurchaseorderdetailsByPIds(String pIds);

    /**
     * 删除进货单明细信息
     * 
     * @param pId 进货单明细主键
     * @return 结果
     */
    public int deletePurchaseorderdetailsByPId(Long pId);
}
