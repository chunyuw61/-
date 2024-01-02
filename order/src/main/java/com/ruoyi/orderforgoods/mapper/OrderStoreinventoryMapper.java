package com.ruoyi.orderforgoods.mapper;


import com.ruoyi.orderforgoods.domain.OrderStoreinventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 门店库存Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-28
 */
public interface OrderStoreinventoryMapper
{
    /**
     * 查询门店库存
     * 
     * @param inentorydetailsId 门店库存主键
     * @return 门店库存
     */
    public OrderStoreinventory selectStoreinventoryByInentorydetailsId(Long inentorydetailsId);

    /**
     * 查询门店库存列表
     * 
     * @param storeinventory 门店库存
     * @return 门店库存集合
     */
    public List<OrderStoreinventory> selectStoreinventoryList(OrderStoreinventory storeinventory);

    /**
     * 新增门店库存
     * 
     * @param storeinventory 门店库存
     * @return 结果
     */
    public int insertStoreinventory(OrderStoreinventory storeinventory);

    /**
     * 修改门店库存
     * 
     * @param storeinventory 门店库存
     * @return 结果
     */
    public int updateStoreinventory(OrderStoreinventory storeinventory);

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



    /*条件查询*/
    OrderStoreinventory selectStoreinventoryByShopIdAndFruitId(@Param("shopId") String shopId, @Param("fruitId") String fruitId);
}
