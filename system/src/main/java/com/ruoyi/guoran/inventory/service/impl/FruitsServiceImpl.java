package com.ruoyi.guoran.inventory.service.impl;

import java.util.List;

import com.ruoyi.guoran.inventory.service.IFruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.inventory.mapper.FruitsMapper;
import com.ruoyi.guoran.domain.Fruits;
import com.ruoyi.common.core.text.Convert;

/**
 * 水果 水果Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class FruitsServiceImpl implements IFruitsService
{
    @Autowired
    private FruitsMapper fruitsMapper;

    /**
     * 查询水果 水果
     * 
     * @param fruitId 水果 水果主键
     * @return 水果 水果
     */
    @Override
    public Fruits selectFruitsByFruitId(Long fruitId)
    {
        return fruitsMapper.selectFruitsByFruitId(fruitId);
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
        return fruitsMapper.selectFruitsList(fruits);
    }

    /**
     * 根据水果种类编号 查询水果种类名称
     */
    @Override
    public String selectFruitTypeName(String code) {
        return fruitsMapper.selectFruitTypeName(code);
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
        return fruitsMapper.insertFruits(fruits);
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
        return fruitsMapper.updateFruits(fruits);
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
        return fruitsMapper.deleteFruitsByFruitIds(Convert.toStrArray(fruitIds));
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
        return fruitsMapper.deleteFruitsByFruitId(fruitId);
    }

}
