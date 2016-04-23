package com.majiang.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.dao.FanDao;
import com.majiang.entity.Fan;
@Service
public class FanService {

	@Autowired
	private FanDao fanDao;
	
	private List<Fan> fans;
	
	public List<Fan> getAll(){
		if(fans ==null){
			fans = fanDao.getAll();
		}
		return fans;
	}
	
	private Map<Integer, Fan> fanMap = new HashMap<Integer, Fan>();;
	
	public Map<Integer, List<Fan>> getFanMap(){
		List<Fan> fans = getAll();
		Map<Integer, List<Fan>> fanMap = new HashMap<Integer, List<Fan>>();
		for (Fan fan : fans) {
			if(fanMap.containsKey(fan.getScore())){
				fanMap.get(fan.getScore()).add(fan);
			}else{
				List<Fan> fanList = new ArrayList<Fan>();
				fanList.add(fan);
				fanMap.put(fan.getScore(), fanList);
			}
		}
		return fanMap;
	}
	
	public List<List<Fan>> sortFanList(Map<Integer, List<Fan>> fanMap){
		List<List<Fan>> list = new ArrayList<List<Fan>>();
		for (int i = 88; i > 0; i--) {
			List<Fan> fans = fanMap.get(i);
			if(fans != null){
				list.add(fans);
			}
		}
		return list;
	}
	
	public Fan getFan(int id){
		if(fanMap.containsKey(id)){
			return fanMap.get(id);
		}else{
			Fan fan = this.fanDao.getFanbyId(id);
			if(fan!= null){
				fanMap.put(id, fan);
			}
			return fan;
		}
	}
}
