package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Pig;

@Mapper
public interface PigMapper {
	
	//전체 가져오기
	List<Pig> getAllPigs();
	
	//돼지 정보 하나만 가져오기
	Pig getPigById(int pig_id);
	
	//돼지 정보 db에 업로드하기
	public void uploadPig(Pig pig);
}
