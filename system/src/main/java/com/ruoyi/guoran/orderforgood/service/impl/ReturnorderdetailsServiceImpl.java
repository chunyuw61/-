package com.ruoyi.guoran.orderforgood.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.guoran.domain.Returnorderdetails;
import com.ruoyi.guoran.orderforgood.mapper.ReturnorderdetailsMapper;
import com.ruoyi.guoran.orderforgood.service.IReturnorderdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 退货单明细Service业务层处理
 * 
 * @author chunyuw61
 * @date 2023-12-28
 */
@Service
public class ReturnorderdetailsServiceImpl implements IReturnorderdetailsService 
{
    @Autowired
    private ReturnorderdetailsMapper returnorderdetailsMapper;

    /**
     * 查询退货单明细
     * 
     * @param rdId 退货单明细主键
     * @return 退货单明细
     */
    @Override
    public Returnorderdetails selectReturnorderdetailsByRdId(Long rdId)
    {
        return returnorderdetailsMapper.selectReturnorderdetailsByRdId(rdId);
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
        return returnorderdetailsMapper.selectReturnorderdetailsList(returnorderdetails);
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
        return returnorderdetailsMapper.insertReturnorderdetails(returnorderdetails);
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
        return returnorderdetailsMapper.updateReturnorderdetails(returnorderdetails);
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
        return returnorderdetailsMapper.deleteReturnorderdetailsByRdIds(Convert.toStrArray(rdIds));
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
        return returnorderdetailsMapper.deleteReturnorderdetailsByRdId(rdId);
    }
}