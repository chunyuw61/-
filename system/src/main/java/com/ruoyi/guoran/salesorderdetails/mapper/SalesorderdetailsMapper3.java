package com.ruoyi.guoran.salesorderdetails.mapper;

import java.util.List;
import com.ruoyi.guoran.domain.Salesorderdetails;

/**
 * 门店退单Mapper接口
 * 
 * @author ruoyi
 * @date 2024-01-04
 */
public interface SalesorderdetailsMapper3
{
    /**
     * 查询门店退单
     * 
     * @param salesorderdetailsId 门店退单主键
     * @return 门店退单
     */
    public Salesorderdetails selectSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId);

    /**
     * 查询门店退单列表
     * 
     * @param salesorderdetails 门店退单
     * @return 门店退单集合
     */
    public List<Salesorderdetails> selectSalesorderdetailsList(Salesorderdetails salesorderdetails);

    /**
     * 新增门店退单
     * 
     * @param salesorderdetails 门店退单
     * @return 结果
     */
    public int insertSalesorderdetails(Salesorderdetails salesorderdetails);

    /**
     * 修改门店退单
     * 
     * @param salesorderdetails 门店退单
     * @return 结果
     */
    public int updateSalesorderdetails(Salesorderdetails salesorderdetails);

    /**
     * 删除门店退单
     * 
     * @param salesorderdetailsId 门店退单主键
     * @return 结果
     */
    public int deleteSalesorderdetailsBySalesorderdetailsId(Long salesorderdetailsId);

    /**
     * 批量删除门店退单
     * 
     * @param salesorderdetailsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSalesorderdetailsBySalesorderdetailsIds(String[] salesorderdetailsIds);
}
