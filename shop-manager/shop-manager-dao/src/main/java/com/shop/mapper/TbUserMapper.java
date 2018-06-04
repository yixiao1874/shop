package com.shop.mapper;

import com.shop.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface TbUserMapper {
    User getUserByName(@Param("username") String username);
}
