package com.ruoyi.guoran.orderforgoods.mapper;


import com.ruoyi.guoran.orderforgoods.domain.OrderShop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门店信息Mapper接口
 * 
 * @author chunyuw61
 * @date 2023-12-29
 */
@Mapper
public interface OrderShopMapper
{
    /**
     * 查询门店信息
     * 
     * @param sId 门店信息主键
     * @return 门店信息
     */
    public OrderShop selectShopBySId(Long sId);

    /**
     * 查询门店信息列表
     * 
     * @param shop 门店信息
     * @return 门店信息集合
     */
    public List<OrderShop> selectShopList(OrderShop shop);

    /**
     * 新增门店信息
     * 
     * @param shop 门店信息
     * @return 结果
     */
    public int insertShop(OrderShop shop);

    /**
     * 修改门店信息
     * 
     * @param shop 门店信息
     * @return 结果
     */
    public int updateShop(OrderShop shop);

    /**
     * 删除门店信息
     * 
     * @param sId 门店信息主键
     * @return 结果
     */
    public int deleteShopBySId(Long sId);

    /**
     * 批量删除门店信息
     * 
     * @param sIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShopBySIds(String[] sIds);
}
