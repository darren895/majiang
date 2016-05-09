package com.majiang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.majiang.entity.MobileUser;
import com.majiang.entity.User;
import com.majiang.mapper.MobileUserMapper;
import com.majiang.mapper.UserMapper;
import com.majiang.util.RSAUtil;

@Service
public class UserService {
//	@Autowired
//	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MobileUserMapper mobileUserMapper;
	
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
	
	public User getUser(String uuid){
		MobileUser mobileUser = this.mobileUserMapper.getMobileUser(uuid);
		if(mobileUser == null || mobileUser.getUserId().equals(0)){
			return null;
		}
		User user = getUser(mobileUser.getUserId());
		return user;
	}
	
	public boolean checkToken(String token){
		MobileUser tokenMobile = RSAUtil.encryptToken(token);
		if(tokenMobile == null){
			return false;
		}
		MobileUser mobileUser = this.mobileUserMapper.getMobileUser(tokenMobile.getUuid());
		return tokenMobile.equals(mobileUser);
	}

}
