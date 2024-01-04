package com.ruoyi.guoran.total.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.total.mapper.AllTotalMapper;
import com.ruoyi.guoran.total.domain.AllTotal;
import com.ruoyi.guoran.total.service.IAllTotalService;
import com.ruoyi.common.core.text.Convert;

/**
 * 门店总销售额表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-29
 */
@Service
public class AllTotalServiceImpl implements IAllTotalService 
{
    @Autowired
    private AllTotalMapper allTotalMapper;

    /**
     * 查询门店总销售额表
     * 
     * @param id 门店总销售额表主键
     * @return 门店总销售额表
     */
    @Override
    public AllTotal selectAllTotalById(Long id)
    {
        return allTotalMapper.selectAllTotalById(id);
    }

    /**
     * 查询门店总销售额表列表
     * 
     * @param allTotal 门店总销售额表
     * @return 门店总销售额表
     */
    @Override
    public List<AllTotal> selectAllTotalList(AllTotal allTotal)
    {
        return allTotalMapper.selectAllTotalList(allTotal);
    }

    /**
     * 新增门店总销售额表
     * 
     * @param allTotal 门店总销售额表
     * @return 结果
     */
    @Override
    public int insertAllTotal(AllTotal allTotal)
    {
        return allTotalMapper.insertAllTotal(allTotal);
    }

    /**
     * 修改门店总销售额表
     * 
     * @param allTotal 门店总销售额表
     * @return 结果
     */
    @Override
    public int updateAllTotal(AllTotal allTotal)
    {
        return allTotalMapper.updateAllTotal(allTotal);
    }

    /**
     * 批量删除门店总销售额表
     * 
     * @param ids 需要删除的门店总销售额表主键
     * @return 结果
     */
    @Override
    public int deleteAllTotalByIds(String ids)
    {
        return allTotalMapper.deleteAllTotalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除门店总销售额表信息
     * 
     * @param id 门店总销售额表主键
     * @return 结果
     */
    @Override
    public int deleteAllTotalById(Long id)
    {
        return allTotalMapper.deleteAllTotalById(id);
    }

    @Override
    public List<AllTotal> countAll() {
        List<AllTotal> strings = allTotalMapper.countAll();
        return strings;
    }
}
