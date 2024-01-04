package com.ruoyi.guoran.doororder.service;

import com.ruoyi.guoran.domain.Doororder;

import java.util.List;

/**
 * 门店顶单Service接口
 * 
 * @author wmy
 * @date 2023-12-27
 */
public interface IDoororderService 
{
    /**
     * 查询门店顶单
     * 
     * @param oId 门店顶单主键
     * @return 门店顶单
     */
    public Doororder selectDoororderByOId(Long oId);

    /**
     * 查询门店顶单列表
     * 
     * @param doororder 门店顶单
     * @return 门店顶单集合
     */
    public List<Doororder> selectDoororderList(Doororder doororder);

    /**
     * 新增门店顶单
     * 
     * @param doororder 门店顶单
     * @return 结果
     */
    public int insertDoororder(Doororder doororder);

    /**
     * 修改门店顶单
     * 
     * @param doororder 门店顶单
     * @return 结果
     */
    public int updateDoororder(Doororder doororder);

    /**
     * 批量删除门店顶单
     * 
     * @param oIds 需要删除的门店顶单主键集合
     * @return 结果
     */
    public int deleteDoororderByOIds(String oIds);

    /**
     * 删除门店顶单信息
     * 
     * @param oId 门店顶单主键
     * @return 结果
     */
    public int deleteDoororderByOId(Long oId);
}
