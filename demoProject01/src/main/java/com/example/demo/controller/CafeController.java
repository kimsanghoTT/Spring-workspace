package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.CafeDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {
	
	/*
	 * <input type="text" name="cafeCommentName" required>
	 * <input type="text" name="cafeCommentOpinion" required>
	 * */
	
/*	@PostMapping("comment")
	public String cafeComment(@RequestParam("cafeCommentName") String cafeCommentName,
			@RequestParam("cafeCommentOpinion") String cafeCommentOpinion
			) {
		log.info("의견 전송 확인");
		log.debug("cafeCommentName : " + cafeCommentName);
		log.debug("cafeCommentOpinion : " + cafeCommentOpinion);
		log.info("완료 후 index로 되돌아가기");
		return "redirect:/cafe/cafe_index";
	}*/
	
	@PostMapping("comment")
	public String cafeComment(CafeDTO cafeComment) {
		
		CafeDTO cd = new CafeDTO();
		cd.getCafeCommentName();
		cd.setCafeCommentName("김옥자");
		
		cd.getCafeCommentOpinion();
		cd.setCafeCommentOpinion("잘 봤어요");
		
		log.info(cd.getCafeCommentName());
		log.info(cd.getCafeCommentOpinion());
		
		return "redirect:/cafe/cafe_index";
	}
}
