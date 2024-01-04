package com.ruoyi.shop.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.shop.mapper.ShopMapper;
import com.ruoyi.shop.domain.Shop;
import com.ruoyi.shop.service.IShopService;
import com.ruoyi.common.core.text.Convert;

/**
 * 门店信息Service业务层处理
 *
 * @author zgf
 * @date 2023-12-26
 */
@Service
public class ShopServiceImpl implements IShopService
{
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 查询门店信息
     *
     * @param sId 门店信息主键
     * @return 门店信息
     */
    @Override
    public Shop selectShopBySId(Long sId)
    {
        return shopMapper.selectShopBySId(sId);
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
        return shopMapper.selectShopList(shop);
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
        return shopMapper.insertShop(shop);
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
        return shopMapper.updateShop(shop);
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
        return shopMapper.deleteShopBySIds(Convert.toStrArray(sIds));
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
        return shopMapper.deleteShopBySId(sId);
    }

    @Override
    public List<String> selectname() {
        List<String> selectname = shopMapper.
                selectname();

        return selectname;
    }

    @Override
    public String  selectname1(String name) {
        String s = shopMapper.selectname1(name);
        return s;
    }
}
