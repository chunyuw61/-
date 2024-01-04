package com.ruoyi.guoran.fruits.mapper;

import com.ruoyi.guoran.domain.Fruits;

import java.util.List;

/**
 * 水果 水果Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-02
 */
public interface FruitsMapper1
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
     * 删除水果 水果
     * 
     * @param fruitId 水果 水果主键
     * @return 结果
     */
    public int deleteFruitsByFruitId(Long fruitId);

    /**
     * 批量删除水果 水果
     * 
     * @param fruitIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFruitsByFruitIds(String[] fruitIds);
}
