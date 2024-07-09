package com.kh.test.mapper;

import com.kh.test.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Mapper {
	
	void insertEmail(Member member);
}
