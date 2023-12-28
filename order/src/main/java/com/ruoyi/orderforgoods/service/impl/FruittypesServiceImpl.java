package com.ruoyi.orderforgoods.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.orderforgoods.domain.Fruittypes;
import com.ruoyi.orderforgoods.mapper.FruittypesMapper;
import com.ruoyi.orderforgoods.service.IFruittypesService;
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
public class FruittypesServiceImpl implements IFruittypesService
{
    @Autowired
    private FruittypesMapper fruittypesMapper;

    /**
     * 查询水果种类 水果的种类
     *
     * @param fruittypesId 水果种类 水果的种类主键
     * @return 水果种类 水果的种类
     */
    @Override
    public Fruittypes selectFruittypesByFruittypesId(Long fruittypesId)
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
    public List<Fruittypes> selectFruittypesList(Fruittypes fruittypes)
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
    public int insertFruittypes(Fruittypes fruittypes)
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
    public int updateFruittypes(Fruittypes fruittypes)
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
    public List<Fruittypes> selectAllFruittypes() {
        return fruittypesMapper.selectAllFruittypes();
    }
}
