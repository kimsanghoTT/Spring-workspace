package com.khmall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.khmall.dto.Members;

@Mapper
public interface MembersMapper {

	Members getLogin(
			@Param ("username") String username,
			@Param ("password") String password
			);
}
