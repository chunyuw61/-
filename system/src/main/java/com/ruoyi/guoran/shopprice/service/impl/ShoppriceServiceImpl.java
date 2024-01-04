package com.ruoyi.shopprice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shopprice.mapper.ShoppriceMapper;
import com.ruoyi.shopprice.domain.Shopprice;
import com.ruoyi.shopprice.service.IShoppriceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 门店价格Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-29
 */
@Service
public class ShoppriceServiceImpl implements IShoppriceService 
{
    @Autowired
    private ShoppriceMapper shoppriceMapper;

    /**
     * 查询门店价格
     * 
     * @param shoppriceId 门店价格主键
     * @return 门店价格
     */
    @Override
    public Shopprice selectShoppriceByShoppriceId(Long shoppriceId)
    {
        return shoppriceMapper.selectShoppriceByShoppriceId(shoppriceId);
    }

    /**
     * 查询门店价格列表
     * 
     * @param shopprice 门店价格
     * @return 门店价格
     */
    @Override
    public List<Shopprice> selectShoppriceList(Shopprice shopprice)
    {
        return shoppriceMapper.selectShoppriceList(shopprice);
    }

    /**
     * 新增门店价格
     * 
     * @param shopprice 门店价格
     * @return 结果
     */
    @Override
    public int insertShopprice(Shopprice shopprice)
    {
        return shoppriceMapper.insertShopprice(shopprice);
    }

    /**
     * 修改门店价格
     * 
     * @param shopprice 门店价格
     * @return 结果
     */
    @Override
    public int updateShopprice(Shopprice shopprice)
    {
        return shoppriceMapper.updateShopprice(shopprice);
    }

    /**
     * 批量删除门店价格
     * 
     * @param shoppriceIds 需要删除的门店价格主键
     * @return 结果
     */
    @Override
    public int deleteShoppriceByShoppriceIds(String shoppriceIds)
    {
        return shoppriceMapper.deleteShoppriceByShoppriceIds(Convert.toStrArray(shoppriceIds));
    }

    /**
     * 删除门店价格信息
     * 
     * @param shoppriceId 门店价格主键
     * @return 结果
     */
    @Override
    public int deleteShoppriceByShoppriceId(Long shoppriceId)
    {
        return shoppriceMapper.deleteShoppriceByShoppriceId(shoppriceId);
    }

    @Override
    public Integer updateprice(double lsj, double zk, String fruitcode) {
        Integer updateprice = shoppriceMapper.updateprice(lsj, zk, fruitcode);

        return updateprice;
    }
}
