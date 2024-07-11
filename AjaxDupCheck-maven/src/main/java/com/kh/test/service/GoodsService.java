package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.mapper.GoodsMapper;

@Service
public class GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	public boolean getGoodsName(String item_name) {
		return (goodsMapper.getGoodsName(item_name) >= 1 ? true : false);
	}
}