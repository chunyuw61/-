package com.ruoyi.guoran.warehouse.service.impl;

import java.util.List;

import com.ruoyi.guoran.domain.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.warehouse.mapper.WarehouseMapper;
import com.ruoyi.guoran.warehouse.service.WarehouseIWarehouseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 仓库信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
@Service
public class WarehouseServiceImplWarehouse implements WarehouseIWarehouseService
{
    @Autowired
    private WarehouseMapper warehouseMapper;

    /**
     * 查询仓库信息
     * 
     * @param wId 仓库信息主键
     * @return 仓库信息
     */
    @Override
    public Warehouse selectWarehouseByWId(Long wId)
    {
        return warehouseMapper.selectWarehouseByWId(wId);
    }

    /**
     * 查询仓库信息列表
     * 
     * @param warehouse 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<Warehouse> selectWarehouseList(Warehouse warehouse)
    {
        return warehouseMapper.selectWarehouseList(warehouse);
    }

    /**
     * 新增仓库信息
     * 
     * @param warehouse 仓库信息
     * @return 结果
     */
    @Override
    public int insertWarehouse(Warehouse warehouse)
    {
        return warehouseMapper.insertWarehouse(warehouse);
    }

    /**
     * 修改仓库信息
     * 
     * @param warehouse 仓库信息
     * @return 结果
     */
    @Override
    public int updateWarehouse(Warehouse warehouse)
    {
        return warehouseMapper.updateWarehouse(warehouse);
    }

    /**
     * 批量删除仓库信息
     * 
     * @param wIds 需要删除的仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByWIds(String wIds)
    {
        return warehouseMapper.deleteWarehouseByWIds(Convert.toStrArray(wIds));
    }

    /**
     * 删除仓库信息信息
     * 
     * @param wId 仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteWarehouseByWId(Long wId)
    {
        return warehouseMapper.deleteWarehouseByWId(wId);
    }
}
