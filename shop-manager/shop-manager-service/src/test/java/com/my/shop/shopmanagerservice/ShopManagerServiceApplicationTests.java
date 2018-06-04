package com.my.shop.shopmanagerservice;

import com.shop.mapper.ItemCatMapper;
import com.shop.pojo.TbItemCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopManagerServiceApplicationTests {

	@Autowired
	private ItemCatMapper itemCatMapper;

	@Test
	public void contextLoads() {
		List<TbItemCat> list = itemCatMapper.getItemCatList(0L);
		for (TbItemCat tbItemCat : list){
			System.out.println(tbItemCat.getName());
		}
	}

}
