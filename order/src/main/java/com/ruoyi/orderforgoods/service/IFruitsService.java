package com.ruoyi.orderforgoods.service;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 10:24
 */

import com.ruoyi.orderforgoods.domain.Fruits;

import java.util.List;

/**
 * 设价Service接口
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public interface IFruitsService
{
    /**
     * 查询设价
     *
     * @param fruitId 设价主键
     * @return 设价
     */
    public Fruits selectFruitsByFruitId(Long fruitId);

    /**
     * 查询设价列表
     *
     * @param fruits 设价
     * @return 设价集合
     */
    public List<Fruits> selectFruitsList(Fruits fruits);

    /**
     * 新增设价
     *
     * @param fruits 设价
     * @return 结果
     */
    public int insertFruits(Fruits fruits);

    /**
     * 修改设价
     *
     * @param fruits 设价
     * @return 结果
     */
    public int updateFruits(Fruits fruits);

    /**
     * 批量删除设价
     *
     * @param fruitIds 需要删除的设价主键集合
     * @return 结果
     */
    public int deleteFruitsByFruitIds(String fruitIds);

    /**
     * 删除设价信息
     *
     * @param fruitId 设价主键
     * @return 结果
     */
    public int deleteFruitsByFruitId(Long fruitId);

    List<Fruits> selectFruitsByFruittypesId(Long fruittypesId);
}
