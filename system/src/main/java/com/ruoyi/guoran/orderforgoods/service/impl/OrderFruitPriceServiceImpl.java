package com.ruoyi.guoran.orderforgoods.service.impl;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 15:21
 */


import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderFruitPrice;
import com.ruoyi.guoran.orderforgoods.mapper.OrderFruitPriceMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIFruitPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 设价Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-26
 */
@Service
public class OrderFruitPriceServiceImpl implements OrderIFruitPriceService {
    @Autowired
    private OrderFruitPriceMapper fruitPriceMapper;

    /**
     * 查询设价
     *
     * @param pId 设价主键
     * @return 设价
     */
    @Override
    public OrderFruitPrice selectFruitPriceByPId(Long pId) {
        return fruitPriceMapper.selectFruitPriceByPId(pId);
    }

    /**
     * 查询设价列表
     *
     * @param fruitPrice 设价
     * @return 设价
     */
    @Override
    public List<OrderFruitPrice> selectFruitPriceList(OrderFruitPrice fruitPrice) {
        return fruitPriceMapper.selectFruitPriceList(fruitPrice);
    }

    /**
     * 新增设价
     *
     * @param fruitPrice 设价
     * @return 结果
     */
    @Override
    public int insertFruitPrice(OrderFruitPrice fruitPrice) {
        return fruitPriceMapper.insertFruitPrice(fruitPrice);
    }

    /**
     * 修改设价
     *
     * @param fruitPrice 设价
     * @return 结果
     */
    @Override
    public int updateFruitPrice(OrderFruitPrice fruitPrice) {
        return fruitPriceMapper.updateFruitPrice(fruitPrice);
    }

    /**
     * 批量删除设价
     *
     * @param pIds 需要删除的设价主键
     * @return 结果
     */
    @Override
    public int deleteFruitPriceByPIds(String pIds) {
        return fruitPriceMapper.deleteFruitPriceByPIds(Convert.toStrArray(pIds));
    }

    /**
     * 删除设价信息
     *
     * @param pId 设价主键
     * @return 结果
     */
    @Override
    public int deleteFruitPriceByPId(Long pId) {
        return fruitPriceMapper.deleteFruitPriceByPId(pId);
    }

    /*
    查询单价
    */


    @Override
    public Double getPriceByCode(String code) {
        return fruitPriceMapper.selectPriceByCode(code);
    }

}

