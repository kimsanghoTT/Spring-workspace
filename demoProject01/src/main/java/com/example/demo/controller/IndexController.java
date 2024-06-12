package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j//각 메서드 이동할 때마다 log.info써서 위치 이동 찍기
public class IndexController {

	@GetMapping("cafe/cafe_index")
	public String cafeMainMethod() {
		log.info("cafe index 메인으로 이동");
		return "cafe/cafe_index";
	}
	
	//blog-index로 이동하는 GetMapping
	@GetMapping("blog/blog-index")//주소창에서 back과 front가 만나는 주소(만남의 장소)
	public String blogMainMethod() {
		log.info("blog index 메인으로 이동");
		return "blog/blog-index";//html 파일 위치
	}
	
	@GetMapping("blog/blog-board")
	public String blogBoardMethod() {
		log.info("blog board 게시판으로 이동");
		return "blog/blog-board";
	}
	
	@GetMapping("cafe/cafe_board")
	public String cafeBoardMethod() {
		log.info("cafe board 게시판으로 이동");
		return "cafe/cafe_board";
	}
	
}
