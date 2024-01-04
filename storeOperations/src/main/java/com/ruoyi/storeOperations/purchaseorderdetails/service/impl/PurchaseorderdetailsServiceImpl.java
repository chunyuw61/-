package com.ruoyi.storeOperations.purchaseorderdetails.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.storeOperations.purchaseorderdetails.mapper.PurchaseorderdetailsMapper;
import com.ruoyi.storeOperations.purchaseorderdetails.domain.Purchaseorderdetails;
import com.ruoyi.storeOperations.purchaseorderdetails.service.IPurchaseorderdetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 进货单明细Service业务层处理
 * 
 * @author 24k纯帅
 * @date 2023-12-26
 */
@Service
public class PurchaseorderdetailsServiceImpl implements IPurchaseorderdetailsService 
{
    @Autowired
    private PurchaseorderdetailsMapper purchaseorderdetailsMapper;

    /**
     * 查询进货单明细
     * 
     * @param pId 进货单明细主键
     * @return 进货单明细
     */
    @Override
    public Purchaseorderdetails selectPurchaseorderdetailsByPId(Long pId)
    {
        return purchaseorderdetailsMapper.selectPurchaseorderdetailsByPId(pId);
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
        return purchaseorderdetailsMapper.selectPurchaseorderdetailsList(purchaseorderdetails);
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
        return purchaseorderdetailsMapper.insertPurchaseorderdetails(purchaseorderdetails);
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
        return purchaseorderdetailsMapper.updatePurchaseorderdetails(purchaseorderdetails);
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
        return purchaseorderdetailsMapper.deletePurchaseorderdetailsByPIds(Convert.toStrArray(pIds));
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
        return purchaseorderdetailsMapper.deletePurchaseorderdetailsByPId(pId);
    }
}
