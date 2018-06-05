package com.shop.mapper;


import com.shop.pojo.TbItemCat;
import com.shop.pojo.TbItemDesc;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemDescMapper {
    void insert(@Param("itemDesc")TbItemDesc itemDesc);
}
