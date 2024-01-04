package com.ruoyi.guoran.reportinglosses.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.guoran.reportinglosses.mapper.ReportingLossesMapper;
import com.ruoyi.guoran.reportinglosses.domain.ReportingLosses;
import com.ruoyi.guoran.reportinglosses.service.IReportingLossesService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报损信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
@Service
public class ReportingLossesServiceImpl implements IReportingLossesService 
{
    @Autowired
    private ReportingLossesMapper reportingLossesMapper;

    /**
     * 查询报损信息
     * 
     * @param rId 报损信息主键
     * @return 报损信息
     */
    @Override
    public ReportingLosses selectReportingLossesByRId(Long rId)
    {
        return reportingLossesMapper.selectReportingLossesByRId(rId);
    }

    /**
     * 查询报损信息列表
     * 
     * @param reportingLosses 报损信息
     * @return 报损信息
     */
    @Override
    public List<ReportingLosses> selectReportingLossesList(ReportingLosses reportingLosses)
    {
        return reportingLossesMapper.selectReportingLossesList(reportingLosses);
    }

    /**
     * 新增报损信息
     * 
     * @param reportingLosses 报损信息
     * @return 结果
     */
    @Override
    public int insertReportingLosses(ReportingLosses reportingLosses)
    {
        return reportingLossesMapper.insertReportingLosses(reportingLosses);
    }

    /**
     * 修改报损信息
     * 
     * @param reportingLosses 报损信息
     * @return 结果
     */
    @Override
    public int updateReportingLosses(ReportingLosses reportingLosses)
    {
        return reportingLossesMapper.updateReportingLosses(reportingLosses);
    }

    /**
     * 批量删除报损信息
     * 
     * @param rIds 需要删除的报损信息主键
     * @return 结果
     */
    @Override
    public int deleteReportingLossesByRIds(String rIds)
    {
        return reportingLossesMapper.deleteReportingLossesByRIds(Convert.toStrArray(rIds));
    }

    /**
     * 删除报损信息信息
     * 
     * @param rId 报损信息主键
     * @return 结果
     */
    @Override
    public int deleteReportingLossesByRId(Long rId)
    {
        return reportingLossesMapper.deleteReportingLossesByRId(rId);
    }
}
