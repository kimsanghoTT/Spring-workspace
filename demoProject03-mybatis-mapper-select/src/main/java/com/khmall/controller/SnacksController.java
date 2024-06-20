package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Snacks;
import com.khmall.service.SnacksService;

//Service에 작성한 기능을 종합해서 db와 html을 연결
@Controller
public class SnacksController {
	
	@Autowired//SnacksService에 작성된 모든 기능활용(의존성 주입)
	private SnacksService snackService;
	
	@GetMapping("/allSnack")
	public String getAllSnacks(Model model) {
		
		//스낵서비스에서 추가적인 서비스 기능으로 다듬어진 메서드 가져오기
		List<Snacks> snackList = snackService.getAllSnacks();
		
		//th:each문에서 ${snackList}로 작성했으므로
		//html에 전달할 목록들을 "" 안의 snackList라는 변수명으로 전달
		//Model은 db에서 가져온 값을 전달해주는 연결고리
		model.addAttribute("snackList",snackList);
		
		return "snackList";
		//return "스낵리스트가 작성된 html파일명";
	}
}
