package com.kh.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kh.mapper.TodoMapper;

public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoMapper todomapper;
}
