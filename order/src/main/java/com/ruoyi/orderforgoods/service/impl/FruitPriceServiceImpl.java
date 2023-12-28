package com.ruoyi.orderforgoods.service.impl;

/**
 * @author chuyu
 * @version 1.0
 * @description: TODO
 * @contact m18403553359@163.com
 * @date 2023/12/26 15:21
 */


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.orderforgoods.domain.FruitPrice;
import com.ruoyi.orderforgoods.mapper.FruitPriceMapper;
import com.ruoyi.orderforgoods.service.IFruitPriceService;
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
public class FruitPriceServiceImpl implements IFruitPriceService {
    @Autowired
    private FruitPriceMapper fruitPriceMapper;

    /**
     * 查询设价
     *
     * @param pId 设价主键
     * @return 设价
     */
    @Override
    public FruitPrice selectFruitPriceByPId(Long pId) {
        return fruitPriceMapper.selectFruitPriceByPId(pId);
    }

    /**
     * 查询设价列表
     *
     * @param fruitPrice 设价
     * @return 设价
     */
    @Override
    public List<FruitPrice> selectFruitPriceList(FruitPrice fruitPrice) {
        return fruitPriceMapper.selectFruitPriceList(fruitPrice);
    }

    /**
     * 新增设价
     *
     * @param fruitPrice 设价
     * @return 结果
     */
    @Override
    public int insertFruitPrice(FruitPrice fruitPrice) {
        return fruitPriceMapper.insertFruitPrice(fruitPrice);
    }

    /**
     * 修改设价
     *
     * @param fruitPrice 设价
     * @return 结果
     */
    @Override
    public int updateFruitPrice(FruitPrice fruitPrice) {
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

