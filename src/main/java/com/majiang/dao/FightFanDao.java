package com.majiang.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.majiang.dto.UserFanDTO;
import com.majiang.entity.FightFan;

@Repository
public class FightFanDao extends SqlSessionDaoSupport {
	
	private final static String nameSpace = "fightFan";
	public void insertFightFan(FightFan fightFan){
		getSqlSession().insert(nameSpace+".insertFightFan", fightFan);
	}
	
	public List<FightFan> getFightFanByFight(int fightId){
		return getSqlSession().selectList(nameSpace + ".getFightFanByFight", fightId);
	}
	
	public void clearFightFan(int fightId){
		getSqlSession().delete(nameSpace + ".clearFightFanByFight", fightId);
	}
	
	public List<UserFanDTO> getUserFanDTO(int userId){
		return getSqlSession().selectList(nameSpace+".countUserFan", userId);
	}

}
