package com.ruoyi.guoran.storeOperations.purchaseorderdetails.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.storeOperations.purchaseorderdetails.mapper.PurchaseorderdetailsMapper1;
import com.ruoyi.guoran.domain.Purchaseorderdetails;
import com.ruoyi.guoran.storeOperations.purchaseorderdetails.service.IPurchaseorderdetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 进货单明细Service业务层处理
 * 
 * @author 24k纯帅
 * @date 2023-12-26
 */
@Service
public class PurchaseorderdetailsServiceImpl1 implements IPurchaseorderdetailsService
{
    @Autowired
    private PurchaseorderdetailsMapper1 purchaseorderdetailsMapper1;

    /**
     * 查询进货单明细
     * 
     * @param pId 进货单明细主键
     * @return 进货单明细
     */
    @Override
    public Purchaseorderdetails selectPurchaseorderdetailsByPId(Long pId)
    {
        return purchaseorderdetailsMapper1.selectPurchaseorderdetailsByPId(pId);
    }

    /**
     * 查询进货单明细列表
     * 
     * @param purchaseorderdetails 进货单明细
     * @return 进货单明细
     */
    @Override
    public List<Purchaseorderdetails> selectPurchaseorderdetailsList(Purchaseorderdetails purchaseorderdetails)
    {
        return purchaseorderdetailsMapper1.selectPurchaseorderdetailsList(purchaseorderdetails);
    }

    /**
     * 新增进货单明细
     * 
     * @param purchaseorderdetails 进货单明细
     * @return 结果
     */
    @Override
    public int insertPurchaseorderdetails(Purchaseorderdetails purchaseorderdetails)
    {
        return purchaseorderdetailsMapper1.insertPurchaseorderdetails(purchaseorderdetails);
    }

    /**
     * 修改进货单明细
     * 
     * @param purchaseorderdetails 进货单明细
     * @return 结果
     */
    @Override
    public int updatePurchaseorderdetails(Purchaseorderdetails purchaseorderdetails)
    {
        return purchaseorderdetailsMapper1.updatePurchaseorderdetails(purchaseorderdetails);
    }

    /**
     * 批量删除进货单明细
     * 
     * @param pIds 需要删除的进货单明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseorderdetailsByPIds(String pIds)
    {
        return purchaseorderdetailsMapper1.deletePurchaseorderdetailsByPIds(Convert.toStrArray(pIds));
    }

    /**
     * 删除进货单明细信息
     * 
     * @param pId 进货单明细主键
     * @return 结果
     */
    @Override
    public int deletePurchaseorderdetailsByPId(Long pId)
    {
        return purchaseorderdetailsMapper1.deletePurchaseorderdetailsByPId(pId);
    }
}
