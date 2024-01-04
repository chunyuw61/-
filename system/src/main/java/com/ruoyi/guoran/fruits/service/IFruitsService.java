package com.ruoyi.guoran.fruits.service;

import com.ruoyi.guoran.domain.Fruits;

import java.util.List;

/**
 * 水果 水果Service接口
 * 
 * @author ruoyi
 * @date 2024-01-02
 */
public interface IFruitsService 
{
    /**
     * 查询水果 水果
     * 
     * @param fruitId 水果 水果主键
     * @return 水果 水果
     */
    public Fruits selectFruitsByFruitId(Long fruitId);

    /**
     * 查询水果 水果列表
     * 
     * @param fruits 水果 水果
     * @return 水果 水果集合
     */
    public List<Fruits> selectFruitsList(Fruits fruits);

    /**
     * 新增水果 水果
     * 
     * @param fruits 水果 水果
     * @return 结果
     */
    public int insertFruits(Fruits fruits);

    /**
     * 修改水果 水果
     * 
     * @param fruits 水果 水果
     * @return 结果
     */
    public int updateFruits(Fruits fruits);

    /**
     * 批量删除水果 水果
     * 
     * @param fruitIds 需要删除的水果 水果主键集合
     * @return 结果
     */
    public int deleteFruitsByFruitIds(String fruitIds);

    /**
     * 删除水果 水果信息
     * 
     * @param fruitId 水果 水果主键
     * @return 结果
     */
    public int deleteFruitsByFruitId(Long fruitId);
}
