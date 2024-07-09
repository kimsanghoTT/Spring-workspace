package com.kh.test.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {

	@Autowired
	private GoodsItemMapper goodsItemMapper;
	
	public boolean existByName(String itemName) {
		//Integer로 맞춘 후 Integer를 boolean으로 변경해서 전달
		Integer count = goodsItemMapper.existByName(itemName);
		return count != null && count == 0; //true라고 전달, return이 boolean 역할을 하게 됨
		
		//return goodsItemMapper.existByName(itemName);
		//Mapper에서는 Integer를 쓰고 Service에서는 boolean을 사용하므로 타입 불일치가 발생할 수 있음
		//둘 다 타입을 동일하게 해야함
	}
}
