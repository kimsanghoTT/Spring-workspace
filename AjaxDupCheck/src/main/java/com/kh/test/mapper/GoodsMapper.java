package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper {

	int getGoodsName(String item_name);
}
