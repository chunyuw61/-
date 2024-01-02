package com.ruoyi.inventory.mapper;

import java.util.List;

import com.ruoyi.inventory.domain.Warehouse;
import com.ruoyi.inventory.domain.Warehousestock;

/**
 * 出货单Mapper接口
 * 
 * @author 24K纯帅
 * @date 2023-12-26
 */
public interface WarehousestockMapper 
{
    /**
     * 查询出货单
     * 
     * @param whId 出货单主键
     * @return 出货单
     */
    public Warehousestock selectWarehousestockByWhId(Long whId);

    /**
     * 查询对应仓库中的水果编号
     */
    public List<String> selectFruitId(String wId);

    /**
     * 根据仓库编号 查询仓库名称
     */
    public String selectWareHouseName(String wNumber);

    /**
     * 根据水果种类编号 查询水果种类名称
     */
    public String selectFruitTypeName(String code);

    /**
     * 查询仓库编号, 及仓库名称
     */
    public List<Warehouse> selectWid();

    /**
     * 查询出货单列表
     * 
     * @param warehousestock 出货单
     * @return 出货单集合
     */
    public List<Warehousestock> selectWarehousestockList(Warehousestock warehousestock);

    /**
     * 新增出货单
     * 
     * @param warehousestock 出货单
     * @return 结果
     */
    public int insertWarehousestock(Warehousestock warehousestock);

    /**
     * 修改出货单
     * 
     * @param warehousestock 出货单
     * @return 结果
     */
    public int updateWarehousestock(Warehousestock warehousestock);

    /**
     * 库存清零
     * 
     * @param whId 库存清零出货单主键
     * @return 结果
     */
    public int whCountClearWhId(Long whId);

    /**
     * 库存批量清零
     * 
     * @param whIds 需要清零库存的出货单主键集合
     * @return 结果
     */
    public int deleteWarehousestockByWhIds(String[] whIds);

    /**
     * 在水果设假表中传入数据
     * @param warehousestock
     * @return
     */
    int insertprice(Warehousestock warehousestock);
}
