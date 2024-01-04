package com.ruoyi.guoran.storeOperations.warehousestock.service.impl;

import java.util.List;

import com.ruoyi.guoran.domain.Warehousestock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.storeOperations.warehousestock.mapper.WarehousestockMapper1;
import com.ruoyi.guoran.storeOperations.warehousestock.service.IWarehousestockService;
import com.ruoyi.common.core.text.Convert;

/**
 * 订货Service业务层处理
 * 
 * @author 24K纯帅
 * @date 2023-12-26
 */
@Service
public class WarehousestockServiceImpl1 implements IWarehousestockService
{
    @Autowired
    private WarehousestockMapper1 warehousestockMapper1;

    /**
     * 查询订货
     * 
     * @param whId 订货主键
     * @return 订货
     */
    @Override
    public Warehousestock selectWarehousestockByWhId(Long whId)
    {
        return warehousestockMapper1.selectWarehousestockByWhId(whId);
    }

    /**
     * 查询订货列表
     * 
     * @param warehousestock 订货
     * @return 订货
     */
    @Override
    public List<Warehousestock> selectWarehousestockList(Warehousestock warehousestock)
    {
        return warehousestockMapper1.selectWarehousestockList(warehousestock);
    }

    /**
     * 新增订货
     * 
     * @param warehousestock 订货
     * @return 结果
     */
    @Override
    public int insertWarehousestock(Warehousestock warehousestock)
    {
        return warehousestockMapper1.insertWarehousestock(warehousestock);
    }

    /**
     * 修改订货
     * 
     * @param warehousestock 订货
     * @return 结果
     */
    @Override
    public int updateWarehousestock(Warehousestock warehousestock)
    {
        return warehousestockMapper1.updateWarehousestock(warehousestock);
    }

    /**
     * 批量删除订货
     * 
     * @param whIds 需要删除的订货主键
     * @return 结果
     */
    @Override
    public int deleteWarehousestockByWhIds(String whIds)
    {
        return warehousestockMapper1.deleteWarehousestockByWhIds(Convert.toStrArray(whIds));
    }

    /**
     * 删除订货信息
     * 
     * @param whId 订货主键
     * @return 结果
     */
    @Override
    public int deleteWarehousestockByWhId(Long whId)
    {
        return warehousestockMapper1.deleteWarehousestockByWhId(whId);
    }
}
