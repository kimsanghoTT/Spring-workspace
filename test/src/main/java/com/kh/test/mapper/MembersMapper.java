package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.dto.Members;

@Mapper
public interface MembersMapper {
	
	void insertEmail(Members members);
}
