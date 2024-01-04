package com.ruoyi.guoran.shop.service.impl;

import java.util.List;

import com.ruoyi.guoran.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.shop.mapper.ShopShopMapper;
import com.ruoyi.shop.service.ShopIShopService;
import com.ruoyi.common.core.text.Convert;

/**
 * 门店信息Service业务层处理
 *
 * @author zgf
 * @date 2023-12-26
 */
@Service
public class ShopShopServiceImplShop implements ShopIShopService
{
    @Autowired
    private ShopShopMapper shopShopMapper;

    /**
     * 查询门店信息
     *
     * @param sId 门店信息主键
     * @return 门店信息
     */
    @Override
    public Shop selectShopBySId(Long sId)
    {
        return shopShopMapper.selectShopBySId(sId);
    }

    /**
     * 查询门店信息列表
     *
     * @param shop 门店信息
     * @return 门店信息
     */
    @Override
    public List<Shop> selectShopList(Shop shop)
    {
        return shopShopMapper.selectShopList(shop);
    }

    /**
     * 新增门店信息
     *
     * @param shop 门店信息
     * @return 结果
     */
    @Override
    public int insertShop(Shop shop)
    {
        return shopShopMapper.insertShop(shop);
    }

    /**
     * 修改门店信息
     *
     * @param shop 门店信息
     * @return 结果
     */
    @Override
    public int updateShop(Shop shop)
    {
        return shopShopMapper.updateShop(shop);
    }

    /**
     * 批量删除门店信息
     *
     * @param sIds 需要删除的门店信息主键
     * @return 结果
     */
    @Override
    public int deleteShopBySIds(String sIds)
    {
        return shopShopMapper.deleteShopBySIds(Convert.toStrArray(sIds));
    }

    /**
     * 删除门店信息信息
     *
     * @param sId 门店信息主键
     * @return 结果
     */
    @Override
    public int deleteShopBySId(Long sId)
    {
        return shopShopMapper.deleteShopBySId(sId);
    }

    @Override
    public List<String> selectname() {
        List<String> selectname = shopShopMapper.
                selectname();

        return selectname;
    }

    @Override
    public String  selectname1(String name) {
        String s = shopShopMapper.selectname1(name);
        return s;
    }
}
