package com.majiang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.majiang.entity.User;

public interface UserMapper {

	void insertUser(User user);
	
	User getUserByName(@Param("name")String name);
	
	User getUserById(@Param("id")int id);
	
	List<User> getUsersByPage(@Param("start")int start,@Param("size")int size);
	
	int updateUser(User user);
	
	User getUserByNameWithPassword(@Param("name")String name);
}
