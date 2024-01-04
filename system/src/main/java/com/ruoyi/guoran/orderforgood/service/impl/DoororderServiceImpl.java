package com.ruoyi.guoran.orderforgood.service.impl;


import com.ruoyi.common.core.text.Convert;
import com.ruoyi.guoran.domain.Doororder;
import com.ruoyi.guoran.orderforgood.mapper.DoororderMapper;
import com.ruoyi.guoran.orderforgood.service.IDoororderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 门店顶单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-26
 */
@Service
public class DoororderServiceImpl implements IDoororderService
{
    @Autowired
    private DoororderMapper doororderMapper;

    /**
     * 查询门店顶单
     * 
     * @param oId 门店顶单主键
     * @return 门店顶单
     */
    @Override
    public Doororder selectDoororderByOId(Long oId)
    {
        return doororderMapper.selectDoororderByOId(oId);
    }

    /**
     * 查询门店顶单列表
     * 
     * @param doororder 门店顶单
     * @return 门店顶单
     */
    @Override
    public List<Doororder> selectDoororderList(Doororder doororder)
    {
        return doororderMapper.selectDoororderList(doororder);
    }

    /**
     * 新增门店顶单
     * 
     * @param doororder 门店顶单
     * @return 结果
     */
    @Override
    public int insertDoororder(Doororder doororder)
    {
        return doororderMapper.insertDoororder(doororder);
    }

    /**
     * 修改门店顶单
     * 
     * @param doororder 门店顶单
     * @return 结果
     */
    @Override
    public int updateDoororder(Doororder doororder)
    {
        return doororderMapper.updateDoororder(doororder);
    }

    /**
     * 批量删除门店顶单
     * 
     * @param oIds 需要删除的门店顶单主键
     * @return 结果
     */
    @Override
    public int deleteDoororderByOIds(String oIds)
    {
        return doororderMapper.deleteDoororderByOIds(Convert.toStrArray(oIds));
    }

    /**
     * 删除门店顶单信息
     * 
     * @param oId 门店顶单主键
     * @return 结果
     */
    @Override
    public int deleteDoororderByOId(Long oId)
    {
        return doororderMapper.deleteDoororderByOId(oId);
    }
}
