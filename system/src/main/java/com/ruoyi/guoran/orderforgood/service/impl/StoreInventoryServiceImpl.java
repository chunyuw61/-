package com.ruoyi.guoran.orderforgood.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.guoran.domain.Storeinventory;
import com.ruoyi.guoran.orderforgood.mapper.StoreInventoryMapper;
import com.ruoyi.guoran.orderforgood.service.IStoreInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门店库存Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-28
 */
@Service
public class StoreInventoryServiceImpl implements IStoreInventoryService {
    @Autowired
    private StoreInventoryMapper storeinventoryMapper;

    /**
     * 查询门店库存
     *
     * @param inentorydetailsId 门店库存主键
     * @return 门店库存
     */
    @Override
    public Storeinventory selectStoreinventoryByInentorydetailsId(Long inentorydetailsId) {
        return storeinventoryMapper.selectStoreinventoryByInentorydetailsId(inentorydetailsId);
    }

    /**
     * 查询门店库存列表
     *
     * @param storeinventory 门店库存
     * @return 门店库存
     */
    @Override
    public List<Storeinventory> selectStoreinventoryList(Storeinventory storeinventory) {
        return storeinventoryMapper.selectStoreinventoryList(storeinventory);
    }

    /**
     * 新增门店库存
     *
     * @param storeinventory 门店库存
     * @return 结果
     */
    @Override
    public int insertStoreinventory(Storeinventory storeinventory) {
        return storeinventoryMapper.insertStoreinventory(storeinventory);
    }

    /**
     * 修改门店库存
     *
     * @param storeinventory 门店库存
     * @return 结果
     */
    @Override
    public int updateStoreinventory(Storeinventory storeinventory) {
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
    public Storeinventory getStoreinventoryByShopIdAndFruitId(String shopId, String fruitId) {
        return storeinventoryMapper.selectStoreinventoryByShopIdAndFruitId(shopId, fruitId);
    }
}
