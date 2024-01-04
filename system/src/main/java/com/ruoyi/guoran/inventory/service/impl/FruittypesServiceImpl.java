package com.ruoyi.guoran.inventory.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.inventory.mapper.FruittypesMapper;
import com.ruoyi.guoran.domain.Fruittypes;
import com.ruoyi.guoran.inventory.service.IFruittypesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 水果的种类Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-12-25
 */
@Service
public class FruittypesServiceImpl implements IFruittypesService 
{
    @Autowired
    private FruittypesMapper fruittypesMapper;

    /**
     * 查询水果的种类
     * 
     * @param fruittypesId 水果的种类主键
     * @return 水果的种类
     */
    @Override
    public Fruittypes selectFruittypesByFruittypesId(Long fruittypesId)
    {
        return fruittypesMapper.selectFruittypesByFruittypesId(fruittypesId);
    }

    /**
     * 查询水果的种类列表
     * 
     * @param fruittypes 水果的种类
     * @return 水果的种类
     */
    @Override
    public List<Fruittypes> selectFruittypesList(Fruittypes fruittypes)
    {
        return fruittypesMapper.selectFruittypesList(fruittypes);
    }

    @Override
    public List<Fruittypes> selectFruitName() {
        return fruittypesMapper.selectFruitName();
    }

    /**
     * 新增水果的种类
     * 
     * @param fruittypes 水果的种类
     * @return 结果
     */
    @Override
    public int insertFruittypes(Fruittypes fruittypes)
    {
        return fruittypesMapper.insertFruittypes(fruittypes);
    }

    /**
     * 修改水果的种类
     * 
     * @param fruittypes 水果的种类
     * @return 结果
     */
    @Override
    public int updateFruittypes(Fruittypes fruittypes)
    {
        return fruittypesMapper.updateFruittypes(fruittypes);
    }

    /**
     * 批量删除水果的种类
     * 
     * @param fruittypesIds 需要删除的水果的种类主键
     * @return 结果
     */
    @Override
    public int deleteFruittypesByFruittypesIds(String fruittypesIds)
    {
        return fruittypesMapper.deleteFruittypesByFruittypesIds(Convert.toStrArray(fruittypesIds));
    }

    /**
     * 删除水果的种类信息
     * 
     * @param fruittypesId 水果的种类主键
     * @return 结果
     */
    @Override
    public int deleteFruittypesByFruittypesId(Long fruittypesId)
    {
        return fruittypesMapper.deleteFruittypesByFruittypesId(fruittypesId);
    }
}
