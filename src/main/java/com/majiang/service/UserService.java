package com.majiang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.dao.UserDao;
import com.majiang.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据名称填充用户
	 * @param user
	 */
	public void fillUser(User user){
		User newUser = this.userDao.getUserByName(user.getName());
		if(newUser != null){
			user.setId(newUser.getId());
		}else{
			this.userDao.insertUser(user);
		}
	}
	
	public User getUser(int id){
		return this.userDao.getUserById(id);
	}
	
	public List<User> getUserByPage(int page,int size){
		int start = (page-1) * size;
		return userDao.getUsersByPage(start, size);
	}

}
