package com.majiang.mapper;

import org.apache.ibatis.annotations.Param;

import com.majiang.entity.MobileLogin;

public interface MobileLoginMapper {
	
	void insertMobileLogin(MobileLogin mobileLogin);
	
	int updateMobileLogin(MobileLogin mobileLogin);
	
	MobileLogin getMobileLogin(@Param("uuid")String uuid);
	
	MobileLogin getMobileLoginWithoutStatus(@Param("uuid")String uuid);

}
