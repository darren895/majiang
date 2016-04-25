package com.majiang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.majiang.entity.Fan;

public interface FanMapper {

	List<Fan> getAll();
	
	Fan getFanById(@Param("id")int id);
}
