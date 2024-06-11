package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

//index라는 이름은 기본으로 바라보는 페이지명. 보통 처음 맨 앞에 있는 페이지명은 index로 설정
@Controller
@Slf4j
public class indexController {
	
	@RequestMapping("test")
	public String testMethod() {
		//log.info로 test 출력
		log.info("test 페이지 이동");
		
		return "test";
	}
	
	@RequestMapping("home")
	public String homeMethod() {
		log.info("홈페이지로 이동 확인");
		return "index";
		//@RequestMapping("home")과 return에 작성한 이름이 달라도 됨
	}
}
