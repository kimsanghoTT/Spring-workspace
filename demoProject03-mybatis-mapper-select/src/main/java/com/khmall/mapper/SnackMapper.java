package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Snacks;

@Mapper//spring 자체에서 Mapper 인터페이스는 sql db에 작성한 코드를 바라보는 위치임을 뜻하며
//@Mapper 어노테이션을 통해 이 Mapper는 sql 구문을 바라본다는 의미를 가짐
public interface SnackMapper {
	
	// db에서 모든 과자들을 가져올 수 있도록 진열목록을 작성
	List<Snacks> getAllSnacks();
}
