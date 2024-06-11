package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("test")
	public String 테스트페이지연결메서드() {
		System.out.println("test 페이지로 연결됐는지 확인");
		
		/*
			@GetMapping을 쓰면 기본적으로 retrun할 때 html 파일을 봄
			
			classpath : src/main/resources
			기본경로 앞에 붙여진 /templates/ 폴더가 html을 담는 공간
			파일명 마지막에는 항상 .html이 붙는다
		*/
		
		
		// src/main/resource/templates/test.html 로 이동하겠다는 표시
		return "test";
		//= return(돌아가기) "html파일명";
	}
}
