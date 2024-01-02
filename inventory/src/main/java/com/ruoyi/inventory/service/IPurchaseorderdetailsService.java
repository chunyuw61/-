package com.ruoyi.inventory.service;

import java.util.List;
import com.ruoyi.inventory.domain.Purchaseorderdetails;

/**
 * 门店进货单明细和仓库出货单明细Service接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public interface IPurchaseorderdetailsService 
{
    /**
     * 查询门店进货单明细和仓库出货单明细
     * 
     * @param pId 门店进货单明细和仓库出货单明细主键
     * @return 门店进货单明细和仓库出货单明细
     */
    public Purchaseorderdetails selectPurchaseorderdetailsByPId(Long pId);

    /**
     * 查询门店进货单明细和仓库出货单明细列表
     * 
     * @param purchaseorderdetails 门店进货单明细和仓库出货单明细
     * @return 门店进货单明细和仓库出货单明细集合
     */
    public List<Purchaseorderdetails> selectPurchaseorderdetailsList(Purchaseorderdetails purchaseorderdetails);

    /**
     * 根据门店编号 查询门店名称
     */
    public String selectShopName(String sNumber);

    /**
     * 根据水果种类编号 查询水果种类名称
     */
    public String selectFruitTypeName(String code);

    /**
     * 审核门店订货订单
     */
    public int auditByPId(Purchaseorderdetails purchaseorderdetails);
}
