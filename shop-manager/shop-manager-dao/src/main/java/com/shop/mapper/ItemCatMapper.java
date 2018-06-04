package com.shop.mapper;


import com.shop.pojo.TbItemCat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemCatMapper {
    List<TbItemCat> getItemCatList(@Param("parentId") Long parentId);
}
