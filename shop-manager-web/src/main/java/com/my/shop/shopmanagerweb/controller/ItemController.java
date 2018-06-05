package com.my.shop.shopmanagerweb.controller;

import com.my.shop.shopmanagerweb.service.ItemService;
import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/item/save")
    public TaotaoResult addItem(@RequestParam("item")TbItem item, @RequestParam("desc")String desc) {
        TaotaoResult result = itemService.addItem(item, desc);
        return result;
    }
}
