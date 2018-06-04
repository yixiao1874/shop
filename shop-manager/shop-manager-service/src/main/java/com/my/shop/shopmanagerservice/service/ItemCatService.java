package com.my.shop.shopmanagerservice.service;

import com.shop.common.pojo.EasyUITreeNode;
import com.shop.mapper.ItemCatMapper;
import com.shop.pojo.TbItemCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatService {
    @Autowired
    private ItemCatMapper itemCatMapper;

    public List<EasyUITreeNode> getItemCatList(Long parentId) {
        List<TbItemCat> list = itemCatMapper.getItemCatList(parentId);
        //将List<TbItemCat>转为List<EasyUITreeNode>
        List<EasyUITreeNode> resultList = new ArrayList<>();
        for (TbItemCat tbItemCat : list) {
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(tbItemCat.getId());
            node.setText(tbItemCat.getName());
            //如果节点下有子节点“closed”，如果没有子节点“open”
            node.setState(tbItemCat.getIsParent()?"closed":"open");
            //添加到节点列表
            resultList.add(node);
        }
        return resultList;
    }
}
