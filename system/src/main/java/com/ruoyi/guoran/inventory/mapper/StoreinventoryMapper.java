package com.ruoyi.guoran.inventory.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.guoran.domain.Storeinventory;
import com.ruoyi.guoran.domain.Warehouse;
import com.ruoyi.guoran.domain.Shop;
import com.ruoyi.guoran.domain.Warehousestock;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门店库存Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-27
 */

@Mapper
public interface StoreinventoryMapper 
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
     * 查询对应仓库中有的水果
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
     *  根据水果名称 查询水果编号
     */
    public String selectFruitIdByFruitName(String name);

    /**
     *  根据水果编号 查询水果名称
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
     * 根据仓库编号查询所有门店编号
     */
    public List<SysDept> selectShopIdByWareHouseId(SysDept sysDept);

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
     * 删除门店库存
     * 
     * @param inentorydetailsId 门店库存主键
     * @return 结果
     */
    public int deleteStoreinventoryByInentorydetailsId(Long inentorydetailsId);

    /**
     * 批量删除门店库存
     * 
     * @param inentorydetailsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoreinventoryByInentorydetailsIds(String[] inentorydetailsIds);
}
