package com.ruoyi.guoran.warehouse.service;

import com.ruoyi.guoran.domain.Warehouse;

import java.util.List;

/**
 * 仓库信息Service接口
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
public interface WarehouseIWarehouseService
{
    /**
     * 查询仓库信息
     * 
     * @param wId 仓库信息主键
     * @return 仓库信息
     */
    public Warehouse selectWarehouseByWId(Long wId);

    /**
     * 查询仓库信息列表
     * 
     * @param warehouse 仓库信息
     * @return 仓库信息集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增仓库信息
     * 
     * @param warehouse 仓库信息
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改仓库信息
     * 
     * @param warehouse 仓库信息
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 批量删除仓库信息
     * 
     * @param wIds 需要删除的仓库信息主键集合
     * @return 结果
     */
    public int deleteWarehouseByWIds(String wIds);

    /**
     * 删除仓库信息信息
     * 
     * @param wId 仓库信息主键
     * @return 结果
     */
    public int deleteWarehouseByWId(Long wId);
}
