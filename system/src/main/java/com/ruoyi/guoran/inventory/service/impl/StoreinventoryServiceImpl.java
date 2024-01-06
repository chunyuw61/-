package com.ruoyi.guoran.inventory.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.inventory.service.IStoreinventoryService;
import com.ruoyi.guoran.domain.Warehouse;
import com.ruoyi.guoran.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.inventory.mapper.StoreinventoryMapper;
import com.ruoyi.guoran.domain.Storeinventory;
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
    @DataScope(deptAlias = "u", userAlias = "u2")
    public List<Storeinventory> selectStoreinventoryList(Storeinventory storeinventory)
    {
        return storeinventoryMapper.selectStoreinventoryList(storeinventory);
    }

    @Override
    public List<Warehousestock> selectWareHouseStockFruit(String wId) {
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
    public String selectFruitIdByFruitName(String name) {
        return storeinventoryMapper.selectFruitIdByFruitName(name);
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
    public List<SysDept> selectShopIdByWareHouseId(SysDept sysDept) {
        return storeinventoryMapper.selectShopIdByWareHouseId(sysDept);
    }


    @Override
    public SysDept selectWareAncestorsByShopAncestors(SysDept sysDept) {
        return storeinventoryMapper.selectWareAncestorsByShopAncestors(sysDept);
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
