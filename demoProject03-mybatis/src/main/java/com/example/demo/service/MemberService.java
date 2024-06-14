package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Member;
import com.example.demo.mapper.MemberMapper;

/*
	상세적인 기능을 작성해주는 공간
	정규식이나 비밀번호 암호처리 같은 기능을 세부적으로 작성하는 공간
 */

@Service // 어떤 서비스를 제공할 것인지 작성하는 공간
public class MemberService {
	@Autowired //해당 값에 작성된 내용을 자동적으로 전달
	private MemberMapper memberMapper;
	
	public void 멤버가입(Member member) {
		// 비밀번호 설정, 일치여부, 정규식 등을 여기 작성
		memberMapper.insertMember(member);
	}
}
