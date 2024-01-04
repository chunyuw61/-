package com.ruoyi.storeOperations.purchaseorderdetails.mapper;

import java.util.List;
import com.ruoyi.storeOperations.purchaseorderdetails.domain.Purchaseorderdetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * 进货单明细Mapper接口
 * 
 * @author 24k纯帅
 * @date 2023-12-26
 */
@Mapper
public interface PurchaseorderdetailsMapper 
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
     * 删除进货单明细
     * 
     * @param pId 进货单明细主键
     * @return 结果
     */
    public int deletePurchaseorderdetailsByPId(Long pId);

    /**
     * 批量删除进货单明细
     * 
     * @param pIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseorderdetailsByPIds(String[] pIds);

    public Purchaseorderdetails selectPurchaseorderdetailsBypNumber(String pNumber);

    public int updateStatus(Long pId);

    public  Purchaseorderdetails selectPurchaseOrderdetailsByFruitId(String FruitId);

}
