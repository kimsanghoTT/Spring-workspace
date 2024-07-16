package com.kh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.dto.TodoMember;

@Mapper
public interface TodoMapper {
	int idCheck(String id);
	int signup(TodoMember todoMember);
	//TodoMember login(@Param("id") String id, @Param("pw") String pw);
	TodoMember login(TodoMember todoMember); //해도 됨
}
