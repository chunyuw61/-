package com.ruoyi.price.mapper;

import java.util.List;
import com.ruoyi.price.domain.FruitPrice;

/**
 * 设价Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
public interface FruitPriceMapper 
{
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

    double selectJ(String code);

    Integer selectID(String code);

    Integer insertBCprice(double hxj, double lsj,String id);



}
