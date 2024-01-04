package com.ruoyi.guoran.price.service.impl;

import java.util.List;

import com.ruoyi.guoran.price.domain.PriceFruitPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.price.mapper.PriceFruitPriceMapper;
import com.ruoyi.guoran.price.service.IFruitPriceService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设价Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class PriceFruitPriceServiceImpl implements IFruitPriceService
{
    @Autowired
    private PriceFruitPriceMapper priceFruitPriceMapper;

    /**
     * 查询设价
     * 
     * @param pId 设价主键
     * @return 设价
     */
    @Override
    public PriceFruitPrice selectFruitPriceByPId(Long pId)
    {
        return priceFruitPriceMapper.selectFruitPriceByPId(pId);
    }

    /**
     * 查询设价列表
     * 
     * @param priceFruitPrice 设价
     * @return 设价
     */
    @Override
    public List<PriceFruitPrice> selectFruitPriceList(PriceFruitPrice priceFruitPrice)
    {
        return priceFruitPriceMapper.selectFruitPriceList(priceFruitPrice);
    }

    /**
     * 新增设价
     * 
     * @param priceFruitPrice 设价
     * @return 结果
     */
    @Override
    public int insertFruitPrice(PriceFruitPrice priceFruitPrice)
    {
        return priceFruitPriceMapper.insertFruitPrice(priceFruitPrice);
    }

    /**
     * 修改设价
     * 
     * @param priceFruitPrice 设价
     * @return 结果
     */
    @Override
    public int updateFruitPrice(PriceFruitPrice priceFruitPrice)
    {
        return priceFruitPriceMapper.updateFruitPrice(priceFruitPrice);
    }

    /**
     * 批量删除设价
     * 
     * @param pIds 需要删除的设价主键
     * @return 结果
     */
    @Override
    public int deleteFruitPriceByPIds(String pIds)
    {
        return priceFruitPriceMapper.deleteFruitPriceByPIds(Convert.toStrArray(pIds));
    }

    /**
     * 删除设价信息
     * 
     * @param pId 设价主键
     * @return 结果
     */
    @Override
    public int deleteFruitPriceByPId(Long pId)
    {
        return priceFruitPriceMapper.deleteFruitPriceByPId(pId);
    }


    @Override
    public double selectJ(String code) {
        double v = priceFruitPriceMapper.selectJ(code);
        return v;
    }

    @Override
    public Integer selectID(String code) {
        Integer i = priceFruitPriceMapper.selectID(code);
        return i;
    }

    @Override
    public Integer insertBCprice(double hxj, double lsj,String id) {
        Integer i = priceFruitPriceMapper.insertBCprice(hxj, lsj,id);
        return i;
    }
}
