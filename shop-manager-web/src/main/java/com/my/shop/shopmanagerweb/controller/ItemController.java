package com.my.shop.shopmanagerweb.controller;

import com.my.shop.shopmanagerweb.service.ItemService;
import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/item/save")
    public TaotaoResult addItem(TbItem item, String desc) {
        TaotaoResult result = itemService.addItem(item, desc);
        return result;
    }
}
