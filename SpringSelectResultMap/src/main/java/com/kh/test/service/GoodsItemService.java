package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.GoodsItem;
import com.kh.test.mapper.GoodsItemMapper;

@Service
public class GoodsItemService {
	
	@Autowired
	private GoodsItemMapper goodsItemMapper;
	
	public boolean existsByName(String itemName) {
		// Integer로 맞춘 후 Integer을 boolean으로 변경해서 전달할 예정
		//Integer count = goodsItemMapper.existsByName(itemName); -> resultMap 사용하지 않는 방식
		GoodsItem count = goodsItemMapper.existsByName(itemName); //-> resultMap 사용 방식
		
		Integer totalCount = count != null ? count.getItemCount() : 0;
		//int totalCount = count != null ? count.getItemCount() : 0;
		// -> null이 아닐 때 false, null = 0
		
		return totalCount != null && totalCount > 0; //비교 연산자 결과 전달. return이 boolean의 역할을 하게 됨
		/* 
			Mapper에서는 Integer을 작성하고, service에서 반납할 때는 boolean을 사용하기 때문에 타입이 불일치 할 수 있음
			Mapper랑 Service 모두 Integer(int)로 작성하거나
			Mapper랑 Service 모두 boolean으로 작성하기
		*/
	}
}