package com.my.shop.shopmanagerweb.service;

import com.shop.common.pojo.EasyUITreeNode;
import com.shop.common.pojo.TaotaoResult;
import com.shop.pojo.TbItem;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "shop-manager-service")
public interface ItemService {
    @RequestMapping(value="/item/save")
    TaotaoResult addItem(@RequestBody TbItem item, @RequestParam("desc")String desc);
}
