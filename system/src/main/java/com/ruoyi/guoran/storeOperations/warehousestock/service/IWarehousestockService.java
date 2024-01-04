package com.ruoyi.guoran.storeOperations.warehousestock.service;

import java.util.List;

import com.ruoyi.guoran.domain.Warehousestock;

/**
 * 订货Service接口
 * 
 * @author 24K纯帅
 * @date 2023-12-26
 */
public interface IWarehousestockService 
{
    /**
     * 查询订货
     * 
     * @param whId 订货主键
     * @return 订货
     */
    public Warehousestock selectWarehousestockByWhId(Long whId);

    /**
     * 查询订货列表
     * 
     * @param warehousestock 订货
     * @return 订货集合
     */
    public List<Warehousestock> selectWarehousestockList(Warehousestock warehousestock);

    /**
     * 新增订货
     * 
     * @param warehousestock 订货
     * @return 结果
     */
    public int insertWarehousestock(Warehousestock warehousestock);

    /**
     * 修改订货
     * 
     * @param warehousestock 订货
     * @return 结果
     */
    public int updateWarehousestock(Warehousestock warehousestock);

    /**
     * 批量删除订货
     * 
     * @param whIds 需要删除的订货主键集合
     * @return 结果
     */
    public int deleteWarehousestockByWhIds(String whIds);

    /**
     * 删除订货信息
     * 
     * @param whId 订货主键
     * @return 结果
     */
    public int deleteWarehousestockByWhId(Long whId);
}
