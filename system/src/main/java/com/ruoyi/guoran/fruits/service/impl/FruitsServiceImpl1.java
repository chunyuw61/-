package com.ruoyi.guoran.fruits.service.impl;

import java.util.List;

import com.ruoyi.guoran.domain.Fruits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.fruits.mapper.FruitsMapper1;
import com.ruoyi.guoran.fruits.service.IFruitsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 水果 水果Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-02
 */
@Service
public class FruitsServiceImpl1 implements IFruitsService
{
    @Autowired
    private FruitsMapper1 fruitsMapper1;

    /**
     * 查询水果 水果
     * 
     * @param fruitId 水果 水果主键
     * @return 水果 水果
     */
    @Override
    public Fruits selectFruitsByFruitId(Long fruitId)
    {
        return fruitsMapper1.selectFruitsByFruitId(fruitId);
    }

    /**
     * 查询水果 水果列表
     * 
     * @param fruits 水果 水果
     * @return 水果 水果
     */
    @Override
    public List<Fruits> selectFruitsList(Fruits fruits)
    {
        return fruitsMapper1.selectFruitsList(fruits);
    }

    /**
     * 新增水果 水果
     * 
     * @param fruits 水果 水果
     * @return 结果
     */
    @Override
    public int insertFruits(Fruits fruits)
    {
        return fruitsMapper1.insertFruits(fruits);
    }

    /**
     * 修改水果 水果
     * 
     * @param fruits 水果 水果
     * @return 结果
     */
    @Override
    public int updateFruits(Fruits fruits)
    {
        return fruitsMapper1.updateFruits(fruits);
    }

    /**
     * 批量删除水果 水果
     * 
     * @param fruitIds 需要删除的水果 水果主键
     * @return 结果
     */
    @Override
    public int deleteFruitsByFruitIds(String fruitIds)
    {
        return fruitsMapper1.deleteFruitsByFruitIds(Convert.toStrArray(fruitIds));
    }

    /**
     * 删除水果 水果信息
     * 
     * @param fruitId 水果 水果主键
     * @return 结果
     */
    @Override
    public int deleteFruitsByFruitId(Long fruitId)
    {
        return fruitsMapper1.deleteFruitsByFruitId(fruitId);
    }
}
