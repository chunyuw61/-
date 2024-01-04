package com.ruoyi.guoran.storeOperations.purchaseorderdetails.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.ruoyi.guoran.domain.Returnorderdetails;
import com.ruoyi.guoran.storeOperations.returnorderdetails.mapper.ReturnorderdetailsMapper1;
import com.ruoyi.guoran.domain.Warehousestock;
import com.ruoyi.guoran.storeOperations.purchaseorderdetails.mapper.PurchaseorderdetailsMapper1;

import com.ruoyi.guoran.storeOperations.warehousestock.mapper.WarehousestockMapper1;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.guoran.domain.Purchaseorderdetails;
import com.ruoyi.guoran.storeOperations.purchaseorderdetails.service.IPurchaseorderdetailsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进货单明细Controller
 * 
 * @author 24k纯帅
 * @date 2023-12-26
 */
@Controller
@RequestMapping("/purchaseorderdetails/purchaseorderdetails")
public class PurchaseorderdetailsController1 extends BaseController {



    @Autowired
    private PurchaseorderdetailsMapper1 purchaseorderdetailsMapper1;

    @Autowired
    private ReturnorderdetailsMapper1 returnorderdetailsMapper1;

    @Autowired
    private WarehousestockMapper1 warehousingMapper;


    private String prefix = "purchaseorderdetails/purchaseorderdetails";

    @Autowired
    private IPurchaseorderdetailsService purchaseorderdetailsService;

    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:view")
    @GetMapping()
    public String purchaseorderdetails() {
        return prefix + "/purchaseorderdetails";
    }

    /**
     * 查询进货单明细列表
     */
    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Purchaseorderdetails purchaseorderdetails) {
        startPage();
        List<Purchaseorderdetails> list = purchaseorderdetailsService.selectPurchaseorderdetailsList(purchaseorderdetails);
            /*for(int i=1;i<=list.size();i++){
                if(list.get(i-1).getIsStatus() == 2   ){
                    warehousingMapper.insertWarehousing(new Warehousing(
                            null,
                            list.get(i-1).getsId(),
                            list.get(i-1).getpId(),
                            "163719",
                            list.get(i-1).getFruittypesId(),
                            list.get(i-1).getFruitId(),
                            list.get(i-1).getFruitName(),
                            list.get(i-1).getNumber(),
                            list.get(i-1).getpNumber(),
                            list.get(i-1).getPrice(),
                            list.get(i-1).getUpdatedTime()
                    ));
                }
            }*/


        return getDataTable(list);
    }

    /**
     * 导出进货单明细列表
     */
    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:export")
    @Log(title = "进货单明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Purchaseorderdetails purchaseorderdetails) {
        List<Purchaseorderdetails> list = purchaseorderdetailsService.selectPurchaseorderdetailsList(purchaseorderdetails);
        ExcelUtil<Purchaseorderdetails> util = new ExcelUtil<Purchaseorderdetails>(Purchaseorderdetails.class);
        return util.exportExcel(list, "进货单明细数据");
    }

    /**
     * 新增进货单明细
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存进货单明细
     */
    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:add")
    @Log(title = "进货单明细", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Purchaseorderdetails purchaseorderdetails) {
        return toAjax(purchaseorderdetailsService.insertPurchaseorderdetails(purchaseorderdetails));
    }

    /**
     * 修改进货单明细
     */
    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:edit")
    @GetMapping("/edit/{pId}")
    public String edit(@PathVariable("pId") Long pId, ModelMap mmap) {
        Purchaseorderdetails purchaseorderdetails = purchaseorderdetailsService.selectPurchaseorderdetailsByPId(pId);
        mmap.put("purchaseorderdetails", purchaseorderdetails);
        return prefix + "/edit";
    }

    /**
     * 修改保存进货单明细
     */
    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:edit")
    @Log(title = "进货单明细", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Purchaseorderdetails purchaseorderdetails) {
        return toAjax(purchaseorderdetailsService.updatePurchaseorderdetails(purchaseorderdetails));
    }

    /**
     * 删除进货单明细
     */
    @RequiresPermissions("purchaseorderdetails:purchaseorderdetails:remove")
    @Log(title = "进货单明细", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(purchaseorderdetailsService.deletePurchaseorderdetailsByPIds(ids));
    }

    @PostMapping("/confirm")
    @ResponseBody
    public int confirm(Long pId) {
        System.out.println(pId);
        Purchaseorderdetails purchaseorderdetails = purchaseorderdetailsMapper1.selectPurchaseorderdetailsByPId(pId);
        Warehousestock warehousestock = warehousingMapper.selectWarehousestockByFruitId(purchaseorderdetails.getFruitId());

//        int i1 = warehousingMapper.updateWarehousestock(new Warehousestock(
//                null,
//                warehousestock.getwId(),
//                warehousestock.getImg(),
//                warehousestock.getFruitId(),
//                warehousestock.getFruittypesId(),
//                warehousestock.getFruitName(),
//                warehousestock.getJinjia(),
//                warehousestock.getWhCount() - purchaseorderdetails.getNumber()
//        ));

//        System.out.println("======================="+i1);

        int i = purchaseorderdetailsMapper1.updateStatus(pId);
        System.out.println(purchaseorderdetails);
        if(i>0){
            return 1;
        }
        return 0;
    }

    @PostMapping("/back")
    @ResponseBody
    public boolean back(Long pId , Double returnNum) {


        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        String dateStr = sdf.format(new Date());

        // 生成四位随机数
        Random random = new Random();
        int rannum = (int) (random.nextDouble() * (9999 - 1000 + 1)) + 1000;

        // 拼接成订单编号
        String orderNumber =  dateStr;

        Purchaseorderdetails purchaseorderdetails = purchaseorderdetailsMapper1.selectPurchaseorderdetailsByPId(pId);

        System.out.println(purchaseorderdetails);

        String pNumberStr = purchaseorderdetails.getpNumber();
        System.out.println("------------------------------"+pNumberStr);
        Long pNumber = Long.parseLong(pNumberStr);

        int i = returnorderdetailsMapper1.insertReturnorderdetails(new Returnorderdetails(
                null,
                purchaseorderdetails.getsId(),
                pNumber,
                orderNumber,
                purchaseorderdetails.getFruittypesId(),
                purchaseorderdetails.getFruitId(),
                returnNum
        ));
        return i>0 ? true:false;
    }

}