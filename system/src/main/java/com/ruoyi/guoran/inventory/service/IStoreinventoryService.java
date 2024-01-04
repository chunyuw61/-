package com.ruoyi.guoran.inventory.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.guoran.domain.Storeinventory;
import com.ruoyi.guoran.domain.Warehouse;
import com.ruoyi.guoran.domain.Shop;
import com.ruoyi.guoran.domain.Warehousestock;

/**
 * 门店库存Service接口
 * 
 * @author ruoyi
 * @date 2023-12-27
 */
public interface IStoreinventoryService 
{
    /**
     * 查询门店库存
     * 
     * @param inentorydetailsId 门店库存主键
     * @return 门店库存
     */
    public Storeinventory selectStoreinventoryByInentorydetailsId(Long inentorydetailsId);

    /**
     * 查询门店库存列表
     * 
     * @param storeinventory 门店库存
     * @return 门店库存集合
     */
    public List<Storeinventory> selectStoreinventoryList(Storeinventory storeinventory);

    /**
     * 查询每个仓库中有的水果
     */
    public List<Warehousestock> selectWareHouseStockFruit(String wId);

    /**
     * 查询对应门店编号中所有的水果编号
     */
    public List<String> selectFruitId(String shopId);

    /**
     * 根据水果种类编号 查询水果种类名称
     */
    public String selectFruitTypeName(String code);

    /**
     *  根据水果编号查询水果名称
     */
    public String selectFruitName(String code);

    /**
     * 根据门店编号 查询门店名称
     */
    public String selectShopName(String sNumber);

    /**
     * 查询所有的仓库编号
     */
    public List<Warehouse> selectWareHouseId();

    /**
     * 查询所有的门店编号
     */
    public List<Shop> selectShopId();

    /**
     * 根据登录门店的菜单列表id,去查询配货仓库的部门id 和 部门名称
     */
    public SysDept selectWareAncestorsByShopAncestors(SysDept sysDept);

    /**
     * 新增门店库存
     * 
     * @param storeinventory 门店库存
     * @return 结果
     */
    public int insertStoreinventory(Storeinventory storeinventory);

    /**
     * 修改门店库存
     * 
     * @param storeinventory 门店库存
     * @return 结果
     */
    public int updateStoreinventory(Storeinventory storeinventory);

    /**
     * 批量删除门店库存
     * 
     * @param inentorydetailsIds 需要删除的门店库存主键集合
     * @return 结果
     */
    public int deleteStoreinventoryByInentorydetailsIds(String inentorydetailsIds);

    /**
     * 删除门店库存信息
     * 
     * @param inentorydetailsId 门店库存主键
     * @return 结果
     */
    public int deleteStoreinventoryByInentorydetailsId(Long inentorydetailsId);
}
