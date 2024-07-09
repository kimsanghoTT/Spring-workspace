package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
//MapperScan은 com.kh.test 안에 있는 @SpringBootApplication에서
//위 아래 상관 없이 @MapperScan(com.kh.test.mapper)을 넣어주는 것
public interface GoodsItemMapper {

	Integer existByName(String itemName);
}
