package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.test.service.GoodsService;

@Controller
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@GetMapping("/")
	public String htmlStart() {
		return "index";
	}
	
	@GetMapping("/itemCheck")
	@ResponseBody // json Type 값을 가져옴
	public Map<String, Object> getGoods(@RequestParam String item_name){
		Map<String, Object> result = new HashMap<>();
		boolean isCheck = goodsService.getGoods(item_name);
		
		result.put("isCheck", isCheck);
		
		return result;
	}
}
