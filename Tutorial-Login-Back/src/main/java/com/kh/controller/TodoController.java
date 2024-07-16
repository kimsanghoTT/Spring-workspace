package com.kh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.dto.TodoMember;
import com.kh.service.TodoService;

import lombok.extern.slf4j.Slf4j;

//스프링부트 어플리케이션(폴더 안)에서 html 코드를 작성해주는 것이 아니라
//React나 url 주소를 공유할 때 사용
@RestController
@Slf4j
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	/* 
		아이디 중복 검사 
			@Param(파라미터 = 매개변수(중간에 개입해 값을 변하게 하는 수))
			@Param id 값을 가져와서 아이디 중복 결과를 보여줌
			return 아이디 중복 확인 후에 결과를 되돌려 주는 것
			return 중복 시 1, 중복이 아닐 시 0 반환
	*/
	@GetMapping("idCheck")
	public int idCheck(@RequestParam("id") String id) {
		return todoService.idCheck(id);
	}
	
	/*
		회원 가입
			@Param member 회원 가입할 때 작성한 정보 모두 가져오기
			return 회원가입을 성공하면 1, 실패시 0 반환
	*/
	/*
		@Request = DB에 특정 값이 있는지, 또는 값을 넣거나 수정을 요청
		@RequestParam = 특정 값만 선택해서 요청, 특정 값을 변환해서 요청
		@RequestBody = 프론트에서 작성하고 Body로 전달해주는 모든 값을 넣어줌
			-> React 기준
			body : JSON.stringify(input값)
				=> 모든 input값들을 DB에 넣겠다 선언
		
		@Response = DB에서 전달받은 값을 프론트에 전달할 때 사용
		@ResponseParam = 특정 값만 프론트에 전달함을 선언
		@ResponseBody = html에서 body로 보여줄 모든 값을 전달
	*/
	@PostMapping(value="/signup")
	public int signup(@RequestBody TodoMember todoMember) {
		return todoService.signup(todoMember);
	}
	/*
	@PostMapping(value="/login")
	public TodoMember login(@RequestBody Map<String, String> login) {
		String id = login.get("id");
		String pw = login.get("pw");
		return todoService.login(id, pw);
	}
	*/
	/*
		로그인
		@Param todoMember
		return 성공 : 회원 정보와 /todoList를 정보 제공, 실패 : null
	*/
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody TodoMember todoMember){
		return todoService.login(todoMember);
	}
	
}
