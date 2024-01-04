package com.ruoyi.guoran.inventory.mapper;

import java.util.List;
import com.ruoyi.guoran.domain.Fruittypes;
import org.apache.ibatis.annotations.Mapper;

/**
 * 水果的种类Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-25
 */

@Mapper
public interface FruittypesMapper 
{
    /**
     * 查询水果的种类
     * 
     * @param fruittypesId 水果的种类主键
     * @return 水果的种类
     */
    public Fruittypes selectFruittypesByFruittypesId(Long fruittypesId);

    /**
     * 查询水果的种类列表
     * 
     * @param fruittypes 水果的种类
     * @return 水果的种类集合
     */
    public List<Fruittypes> selectFruittypesList(Fruittypes fruittypes);

    /**
     * 查询所有的水果种类 状态正常
     */
    public  List<Fruittypes> selectFruitName();

    /**
     * 新增水果的种类
     * 
     * @param fruittypes 水果的种类
     * @return 结果
     */
    public int insertFruittypes(Fruittypes fruittypes);

    /**
     * 修改水果的种类
     * 
     * @param fruittypes 水果的种类
     * @return 结果
     */
    public int updateFruittypes(Fruittypes fruittypes);

    /**
     * 删除水果的种类
     * 
     * @param fruittypesId 水果的种类主键
     * @return 结果
     */
    public int deleteFruittypesByFruittypesId(Long fruittypesId);

    /**
     * 批量删除水果的种类
     * 
     * @param fruittypesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFruittypesByFruittypesIds(String[] fruittypesIds);
}
