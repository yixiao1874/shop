package com.my.shop.shopmanagerservice.controller;

import com.my.shop.shopmanagerservice.service.ItemService;
import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/item/save")
    public TaotaoResult addItem(@RequestBody TbItem item, @RequestParam("desc")String desc) {
        TaotaoResult result = itemService.addItem(item, desc);
        return result;
    }
}
