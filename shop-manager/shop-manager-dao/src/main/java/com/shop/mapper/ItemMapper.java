package com.shop.mapper;


import com.shop.pojo.TbItem;
import com.shop.pojo.TbItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    void insert(@Param("item")TbItem item);
}
