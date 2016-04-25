package com.majiang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.dao.UserDao;
import com.majiang.entity.User;
import com.majiang.mapper.UserMapper;

@Service
public class UserService {
//	@Autowired
//	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * ����������û�
	 * @param user
	 */
	public void fillUser(User user){
		User newUser = this.userMapper.getUserByName(user.getName());
		if(newUser != null){
			user.setId(newUser.getId());
		}else{
			this.userMapper.insertUser(user);
		}
	}
	
	public User getUser(int id){
		return this.userMapper.getUserById(id);
	}
	
	public List<User> getUserByPage(int page,int size){
		int start = (page-1) * size;
		return userMapper.getUsersByPage(start, size);
	}

}
