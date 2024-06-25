package com.khmall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.Member;
import com.khmall.mapper.MemberMapper;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	public Member getLogin(String member_name, String member_phone) {
		//추후에 서비스에 비밀번호를 암호화해서 db에 저장하고
		//암호화된 비밀번호를 가져와서 로그인하는 코드 작성
		
		return memberMapper.getLogin(member_name, member_phone);
		
	}
}
