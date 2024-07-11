package com.kh.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.dto.Members;
import com.kh.test.mapper.MembersMapper;

@Service
public class MembersService {

	@Autowired
	private MembersMapper membersMapper;
	
	public void insertEmail(Members members) {
		membersMapper.insertEmail(members);
	}
}
