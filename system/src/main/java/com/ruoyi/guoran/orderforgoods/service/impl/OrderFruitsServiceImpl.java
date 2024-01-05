package com.ruoyi.guoran.orderforgoods.service.impl;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 10:25
 */


import com.ruoyi.common.core.text.Convert;

import com.ruoyi.guoran.orderforgoods.domain.OrderFruits;
import com.ruoyi.guoran.orderforgoods.mapper.OrderFruitsMapper;
import com.ruoyi.guoran.orderforgoods.service.OrderIFruitsService;
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
public class OrderFruitsServiceImpl implements OrderIFruitsService
{
    @Autowired
    private OrderFruitsMapper fruitsMapper;

    /**
     * 查询设价
     *
     * @param fruitId 设价主键
     * @return 设价
     */
    @Override
    public OrderFruits selectFruitsByFruitId(Long fruitId)
    {
        return fruitsMapper.selectFruitsByFruitId(fruitId);
    }

    /**
     * 查询设价列表
     *
     * @param fruits 设价
     * @return 设价
     */
    @Override
    public List<OrderFruits> selectFruitsList(OrderFruits fruits)
    {
        return fruitsMapper.selectFruitsList(fruits);
    }

    /**
     * 新增设价
     *
     * @param fruits 设价
     * @return 结果
     */
    @Override
    public int insertFruits(OrderFruits fruits)
    {
        return fruitsMapper.insertFruits(fruits);
    }

    /**
     * 修改设价
     *
     * @param fruits 设价
     * @return 结果
     */
    @Override
    public int updateFruits(OrderFruits fruits)
    {
        return fruitsMapper.updateFruits(fruits);
    }

    /**
     * 批量删除设价
     *
     * @param fruitIds 需要删除的设价主键
     * @return 结果
     */
    @Override
    public int deleteFruitsByFruitIds(String fruitIds)
    {
        return fruitsMapper.deleteFruitsByFruitIds(Convert.toStrArray(fruitIds));
    }

    /**
     * 删除设价信息
     *
     * @param fruitId 设价主键
     * @return 结果
     */
    @Override
    public int deleteFruitsByFruitId(Long fruitId)
    {
        return fruitsMapper.deleteFruitsByFruitId(fruitId);
    }

    @Override
    public List<OrderFruits> selectFruitsByFruittypesId(Long fruittypesId) {
        return fruitsMapper.selectFruitsByFruittypesId(fruittypesId);
    }
}
