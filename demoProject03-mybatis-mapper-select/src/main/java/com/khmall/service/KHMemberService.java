package com.khmall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khmall.dto.KHMember;
import com.khmall.mapper.KHMemberMapper;

@Service
public class KHMemberService {

	@Autowired
	private KHMemberMapper khmemberMapper;
	
	public List<KHMember> getAllkhmember(){
		
		return khmemberMapper.getAllkhmember();
	}
}
