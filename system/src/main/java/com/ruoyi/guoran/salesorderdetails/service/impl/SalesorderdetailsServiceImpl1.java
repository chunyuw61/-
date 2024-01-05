package com.ruoyi.guoran.salesorderdetails.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.salesorderdetails.mapper.SalesorderdetailsMapper3;
import com.ruoyi.guoran.domain.Salesorderdetails;
import com.ruoyi.guoran.salesorderdetails.service.ISalesorderdetailsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 门店退单Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
@Service
public class SalesorderdetailsServiceImpl1 implements ISalesorderdetailsService
{
    @Autowired
    private SalesorderdetailsMapper3 salesorderdetailsMapper;

    /**
     * 查询门店退单
     * 
     * @param salesorderdetailsId 门店退单主键
     * @return 门店退单
     */
    @Override
    public Salesorderdetails selectSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId)
    {
        return salesorderdetailsMapper.selectSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
    }

    /**
     * 查询门店退单列表
     * 
     * @param salesorderdetails 门店退单
     * @return 门店退单
     */
    @Override
    public List<Salesorderdetails> selectSalesorderdetailsList(Salesorderdetails salesorderdetails)
    {
        return salesorderdetailsMapper.selectSalesorderdetailsList(salesorderdetails);
    }

    /**
     * 新增门店退单
     * 
     * @param salesorderdetails 门店退单
     * @return 结果
     */
    @Override
    public int insertSalesorderdetails(Salesorderdetails salesorderdetails)
    {
        return salesorderdetailsMapper.insertSalesorderdetails(salesorderdetails);
    }

    /**
     * 修改门店退单
     * 
     * @param salesorderdetails 门店退单
     * @return 结果
     */
    @Override
    public int updateSalesorderdetails(Salesorderdetails salesorderdetails)
    {
        return salesorderdetailsMapper.updateSalesorderdetails(salesorderdetails);
    }

    /**
     * 批量删除门店退单
     * 
     * @param salesorderdetailsIds 需要删除的门店退单主键
     * @return 结果
     */
    @Override
    public int deleteSalesorderdetailsBySalesorderdetailsIds(String salesorderdetailsIds)
    {
        return salesorderdetailsMapper.deleteSalesorderdetailsBySalesorderdetailsIds(Convert.toStrArray(salesorderdetailsIds));
    }

    /**
     * 删除门店退单信息
     * 
     * @param salesorderdetailsId 门店退单主键
     * @return 结果
     */
    @Override
    public int deleteSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId)
    {
        return salesorderdetailsMapper.deleteSalesorderdetailsBySalesorderdetailsId(salesorderdetailsId);
    }
}
