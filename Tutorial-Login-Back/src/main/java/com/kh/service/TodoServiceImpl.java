package com.kh.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.dto.TodoMember;
import com.kh.mapper.TodoMapper;
/*
	Service  /  ServiceImpl
	
	Service : 코드를 작성하는데 있어 어떠한 서비스를 사용하겠다는 계약, 정의
	-> 어떤 메서드(기능)들이 있어야하고 그 메서드들이 어떤 역할을 하는지 정의
	
	ServiceImpl : 인터페이스로 작성한 Service의 실제 기능 작성
	-> 비슷한 기능을 각 서비스에 맞춰 사용하겠다는 의미
		ex) createUser = user를 만들 때 user를 관리자 / 소비자로 나눠서 만들기
*/
@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoMapper todoMapper;
	
	//interface에 기능이 명시가 되어있고 명시된 기능을 완벽하게 만드는 오버라이드(재사용)이라는 표기 작성
	//생략이 가능하나 개발자 간의 약속이니 작성해주는 것이 좋음
	
	//만약 판매자가 회원가입한 경우
	@Override
	public int idCheck(String id) {
		return todoMapper.idCheck(id);
	}
	
	@Override
	public int signup(TodoMember todoMember) {
		return todoMapper.signup(todoMember);
	}
	/*
	@Override
	public TodoMember login(String id, String pw) {
		return todoMapper.login(id, pw);
	}
	*/
	
	@Override
	public Map<String, Object> login(TodoMember todoMember) {
		TodoMember loginMember = todoMapper.login(todoMember);
		
		Map<String, Object> map = new HashMap<>();
		map.put("loginMember", loginMember);
		
		return map;
	}
	
}
