package com.ruoyi.guoran.orderforgood.mapper;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 15:16
 */


import com.ruoyi.guoran.domain.FruitPrice;

import java.util.List;

/**
 * 设价Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public interface FruitPriceMapper {
    /**
     * 查询设价
     *
     * @param pId 设价主键
     * @return 设价
     */
    public FruitPrice selectFruitPriceByPId(Long pId);

    /**
     * 查询设价列表
     *
     * @param fruitPrice 设价
     * @return 设价集合
     */
    public List<FruitPrice> selectFruitPriceList(FruitPrice fruitPrice);

    /**
     * 新增设价
     *
     * @param fruitPrice 设价
     * @return 结果
     */
    public int insertFruitPrice(FruitPrice fruitPrice);

    /**
     * 修改设价
     *
     * @param fruitPrice 设价
     * @return 结果
     */
    public int updateFruitPrice(FruitPrice fruitPrice);

    /**
     * 删除设价
     *
     * @param pId 设价主键
     * @return 结果
     */
    public int deleteFruitPriceByPId(Long pId);

    /**
     * 批量删除设价
     *
     * @param pIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFruitPriceByPIds(String[] pIds);

    /*
     * 查询单价
     */

    Double selectPriceByCode(String code);


}
