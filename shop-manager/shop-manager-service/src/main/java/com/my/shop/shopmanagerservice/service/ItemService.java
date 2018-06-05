package com.my.shop.shopmanagerservice.service;

import com.shop.common.pojo.TaotaoResult;
import com.shop.common.utils.IDUtils;
import com.shop.mapper.ItemCatMapper;
import com.shop.mapper.ItemDescMapper;
import com.shop.mapper.ItemMapper;
import com.shop.pojo.TbItem;
import com.shop.pojo.TbItemDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Service
public class ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ItemDescMapper itemDescMapper;

    public TaotaoResult addItem(@RequestParam("item")TbItem item, @RequestParam("desc")String desc) {
        //生成商品id
        final long itemId = IDUtils.genItemId();
        //补全item的属性
        item.setId(itemId);
        //商品状态，1-正常，2-下架，3-删除
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());
        //向商品表插入数据
        itemMapper.insert(item);
        //创建一个商品描述表对应的pojo
        TbItemDesc itemDesc = new TbItemDesc();
        //补全pojo的属性
        itemDesc.setItemId(itemId);
        itemDesc.setItemDesc(desc);
        itemDesc.setUpdated(new Date());
        itemDesc.setCreated(new Date());
        //向商品描述表插入数据
        itemDescMapper.insert(itemDesc);
        //返回结果
        return TaotaoResult.ok();
    }
}
