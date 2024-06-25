package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Member;

@Mapper
//@MapperScan mapper위치가 찾아지지 않을 때 main 메서드에 Mapper 주소를 작성해주는 어노테이션
//@MapperScan("com.khmall.mapper.LoginMapper") 매퍼 하나 가져오기
//@MapperScans("com.khmall.mapper.*") 매퍼 여러개 가져오기
public interface LoginMapper {

	Member getLogin(@Param("member_name") String member_name,
			@Param("member_phone") String member_phone);
	
	//insert와 update, delete는 void
	//select에서 1개의 값을 볼 떄는 List를 안쓰고 2개 이상의 값을 볼 때는 List
	
	void updateMember(Member member);
	
	void deleteMember(@Param("member_id") int member_id);
	
	List<Member> searchMembers(@Param("keyword") String keyword);
	
	
}
