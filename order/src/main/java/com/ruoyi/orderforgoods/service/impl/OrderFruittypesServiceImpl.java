package com.ruoyi.orderforgoods.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.orderforgoods.domain.OrderFruittypes;
import com.ruoyi.orderforgoods.mapper.OrderFruittypesMapper;
import com.ruoyi.orderforgoods.service.OrderIFruittypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 水果种类 水果的种类Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-26
 */
@Service
public class OrderFruittypesServiceImpl implements OrderIFruittypesService
{
    @Autowired
    private OrderFruittypesMapper fruittypesMapper;

    /**
     * 查询水果种类 水果的种类
     *
     * @param fruittypesId 水果种类 水果的种类主键
     * @return 水果种类 水果的种类
     */
    @Override
    public OrderFruittypes selectFruittypesByFruittypesId(Long fruittypesId)
    {
        return fruittypesMapper.selectFruittypesByFruittypesId(fruittypesId);
    }

    /**
     * 查询水果种类 水果的种类列表
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 水果种类 水果的种类
     */
    @Override
    public List<OrderFruittypes> selectFruittypesList(OrderFruittypes fruittypes)
    {
        return fruittypesMapper.selectFruittypesList(fruittypes);
    }

    /**
     * 新增水果种类 水果的种类
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 结果
     */
    @Override
    public int insertFruittypes(OrderFruittypes fruittypes)
    {
        return fruittypesMapper.insertFruittypes(fruittypes);
    }

    /**
     * 修改水果种类 水果的种类
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 结果
     */
    @Override
    public int updateFruittypes(OrderFruittypes fruittypes)
    {
        return fruittypesMapper.updateFruittypes(fruittypes);
    }

    /**
     * 批量删除水果种类 水果的种类
     *
     * @param fruittypesIds 需要删除的水果种类 水果的种类主键
     * @return 结果
     */
    @Override
    public int deleteFruittypesByFruittypesIds(String fruittypesIds)
    {
        return fruittypesMapper.deleteFruittypesByFruittypesIds(Convert.toStrArray(fruittypesIds));
    }

    /**
     * 删除水果种类 水果的种类信息
     *
     * @param fruittypesId 水果种类 水果的种类主键
     * @return 结果
     */
    @Override
    public int deleteFruittypesByFruittypesId(Long fruittypesId)
    {
        return fruittypesMapper.deleteFruittypesByFruittypesId(fruittypesId);
    }



    @Override
    public List<OrderFruittypes> selectAllFruittypes() {
        return fruittypesMapper.selectAllFruittypes();
    }
}
