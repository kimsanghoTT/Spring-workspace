package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Pig;

@Mapper
public interface PigMapper {

	List<Pig> getAllPigs();
	
	Pig getPigById(int pig_id);
}
