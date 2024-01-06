package com.ruoyi.guoran.inventory.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.inventory.service.IPurchaseorderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.inventory.mapper.PurchaseorderdetailsMapper;
import com.ruoyi.guoran.domain.Purchaseorderdetails;

/**
 * 门店进货单明细和仓库出货单明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class PurchaseorderdetailsServiceImpl implements IPurchaseorderdetailsService
{
    @Autowired
    private PurchaseorderdetailsMapper purchaseorderdetailsMapper;

    /**
     * 查询门店进货单明细和仓库出货单明细
     * 
     * @param pId 门店进货单明细和仓库出货单明细主键
     * @return 门店进货单明细和仓库出货单明细
     */
    @Override
    public Purchaseorderdetails selectPurchaseorderdetailsByPId(Long pId)
    {
        return purchaseorderdetailsMapper.selectPurchaseorderdetailsByPId(pId);
    }

    /**
     * 查询门店进货单明细和仓库出货单明细列表
     * 
     * @param purchaseorderdetails 门店进货单明细和仓库出货单明细
     * @return 门店进货单明细和仓库出货单明细
     */
    @Override
    public List<Purchaseorderdetails> selectPurchaseorderdetailsList(Purchaseorderdetails purchaseorderdetails)
    {
        return purchaseorderdetailsMapper.selectPurchaseorderdetailsList(purchaseorderdetails);
    }

    @Override
    public String selectShopId(String sName) {
        return purchaseorderdetailsMapper.selectShopId(sName);
    }

    @Override
    public String selectShopName(SysDept sysDept) {
        return purchaseorderdetailsMapper.selectShopName(sysDept);
    }

    @Override
    public String selectFruitTypeName(String code) {
        return purchaseorderdetailsMapper.selectFruitTypeName(code);
    }

    @Override
    public List<Purchaseorderdetails> selectPurchaseorderdetailsByWareAncestors(SysDept sysDept) {
        return purchaseorderdetailsMapper.selectPurchaseorderdetailsByWareAncestors(sysDept);
    }


    /**
     *  审核门店订货订单
     */
    @Override
    public int auditByPId(Purchaseorderdetails purchaseorderdetails)
    {
        return purchaseorderdetailsMapper.auditByPId(purchaseorderdetails);
    }

    @Override
    public boolean reduceInventoryByWidAndFruitId(Warehousestock warehousestock) {
        return purchaseorderdetailsMapper.reduceInventoryByWidAndFruitId(warehousestock);
    }
}
