package com.ruoyi.guoran.orderforgoods.service.impl;


import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderStoreinventory;
import com.ruoyi.guoran.orderforgoods.mapper.OrderStoreinventoryMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIStoreinventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 门店库存Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class OrderStoreinventoryServiceImpl implements OrderIStoreinventoryService {
    @Autowired
    private OrderStoreinventoryMapper storeinventoryMapper;

    /**
     * 查询门店库存
     *
     * @param inentorydetailsId 门店库存主键
     * @return 门店库存
     */
    @Override
    public OrderStoreinventory selectStoreinventoryByInentorydetailsId(Long inentorydetailsId) {
        return storeinventoryMapper.selectStoreinventoryByInentorydetailsId(inentorydetailsId);
    }

    /**
     * 查询门店库存列表
     *
     * @param storeinventory 门店库存
     * @return 门店库存
     */
    @Override
    public List<OrderStoreinventory> selectStoreinventoryList(OrderStoreinventory storeinventory) {
        return storeinventoryMapper.selectStoreinventoryList(storeinventory);
    }

    /**
     * 新增门店库存
     *
     * @param storeinventory 门店库存
     * @return 结果
     */
    @Override
    public int insertStoreinventory(OrderStoreinventory storeinventory) {
        return storeinventoryMapper.insertStoreinventory(storeinventory);
    }

    /**
     * 修改门店库存
     *
     * @param storeinventory 门店库存
     * @return 结果
     */
    @Override
    public int updateStoreinventory(OrderStoreinventory storeinventory) {
        return storeinventoryMapper.updateStoreinventory(storeinventory);
    }

    /**
     * 批量删除门店库存
     *
     * @param inentorydetailsIds 需要删除的门店库存主键
     * @return 结果
     */
    @Override
    public int deleteStoreinventoryByInentorydetailsIds(String inentorydetailsIds) {
        return storeinventoryMapper.deleteStoreinventoryByInentorydetailsIds(Convert.toStrArray(inentorydetailsIds));
    }

    /**
     * 删除门店库存信息
     *
     * @param inentorydetailsId 门店库存主键
     * @return 结果
     */
    @Override
    public int deleteStoreinventoryByInentorydetailsId(Long inentorydetailsId) {
        return storeinventoryMapper.deleteStoreinventoryByInentorydetailsId(inentorydetailsId);
    }


    /*条件查询*/
    @Override
    public OrderStoreinventory getStoreinventoryByShopIdAndFruitId(String shopId, String fruitId) {
        return storeinventoryMapper.selectStoreinventoryByShopIdAndFruitId(shopId, fruitId);
    }

    @Override
    public BigDecimal selectNumberByFruitIdAndFruittypesId(String fruitId, String fruittypesId) {
        return storeinventoryMapper.selectNumberByFruitIdAndFruittypesId(fruitId, fruittypesId);
    }
}
