package com.ruoyi.shopprice.mapper;

import java.util.List;
import com.ruoyi.shopprice.domain.Shopprice;

/**
 * 门店价格Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-29
 */
public interface ShoppriceMapper 
{
    /**
     * 查询门店价格
     * 
     * @param shoppriceId 门店价格主键
     * @return 门店价格
     */
    public Shopprice selectShoppriceByShoppriceId(Long shoppriceId);

    /**
     * 查询门店价格列表
     * 
     * @param shopprice 门店价格
     * @return 门店价格集合
     */
    public List<Shopprice> selectShoppriceList(Shopprice shopprice);

    /**
     * 新增门店价格
     * 
     * @param shopprice 门店价格
     * @return 结果
     */
    public int insertShopprice(Shopprice shopprice);

    /**
     * 修改门店价格
     * 
     * @param shopprice 门店价格
     * @return 结果
     */
    public int updateShopprice(Shopprice shopprice);

    /**
     * 删除门店价格
     * 
     * @param shoppriceId 门店价格主键
     * @return 结果
     */
    public int deleteShoppriceByShoppriceId(Long shoppriceId);

    /**
     * 批量删除门店价格
     * 
     * @param shoppriceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteShoppriceByShoppriceIds(String[] shoppriceIds);

    Integer updateprice(double lsj, double zk, String fruitcode);
}
