package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.serivce.GoodsItemService;


@Controller
public class GoodsItemController {

	@Autowired
	private GoodsItemService goodsItemService;
	
	@GetMapping("/goodtiem/check")
	@ResponseBody
	public Map<String, Object> existByName(@RequestParam String name){
		//상품명이 조회가 된다면 이미 존재하는 상품명입니다 만들기
		boolean isCheck = goodsItemService.existByName(name);
		Map<String, Object> res = new HashMap<>();
		
		//ajax는 html을 return하지 않음
		//html 파일을 불러오는 것이 아니라 html 파일의 일부분만 설정하는 것이기 때문
		res.put("isCheck", isCheck);
		
		return res; //Map으로 전달된 key value를 다시 html파일의 중복체크에 전달
	}
}
