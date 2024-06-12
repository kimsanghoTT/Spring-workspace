package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("cafe")
@Slf4j
public class CafeController {
	
	/*
	 * <input type="text" name="cafeCommentName" required>
	 * <input type="text" name="cafeCommentOpinion" required>
	 * */
	
	@PostMapping("comment")
	public String cafeComment(@RequestParam("cafeCommentName") String cafeCommentName,
			@RequestParam("cafeCommentOpinion") String cafeCommentOpinion
			) {
		log.info("의견 전송 확인");
		log.debug("cafeCommentName : " + cafeCommentName);
		log.debug("cafeCommentOpinion : " + cafeCommentOpinion);
		log.info("완료 후 index로 되돌아가기");
		return "redirect:/cafe/cafe_index";
	}
}
