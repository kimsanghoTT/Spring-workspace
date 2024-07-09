package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItems;
import com.kh.test.mapper.GoodsItemsMapper;

@Service
public class GoodsItemsService {

	@Autowired
	private GoodsItemsMapper goodsItemsMapper;
	
	public boolean countByName(String itemName) {
		GoodsItems count = goodsItemsMapper.countByName(itemName);
		
		Integer totalCount = count != null ? count.getItemCount() : 0;
		return totalCount != null && totalCount > 0;
	}
}
