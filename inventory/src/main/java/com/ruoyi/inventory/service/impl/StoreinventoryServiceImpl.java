package com.ruoyi.inventory.service.impl;

import java.util.List;

import com.ruoyi.inventory.domain.Warehouse;
import com.ruoyi.orderforgoods.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.inventory.mapper.StoreinventoryMapper;
import com.ruoyi.inventory.domain.Storeinventory;
import com.ruoyi.inventory.service.IStoreinventoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 门店库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
@Service
public class StoreinventoryServiceImpl implements IStoreinventoryService 
{
    @Autowired
    private StoreinventoryMapper storeinventoryMapper;

    /**
     * 查询门店库存
     * 
     * @param inentorydetailsId 门店库存主键
     * @return 门店库存
     */
    @Override
    public Storeinventory selectStoreinventoryByInentorydetailsId(Long inentorydetailsId)
    {
        return storeinventoryMapper.selectStoreinventoryByInentorydetailsId(inentorydetailsId);
    }

    /**
     * 查询门店库存列表
     * 
     * @param storeinventory 门店库存
     * @return 门店库存
     */
    @Override
    public List<Storeinventory> selectStoreinventoryList(Storeinventory storeinventory)
    {
        return storeinventoryMapper.selectStoreinventoryList(storeinventory);
    }

    @Override
    public List<String> selectWareHouseStockFruit(String wId) {
        return storeinventoryMapper.selectWareHouseStockFruit(wId);
    }

    /**
     * 查询对应门店编号中所有的水果编号
     */
    @Override
    public List<String> selectFruitId(String shopId) {
        return storeinventoryMapper.selectFruitId(shopId);
    }

    @Override
    public String selectFruitTypeName(String code) {
        return storeinventoryMapper.selectFruitTypeName(code);
    }

    @Override
    public String selectFruitName(String code) {
        return storeinventoryMapper.selectFruitName(code);
    }

    @Override
    public String selectShopName(String sNumber) {
        return storeinventoryMapper.selectShopName(sNumber);
    }

    @Override
    public List<Warehouse> selectWareHouseId() {
        return storeinventoryMapper.selectWareHouseId();
    }

    @Override
    public List<Shop> selectShopId() {
        return storeinventoryMapper.selectShopId();
    }

    /**
     * 新增门店库存
     * 
     * @param storeinventory 门店库存
     * @return 结果
     */
    @Override
    public int insertStoreinventory(Storeinventory storeinventory)
    {
        return storeinventoryMapper.insertStoreinventory(storeinventory);
    }

    /**
     * 修改门店库存
     * 
     * @param storeinventory 门店库存
     * @return 结果
     */
    @Override
    public int updateStoreinventory(Storeinventory storeinventory)
    {
        return storeinventoryMapper.updateStoreinventory(storeinventory);
    }

    /**
     * 批量删除门店库存
     * 
     * @param inentorydetailsIds 需要删除的门店库存主键
     * @return 结果
     */
    @Override
    public int deleteStoreinventoryByInentorydetailsIds(String inentorydetailsIds)
    {
        return storeinventoryMapper.deleteStoreinventoryByInentorydetailsIds(Convert.toStrArray(inentorydetailsIds));
    }

    /**
     * 删除门店库存信息
     * 
     * @param inentorydetailsId 门店库存主键
     * @return 结果
     */
    @Override
    public int deleteStoreinventoryByInentorydetailsId(Long inentorydetailsId)
    {
        return storeinventoryMapper.deleteStoreinventoryByInentorydetailsId(inentorydetailsId);
    }
}
