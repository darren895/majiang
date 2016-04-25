package com.majiang.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.dto.UserFanDTO;
import com.majiang.entity.Fan;
import com.majiang.entity.FightFan;
import com.majiang.mapper.FightFanMapper;

@Service
public class FightFanService {
	
//	@Autowired
//	private FightFanDao fightFanDao;
	@Autowired
	private FightFanMapper fightFanMapper;
	
	@Autowired
	private FanService fanService;

	public void insertFightFan(FightFan fightFan){
		fightFanMapper.insertFightFan(fightFan);
	}
	
	public List<FightFan> getFightFanByFight(int fightId){
		return fightFanMapper.getFightFanByFight(fightId);
	}
	
	public Map<Integer,Integer> getFanMapByFight(int fightId){
		Map<Integer,Integer> fanIds = new HashMap<Integer,Integer>();
		List<FightFan> fightFans = getFightFanByFight(fightId);
		if(fightFans != null && !fightFans.isEmpty()){
			for (FightFan fightFan : fightFans) {
				if(fanIds.containsKey(fightFan.getFanId())){
					fanIds.put(fightFan.getFanId(), fanIds.get(fightFan.getFanId())+1);
				}else{
					fanIds.put(fightFan.getFanId(), 1);
				}
			}
		}
		return fanIds;
	}
	
	public void clearFightFanByFight(int fightId){
		this.fightFanMapper.clearFightFanByFight(fightId);
	}
	
	public List<UserFanDTO> getUserFanDTO(int userId){
		List<UserFanDTO> userFanDTOs = this.fightFanMapper.countUserFan(userId);
		UserFanDTO removefan = null;
		if(userFanDTOs != null && !userFanDTOs.isEmpty()){
			for (UserFanDTO userFanDTO : userFanDTOs) {
				Fan fan = fanService.getFan(userFanDTO.getFanId());
				userFanDTO.setFan(fan);
				if(fan.getId() == 13){
					removefan = userFanDTO;
				}
			}
			if(removefan != null){
				userFanDTOs.remove(removefan);
			}
		}
		return userFanDTOs;
	}
}
