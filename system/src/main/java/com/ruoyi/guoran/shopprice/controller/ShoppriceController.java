package com.ruoyi.shopprice.controller;

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
import com.ruoyi.shopprice.domain.Shopprice;
import com.ruoyi.shopprice.service.IShoppriceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门店价格Controller
 *
 * @author ruoyi
 * @date 2023-12-29
 */
@Controller
@RequestMapping("/shopprice/shopprice")
public class ShoppriceController extends BaseController {
    private String prefix = "shopprice/shopprice";

    @Autowired
    private IShoppriceService shoppriceService;

    @RequiresPermissions("shopprice:shopprice:view")
    @GetMapping()
    public String shopprice() {
        return prefix + "/shopprice";
    }

    /**
     * 查询门店价格列表
     */
    @RequiresPermissions("shopprice:shopprice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Shopprice shopprice) {

        startPage();

        List<Shopprice> list = shoppriceService.selectShoppriceList(shopprice);
        return getDataTable(list);
    }

    /**
     * 导出门店价格列表
     */
    @RequiresPermissions("shopprice:shopprice:export")
    @Log(title = "门店价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shopprice shopprice) {
        List<Shopprice> list = shoppriceService.selectShoppriceList(shopprice);
        ExcelUtil<Shopprice> util = new ExcelUtil<Shopprice>(Shopprice.class);
        return util.exportExcel(list, "门店价格数据");
    }

    /**
     * 新增门店价格
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存门店价格
     */
    @RequiresPermissions("shopprice:shopprice:add")
    @Log(title = "门店价格", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Shopprice shopprice) {
        return toAjax(shoppriceService.insertShopprice(shopprice));
    }

    /**
     * 修改门店价格
     */
    @RequiresPermissions("shopprice:shopprice:edit")
    @GetMapping("/edit/{shoppriceId}")
    public String edit(@PathVariable("shoppriceId") Long shoppriceId, ModelMap mmap) {
        Shopprice shopprice = shoppriceService.selectShoppriceByShoppriceId(shoppriceId);
        mmap.put("shopprice", shopprice);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店价格
     */
    @RequiresPermissions("shopprice:shopprice:edit")
    @Log(title = "门店价格", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Shopprice shopprice) {
        return toAjax(shoppriceService.updateShopprice(shopprice));
    }

    /**
     * 删除门店价格
     */
    @RequiresPermissions("shopprice:shopprice:remove")
    @Log(title = "门店价格", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shoppriceService.deleteShoppriceByShoppriceIds(ids));
    }

    @PostMapping("/updateprice")
    @ResponseBody
    public Integer updateprice(double lsj, double zk, String fruitcode) {
        Integer updateprice = shoppriceService.updateprice(lsj, zk, fruitcode);
        return updateprice;
    }

}
