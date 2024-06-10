package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HelloController {

	@RequestMapping("/test")
	public String testMethod() {
		System.out.println("/test 요청 받았는지 확인");
		return "test";
	}
}
