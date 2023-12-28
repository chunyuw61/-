package com.ruoyi.orderforgoods.mapper;


import com.ruoyi.orderforgoods.domain.Fruittypes;

import java.util.List;

/**
 * 水果种类 水果的种类Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-26
 */
public interface FruittypesMapper
{
    /**
     * 查询水果种类 水果的种类
     *
     * @param fruittypesId 水果种类 水果的种类主键
     * @return 水果种类 水果的种类
     */
    public Fruittypes selectFruittypesByFruittypesId(Long fruittypesId);

    /**
     * 查询水果种类 水果的种类列表
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 水果种类 水果的种类集合
     */
    public List<Fruittypes> selectFruittypesList(Fruittypes fruittypes);

    /**
     * 新增水果种类 水果的种类
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 结果
     */
    public int insertFruittypes(Fruittypes fruittypes);

    /**
     * 修改水果种类 水果的种类
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 结果
     */
    public int updateFruittypes(Fruittypes fruittypes);

    /**
     * 删除水果种类 水果的种类
     *
     * @param fruittypesId 水果种类 水果的种类主键
     * @return 结果
     */
    public int deleteFruittypesByFruittypesId(Long fruittypesId);

    /**
     * 批量删除水果种类 水果的种类
     *
     * @param fruittypesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFruittypesByFruittypesIds(String[] fruittypesIds);

    List<Fruittypes> selectAllFruittypes();
}
