package com.kh.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kh.test.dto.GoodsItems;

@Mapper
public interface GoodsItemsMapper {

	GoodsItems countByName(@Param("itemName") String itemName);
}
