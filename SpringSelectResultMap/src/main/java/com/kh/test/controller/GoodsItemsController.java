package com.kh.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.service.GoodsItemsService;

@RestController
public class GoodsItemsController {

	@Autowired
	private GoodsItemsService goodsItemsService;
	
	@GetMapping("/checkName")
	public Map<String, Boolean> countByName(@RequestParam String itemName){
		boolean checkName = goodsItemsService.countByName(itemName);
		System.out.println(checkName);
		Map<String, Boolean> result = new HashMap<>();
		
		result.put("checkName", checkName);
		
		return result;
	}
}
