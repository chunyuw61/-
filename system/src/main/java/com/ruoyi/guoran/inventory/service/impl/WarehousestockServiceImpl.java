package com.ruoyi.guoran.inventory.service.impl;

import java.util.List;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.guoran.domain.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.inventory.mapper.WarehousestockMapper;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.inventory.service.IWarehousestockService;
import com.ruoyi.common.core.text.Convert;

/**
 * 出货单Service业务层处理
 * 
 * @author 24K纯帅
 * @date 2023-12-26
 */
@Service
public class WarehousestockServiceImpl implements IWarehousestockService 
{
    @Autowired
    private WarehousestockMapper warehousestockMapper;

    /**
     * 查询出货单
     * 
     * @param whId 出货单主键
     * @return 出货单
     */
    @Override
    public Warehousestock selectWarehousestockByWhId(Long whId)
    {
        return warehousestockMapper.selectWarehousestockByWhId(whId);
    }

    /**
     * 查询出货单列表
     * 
     * @param warehousestock 出货单
     * @return 出货单
     */
    @Override
    @DataScope(deptAlias = "u", userAlias = "u2")
    public List<Warehousestock> selectWarehousestockList(Warehousestock warehousestock)
    {
        return warehousestockMapper.selectWarehousestockList(warehousestock);
    }

    /**
     * 查询对应仓库中的水果编号
     */
    @Override
    public List<String> selectFruitId(String wId) {
        return warehousestockMapper.selectFruitId(wId);
    }

    /**
     * 根据仓库编号 查询仓库名称
     */
    @Override
    public String selectWareHouseName(String wNumber) {
        return warehousestockMapper.selectWareHouseName(wNumber);
    }
    /**
     * 根据水果种类编号 查询水果种类名称
     */
    @Override
    public String selectFruitTypeName(String code) {
        return warehousestockMapper.selectFruitTypeName(code);
    }

    @Override
    public List<Warehouse> selectWid() {
        return warehousestockMapper.selectWid();
    }

    /**
     * 新增出货单
     * 
     * @param warehousestock 出货单
     * @return 结果
     */
    @Override
    public int insertWarehousestock(Warehousestock warehousestock)
    {
        return warehousestockMapper.insertWarehousestock(warehousestock);
    }

    /**
     * 修改出货单
     * 
     * @param warehousestock 出货单
     * @return 结果
     */
    @Override
    public int updateWarehousestock(Warehousestock warehousestock)
    {
        return warehousestockMapper.updateWarehousestock(warehousestock);
    }

    /**
     * 库存批量清零
     * 
     * @param whIds 需要清零库存的出货单主键集合
     * @return 结果
     */
    @Override
    public int deleteWarehousestockByWhIds(String whIds)
    {
        return warehousestockMapper.deleteWarehousestockByWhIds(Convert.toStrArray(whIds));
    }

    /**
     * 库存清零
     * 
     * @param whId 库存清零出货单主键
     * @return 结果
     */
    @Override
    public int whCountClearWhId(Long whId)
    {
        return warehousestockMapper.whCountClearWhId(whId);
    }

    /**
     * 在水果设假表中传入数据
     * @param warehousestock
     * @return
     */
    @Override
    public int insertprice(Warehousestock warehousestock) {
        return warehousestockMapper.insertprice(warehousestock);
    }
}
