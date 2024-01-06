package com.ruoyi.guoran.orderforgoods.service;



import com.ruoyi.guoran.orderforgoods.domain.OrderShopprice;

import java.util.List;

/**
 * orderforgoodsService接口
 *
 * @author chunyuw61
 * @date 2024-01-02
 */
public interface OrderIShoppriceService {
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
     * 批量删除orderforgoods
     *
     * @param shoppriceIds 需要删除的orderforgoods主键集合
     * @return 结果
     */
    public int deleteOederShoppriceByShoppriceIds(String shoppriceIds);

    /**
     * 删除orderforgoods信息
     *
     * @param shoppriceId orderforgoods主键
     * @return 结果
     */
    public int deleteOederShoppriceByShoppriceId(Long shoppriceId);

    /*
     * 查询单价*/
    Double selectPriceBySNumberAndCode(String sNumber, String code);
}
