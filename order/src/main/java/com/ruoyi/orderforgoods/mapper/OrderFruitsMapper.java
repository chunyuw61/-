package com.ruoyi.orderforgoods.mapper;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 10:21
 */


import com.ruoyi.orderforgoods.domain.OrderFruits;

import java.util.List;

/**
 * 设价Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public interface OrderFruitsMapper
{
    /**
     * 查询设价
     *
     * @param fruitId 设价主键
     * @return 设价
     */
    public OrderFruits selectFruitsByFruitId(Long fruitId);

    /**
     * 查询设价列表
     *
     * @param fruits 设价
     * @return 设价集合
     */
    public List<OrderFruits> selectFruitsList(OrderFruits fruits);

    /**
     * 新增设价
     *
     * @param fruits 设价
     * @return 结果
     */
    public int insertFruits(OrderFruits fruits);

    /**
     * 修改设价
     *
     * @param fruits 设价
     * @return 结果
     */
    public int updateFruits(OrderFruits fruits);

    /**
     * 删除设价
     *
     * @param fruitId 设价主键
     * @return 结果
     */
    public int deleteFruitsByFruitId(Long fruitId);

    /**
     * 批量删除设价
     *
     * @param fruitIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFruitsByFruitIds(String[] fruitIds);

    /*根据fruittypesId查询*/
    List<OrderFruits> selectFruitsByFruittypesId(Long fruittypesId);
}
