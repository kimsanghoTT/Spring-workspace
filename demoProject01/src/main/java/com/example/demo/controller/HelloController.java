package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/*
	Java 객체 : new 연산자에 의해 Heap 영역에 클래스에서 작성된 내용대로 생성된 것
	
	instance : 개발자가 만들고 관리하는 객체
	
	bean : Spring Contanier(=Spring)가 만들고 관리하는 객체
*/
@Controller // 요청이나 응답을 제어할 컨트롤러 역할 명시
			// bean으로 등록(= 객체로 생성해서 스프링이 관리)
public class HelloController {
	/* 
	기존 Servlet : 클래스 단위로 하나의 요청만 가능
 	Spring : 메서드 단위로 요청 처리 가능
	
	@RequestMapping("요청주소")
		- 요청 주소를 처리할 메서드를 매핑하는 어노테이션
		
		1) 메서드에 작성
			- 요청 주소와 메서드를 매핑
			- GET / POST 가리지 않고 매핑(속성을 통해 지정 가능)
			
		2) 클래스에 작성
			- 공통적으로 사용되는 주소는 한 번에 매핑
			ex) KH/쇼핑, KH/블로그, KH/카페
				@RequestMapping("KH")
				public class 클래스명{
					
					@RequestMapping("블로그")
					public String 메서드명(){} -> KH/블로그 매핑
					
					@RequestMapping("카페")
					public String 메서드명(){} -> KH/카페 매핑
					
					@RequestMapping("쇼핑")
					public String 메서드명(){} -> KH/쇼핑 매핑
				} 
	 */
	@RequestMapping("test")
	public String testMethod() {
		System.out.println("/test 요청 받았는지 확인");
		/*
		@RequestMapping을 쓰면 기본적으로 retrun할 때 html 파일을 봄
		
		classpath : src/main/resources
		기본경로 앞에 붙여진 /templates/ 폴더가 html을 담는 공간
		파일명 마지막에는 항상 .html이 붙는다
		*/
		
		
		// src/main/resource/templates/test.html 로 이동하겠다는 표시
		return "test";
		//= return(돌아가기) "html파일명";
	}
	
}
