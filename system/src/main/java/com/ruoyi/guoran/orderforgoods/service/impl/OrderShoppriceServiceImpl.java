package com.ruoyi.guoran.orderforgoods.service.impl;

import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderShopprice;
import com.ruoyi.guoran.orderforgoods.mapper.OrderShoppriceMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIShoppriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * orderforgoodsService业务层处理
 * 
 * @author chunyuw61
 * @date 2024-01-02
 */
@Service
public class OrderShoppriceServiceImpl implements OrderIShoppriceService
{
    @Autowired
    private OrderShoppriceMapper oederShoppriceMapper;

    /**
     * 查询orderforgoods
     * 
     * @param shoppriceId orderforgoods主键
     * @return orderforgoods
     */
    @Override
    public OrderShopprice selectOederShoppriceByShoppriceId(Long shoppriceId)
    {
        return oederShoppriceMapper.selectOederShoppriceByShoppriceId(shoppriceId);
    }

    /**
     * 查询orderforgoods列表
     * 
     * @param oederShopprice orderforgoods
     * @return orderforgoods
     */
    @Override
    public List<OrderShopprice> selectOederShoppriceList(OrderShopprice oederShopprice)
    {
        return oederShoppriceMapper.selectOederShoppriceList(oederShopprice);
    }

    /**
     * 新增orderforgoods
     * 
     * @param oederShopprice orderforgoods
     * @return 结果
     */
    @Override
    public int insertOederShopprice(OrderShopprice oederShopprice)
    {
        return oederShoppriceMapper.insertOederShopprice(oederShopprice);
    }

    /**
     * 修改orderforgoods
     * 
     * @param oederShopprice orderforgoods
     * @return 结果
     */
    @Override
    public int updateOederShopprice(OrderShopprice oederShopprice)
    {
        return oederShoppriceMapper.updateOederShopprice(oederShopprice);
    }

    /**
     * 批量删除orderforgoods
     * 
     * @param shoppriceIds 需要删除的orderforgoods主键
     * @return 结果
     */
    @Override
    public int deleteOederShoppriceByShoppriceIds(String shoppriceIds)
    {
        return oederShoppriceMapper.deleteOederShoppriceByShoppriceIds(Convert.toStrArray(shoppriceIds));
    }

    /**
     * 删除orderforgoods信息
     * 
     * @param shoppriceId orderforgoods主键
     * @return 结果
     */
    @Override
    public int deleteOederShoppriceByShoppriceId(Long shoppriceId)
    {
        return oederShoppriceMapper.deleteOederShoppriceByShoppriceId(shoppriceId);
    }

    /*查询单价*/
    @Override
    public Double selectPriceBySNumberAndCode(String sNumber, String code) {
        return oederShoppriceMapper.selectOederShoppriceBySNumberAndCode(sNumber, code);
    }
}
