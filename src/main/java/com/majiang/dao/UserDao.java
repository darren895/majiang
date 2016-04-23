package com.majiang.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.majiang.entity.User;

@Repository
public class UserDao extends SqlSessionDaoSupport {
	
	private final static String nameSpace = "user";

	public void insertUser(User user){
		getSqlSession().insert(nameSpace+".insertUser", user);
	}
	
	public User getUserByName(String name){
		return getSqlSession().selectOne(nameSpace+".getUserByName", name);
	}
	
	public User getUserById(int id){
		return getSqlSession().selectOne(nameSpace+".getUserById", id);
	}
	
	public List<User> getUsersByPage(int start,int size){
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("size", size);
		return getSqlSession().selectList(nameSpace+".getUsersByPage", param);
	}
}
