package com.ruoyi.guoran.orderforgoods.mapper;


import com.ruoyi.guoran.orderforgoods.domain.OrderShopprice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * orderforgoodsMapper接口
 * 
 * @author chunyuw61
 * @date 2024-01-02
 */
@Mapper
public interface OrderShoppriceMapper
{
    /**
     * 查询orderforgoods
     * 
     * @param shoppriceId orderforgoods主键
     * @return orderforgoods
     */
    public OrderShopprice selectOederShoppriceByShoppriceId(Long shoppriceId);

    /**
     * 查询orderforgoods列表
     * 
     * @param oederShopprice orderforgoods
     * @return orderforgoods集合
     */
    public List<OrderShopprice> selectOederShoppriceList(OrderShopprice oederShopprice);

    /**
     * 新增orderforgoods
     * 
     * @param oederShopprice orderforgoods
     * @return 结果
     */
    public int insertOederShopprice(OrderShopprice oederShopprice);

    /**
     * 修改orderforgoods
     * 
     * @param oederShopprice orderforgoods
     * @return 结果
     */
    public int updateOederShopprice(OrderShopprice oederShopprice);

    /**
     * 删除orderforgoods
     * 
     * @param shoppriceId orderforgoods主键
     * @return 结果
     */
    public int deleteOederShoppriceByShoppriceId(Long shoppriceId);

    /**
     * 批量删除orderforgoods
     * 
     * @param shoppriceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOederShoppriceByShoppriceIds(String[] shoppriceIds);

    /*查询单价*/
    Double selectOederShoppriceBySNumberAndCode(@Param("sNumber") String sNumber, @Param("code") String code);
}
