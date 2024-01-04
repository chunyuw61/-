package com.ruoyi.guoran.total.mapper;

import java.util.List;
import com.ruoyi.guoran.total.domain.AllTotal;

/**
 * 门店总销售额表Mapper接口
 * 
 * @author ruoyi
 * @date 2023-12-29
 */
public interface AllTotalMapper 
{
    /**
     * 查询门店总销售额表
     * 
     * @param id 门店总销售额表主键
     * @return 门店总销售额表
     */
    public AllTotal selectAllTotalById(Long id);

    /**
     * 查询门店总销售额表列表
     * 
     * @param allTotal 门店总销售额表
     * @return 门店总销售额表集合
     */
    public List<AllTotal> selectAllTotalList(AllTotal allTotal);

    /**
     * 新增门店总销售额表
     * 
     * @param allTotal 门店总销售额表
     * @return 结果
     */
    public int insertAllTotal(AllTotal allTotal);

    /**
     * 修改门店总销售额表
     * 
     * @param allTotal 门店总销售额表
     * @return 结果
     */
    public int updateAllTotal(AllTotal allTotal);

    /**
     * 删除门店总销售额表
     * 
     * @param id 门店总销售额表主键
     * @return 结果
     */
    public int deleteAllTotalById(Long id);

    /**
     * 批量删除门店总销售额表
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAllTotalByIds(String[] ids);


    public List<AllTotal> countAll();

}
