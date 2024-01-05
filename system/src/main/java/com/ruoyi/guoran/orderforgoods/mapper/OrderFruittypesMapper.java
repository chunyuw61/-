package com.ruoyi.guoran.orderforgoods.mapper;



import com.ruoyi.guoran.orderforgoods.domain.OrderFruittypes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 水果种类 水果的种类Mapper接口
 *
 * @author ruoyi
 * @date 2023-12-26
 */
@Mapper
public interface OrderFruittypesMapper
{
    /**
     * 查询水果种类 水果的种类
     *
     * @param fruittypesId 水果种类 水果的种类主键
     * @return 水果种类 水果的种类
     */
    public OrderFruittypes selectFruittypesByFruittypesId(Long fruittypesId);

    /**
     * 查询水果种类 水果的种类列表
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 水果种类 水果的种类集合
     */
    public List<OrderFruittypes> selectFruittypesList(OrderFruittypes fruittypes);

    /**
     * 新增水果种类 水果的种类
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 结果
     */
    public int insertFruittypes(OrderFruittypes fruittypes);

    /**
     * 修改水果种类 水果的种类
     *
     * @param fruittypes 水果种类 水果的种类
     * @return 结果
     */
    public int updateFruittypes(OrderFruittypes fruittypes);

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

    List<OrderFruittypes> selectAllFruittypes();
}
