package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.Member;

/*
	db에 어떠한 값을 삽입, 조회, 삭제, 수정하는 것을 작성만 해두는 공간
*/
@Mapper //Mapper라는 명칭 지정
public interface MemberMapper {
	//멤버가 새로 가입하면 db에 넣어주기
	void insertMember(Member member);

	
}
