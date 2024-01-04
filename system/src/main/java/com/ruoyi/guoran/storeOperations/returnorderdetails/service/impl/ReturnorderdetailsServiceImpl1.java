package com.ruoyi.guoran.storeOperations.returnorderdetails.service.impl;

import java.util.List;

import com.ruoyi.guoran.domain.Returnorderdetails;
import com.ruoyi.guoran.storeOperations.returnorderdetails.mapper.ReturnorderdetailsMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.storeOperations.returnorderdetails.service.IReturnorderdetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 退货单明细Service业务层处理
 * 
 * @author 24k纯帅
 * @date 2023-12-28
 */
@Service
public class ReturnorderdetailsServiceImpl1 implements IReturnorderdetailsService
{
    @Autowired
    private ReturnorderdetailsMapper1 returnorderdetailsMapper1;

    /**
     * 查询退货单明细
     * 
     * @param rdId 退货单明细主键
     * @return 退货单明细
     */
    @Override
    public Returnorderdetails selectReturnorderdetailsByRdId(Long rdId)
    {
        return returnorderdetailsMapper1.selectReturnorderdetailsByRdId(rdId);
    }

    /**
     * 查询退货单明细列表
     * 
     * @param returnorderdetails 退货单明细
     * @return 退货单明细
     */
    @Override
    public List<Returnorderdetails> selectReturnorderdetailsList(Returnorderdetails returnorderdetails)
    {
        return returnorderdetailsMapper1.selectReturnorderdetailsList(returnorderdetails);
    }

    /**
     * 新增退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    @Override
    public int insertReturnorderdetails(Returnorderdetails returnorderdetails)
    {
        return returnorderdetailsMapper1.insertReturnorderdetails(returnorderdetails);
    }

    /**
     * 修改退货单明细
     * 
     * @param returnorderdetails 退货单明细
     * @return 结果
     */
    @Override
    public int updateReturnorderdetails(Returnorderdetails returnorderdetails)
    {
        return returnorderdetailsMapper1.updateReturnorderdetails(returnorderdetails);
    }

    /**
     * 批量删除退货单明细
     * 
     * @param rdIds 需要删除的退货单明细主键
     * @return 结果
     */
    @Override
    public int deleteReturnorderdetailsByRdIds(String rdIds)
    {
        return returnorderdetailsMapper1.deleteReturnorderdetailsByRdIds(Convert.toStrArray(rdIds));
    }

    /**
     * 删除退货单明细信息
     * 
     * @param rdId 退货单明细主键
     * @return 结果
     */
    @Override
    public int deleteReturnorderdetailsByRdId(Long rdId)
    {
        return returnorderdetailsMapper1.deleteReturnorderdetailsByRdId(rdId);
    }
}
