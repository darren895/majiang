package com.majiang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.majiang.dto.UserFanDTO;
import com.majiang.entity.FightFan;

public interface FightFanMapper {

	void insertFightFan(FightFan fightFan);
	
	List<FightFan> getFightFanByFight(@Param("id")int id);
	
	int clearFightFanByFight(@Param("id")int id);
	
	List<UserFanDTO> countUserFan(@Param("id")int id);
}
