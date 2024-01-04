package com.ruoyi.price.controller;

import java.util.List;
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
import com.ruoyi.price.domain.FruitPrice;
import com.ruoyi.price.service.IFruitPriceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 设价Controller
 *
 * @author ruoyi
 * @date 2023-12-25
 */
@Controller
@RequestMapping("/price/price")
public class FruitPriceController extends BaseController {
    private String prefix = "price/price";

    @Autowired
    private IFruitPriceService fruitPriceService;

    @RequiresPermissions("price:price:view")
    @GetMapping()
    public String price() {
        return prefix + "/price";
    }

    /**
     * 查询设价列表
     */
    @RequiresPermissions("price:price:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FruitPrice fruitPrice) {
        startPage();

        List<FruitPrice> fruitPrices = fruitPriceService.selectFruitPriceList(fruitPrice);

        System.out.println(fruitPrices);

        return getDataTable(fruitPrices);
    }

    /**
     * 导出设价列表
     */
    @RequiresPermissions("price:price:export")
    @Log(title = "设价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FruitPrice fruitPrice) {
        List<FruitPrice> list = fruitPriceService.selectFruitPriceList(fruitPrice);

        ExcelUtil<FruitPrice> util = new ExcelUtil<FruitPrice>(FruitPrice.class);


        return util.exportExcel(list, "设价数据");
    }

    /**
     * 新增设价
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存设价
     */
    @RequiresPermissions("price:price:add")
    @Log(title = "设价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FruitPrice fruitPrice) {
        return toAjax(fruitPriceService.insertFruitPrice(fruitPrice));

    }

    /**
     * 修改设价
     */
    @RequiresPermissions("price:price:edit")
    @GetMapping("/edit/{pId}")
    public String edit(@PathVariable("pId") Long pId, ModelMap mmap) {
        FruitPrice fruitPrice = fruitPriceService.selectFruitPriceByPId(pId);
        mmap.put("fruitPrice", fruitPrice);
        return prefix + "/edit";
    }

    /**
     * 修改保存设价
     */
    @RequiresPermissions("price:price:edit")
    @Log(title = "设价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FruitPrice fruitPrice) {
        return toAjax(fruitPriceService.updateFruitPrice(fruitPrice));
    }

    /**
     * 删除设价
     */
    @RequiresPermissions("price:price:remove")
    @Log(title = "设价", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(fruitPriceService.deleteFruitPriceByPIds(ids));
    }

    @GetMapping("/selectJ")
    @ResponseBody
    public double selectJ(String code) {
        System.out.println(code);



        double v = fruitPriceService.selectJ(code);
        System.out.println(v);
        return v;
    }

    @PostMapping("/insertBCprice")
    @ResponseBody
    public Integer insertBCprice(double hxj, double lsj ,String code) {


        Integer i = fruitPriceService.insertBCprice(hxj, lsj,code);


        return i;
    }
}
