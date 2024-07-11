package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsService;

@RestController
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/checkName")
	public Map<String, Object> getGoodsName(@RequestParam("item_name") String item_name){
		Map<String, Object> res = new HashMap<>();
		boolean isCheck = goodsService.getGoodsName(item_name);
		System.out.println(isCheck);
		
		res.put("isCheck", isCheck);
		return res;
	}
}
