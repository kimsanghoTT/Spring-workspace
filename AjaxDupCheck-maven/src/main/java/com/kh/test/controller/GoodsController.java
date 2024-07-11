package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.test.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/checkName")
	public Map<String, Object> getGoodsName(@RequestParam String item_name){
		Map<String, Object> res = new HashMap<>();
		boolean isCheck = goodsService.getGoodsName(item_name);
		
		res.put("isCheck", isCheck);
		return res;
	}
}
