package com.majiang.mapper;

import org.apache.ibatis.annotations.Param;

import com.majiang.entity.MobileUser;

public interface MobileUserMapper {

	MobileUser getMobileUser(@Param("uuid")String uuid);
	
	void insertMobileUser(MobileUser mobileUser);
	
	int updateMobileUser(MobileUser mobileUser);
}
