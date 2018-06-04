package com.my.shop.shopmanagerweb.service;

import com.shop.common.pojo.EasyUITreeNode;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "shop-manager-service")
public interface ItemCatService {
    @RequestMapping(value = "/item/cat/list")
    List<EasyUITreeNode> getItemCatList(@RequestParam(name="id", defaultValue="0")Long parentId);
}
