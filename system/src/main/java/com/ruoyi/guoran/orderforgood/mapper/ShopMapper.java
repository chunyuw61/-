package com.ruoyi.guoran.orderforgood.mapper;

import com.ruoyi.guoran.domain.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门店信息Mapper接口
 * 
 * @author chunyuw61
 * @date 2023-12-29
 */
@Mapper
public interface ShopMapper
{
    /**
     * 查询门店信息
     * 
     * @param sId 门店信息主键
     * @return 门店信息
     */
    public Shop selectShopBySId(Long sId);

    /**
     * 查询门店信息列表
     * 
     * @param shop 门店信息
     * @return 门店信息集合
     */
    public List<Shop> selectShopList(Shop shop);

    /**
     * 新增门店信息
     * 
     * @param shop 门店信息
     * @return 结果
     */
    public int insertShop(Shop shop);

    /**
     * 修改门店信息
     * 
     * @param shop 门店信息
     * @return 结果
     */
    public int updateShop(Shop shop);

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
