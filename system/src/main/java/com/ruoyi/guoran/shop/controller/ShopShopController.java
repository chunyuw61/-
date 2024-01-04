package com.ruoyi.shop.controller;

import java.util.List;

import com.ruoyi.guoran.domain.Shop;
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
import com.ruoyi.shop.service.ShopIShopService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 门店信息Controller
 *
 * @author zgf
 * @date 2023-12-26
 */
@Controller
@RequestMapping("/shop/shop")
public class ShopShopController extends BaseController {
    private String prefix = "shop/shop";

    @Autowired
    private ShopIShopService shopService;

    @RequiresPermissions("shop:shop:view")
    @GetMapping()
    public String shop() {
        return prefix + "/shop";
    }

    /**
     * 查询门店信息列表
     */
    @RequiresPermissions("shop:shop:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Shop shop) {
        startPage();
        List<Shop> list = shopService.selectShopList(shop);
        return getDataTable(list);
    }

    /**
     * 导出门店信息列表
     */
    @RequiresPermissions("shop:shop:export")
    @Log(title = "门店信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Shop shop) {
        List<Shop> list = shopService.selectShopList(shop);
        ExcelUtil<Shop> util = new ExcelUtil<Shop>(Shop.class);
        return util.exportExcel(list, "门店信息数据");
    }

    /**
     * 新增门店信息
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存门店信息
     */
    @RequiresPermissions("shop:shop:add")
    @Log(title = "门店信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Shop shop) {
        return toAjax(shopService.insertShop(shop));
    }

    /**
     * 修改门店信息
     */
    @RequiresPermissions("shop:shop:edit")
    @GetMapping("/edit/{sId}")
    public String edit(@PathVariable("sId") Long sId, ModelMap mmap) {
        Shop shop = shopService.selectShopBySId(sId);
        mmap.put("shop", shop);
        return prefix + "/edit";
    }

    /**
     * 修改保存门店信息
     */
    @RequiresPermissions("shop:shop:edit")
    @Log(title = "门店信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Shop shop) {
        return toAjax(shopService.updateShop(shop));
    }

    /**
     * 删除门店信息
     */
    @RequiresPermissions("shop:shop:remove")
    @Log(title = "门店信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(shopService.deleteShopBySIds(ids));
    }

    @GetMapping("/ren")
    @ResponseBody
    public List<String> ren() {

        List<String> selectname = shopService.selectname();
        System.out.println(selectname);
        return selectname;
    }

    @GetMapping("/a")
    @ResponseBody
    public String selectShopBySId(String name) {
        System.out.println(name);
        String s = shopService.selectname1(name);
        System.out.println(s);

        return s;
    }
}
