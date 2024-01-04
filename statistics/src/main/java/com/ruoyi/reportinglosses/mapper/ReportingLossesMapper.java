package com.ruoyi.reportinglosses.mapper;

import java.util.List;
import com.ruoyi.reportinglosses.domain.ReportingLosses;

/**
 * 报损信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
public interface ReportingLossesMapper 
{
    /**
     * 查询报损信息
     * 
     * @param rId 报损信息主键
     * @return 报损信息
     */
    public ReportingLosses selectReportingLossesByRId(Long rId);

    /**
     * 查询报损信息列表
     * 
     * @param reportingLosses 报损信息
     * @return 报损信息集合
     */
    public List<ReportingLosses> selectReportingLossesList(ReportingLosses reportingLosses);

    /**
     * 新增报损信息
     * 
     * @param reportingLosses 报损信息
     * @return 结果
     */
    public int insertReportingLosses(ReportingLosses reportingLosses);

    /**
     * 修改报损信息
     * 
     * @param reportingLosses 报损信息
     * @return 结果
     */
    public int updateReportingLosses(ReportingLosses reportingLosses);

    /**
     * 删除报损信息
     * 
     * @param rId 报损信息主键
     * @return 结果
     */
    public int deleteReportingLossesByRId(Long rId);

    /**
     * 批量删除报损信息
     * 
     * @param rIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReportingLossesByRIds(String[] rIds);
}
