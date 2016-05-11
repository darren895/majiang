package com.majiang.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.majiang.dto.BaseMobileDTO;
import com.majiang.dto.LoginDTO;
import com.majiang.entity.MobileLogin;
import com.majiang.entity.User;
import com.majiang.mapper.MobileLoginMapper;
import com.majiang.mapper.UserMapper;
import com.majiang.util.RSAUtil;
import com.majiang.util.SHAUtil;

@Service
public class UserService {
//	@Autowired
//	private UserDao userDao;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MobileLoginMapper mobileLoginMapper;
	
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
	
	public User regeditUser(User user){
		if(user == null || StringUtils.isEmpty(user.getName())){
			return null;
		}
		User oldUser = this.userMapper.getUserByNameWithPassword(user.getName());
		if(oldUser == null){
			oldUser = new User();
			oldUser.setName(user.getName());
			this.userMapper.insertUser(oldUser);
		}
		if(oldUser.getPassword() != null){
			return null;
		}
		String password = user.getPassword();
		password = RSAUtil.decrypt(password);
		password = SHAUtil.shaEncode(password);
		user.setPassword(password);
		user.setId(oldUser.getId());
		this.userMapper.updateUser(user);
		return user;
	}
	
	public String login(LoginDTO loginDTO){
		if(loginDTO == null || StringUtils.isEmpty(loginDTO.getName())||StringUtils.isEmpty(loginDTO.getPassword())){
			return null;
		}
		User user = this.userMapper.getUserByNameWithPassword(loginDTO.getName());
		if(user == null){
			return null;
		}
		String password = loginDTO.getPassword();
		password = RSAUtil.decrypt(password);
		password = SHAUtil.shaEncode(password);
		if(!password.equals(user.getPassword())){
			return null;
		}
		SecureRandom random = new SecureRandom();
		random.setSeed(System.nanoTime());
		long seed = random.nextLong();
		String token = SHAUtil.shaEncode(seed+"");
		MobileLogin mobileLogin = this.mobileLoginMapper.getMobileLoginWithoutStatus(loginDTO.getUuid());
		if(mobileLogin == null){
			mobileLogin = new MobileLogin();
			mobileLogin.setUuid(loginDTO.getUuid());
			mobileLogin.setStatus(1);
			mobileLogin.setUserId(user.getId());
			mobileLogin.setTokenKey(token);
			mobileLogin.setLoginTime(new Date());
			this.mobileLoginMapper.insertMobileLogin(mobileLogin);
		}else{
			mobileLogin.setStatus(1);
			mobileLogin.setTokenKey(token);
			mobileLogin.setUserId(user.getId());
			mobileLogin.setLoginTime(new Date());
			this.mobileLoginMapper.updateMobileLogin(mobileLogin);
		}
		return token;
	}
	
	public User getUser(BaseMobileDTO baseMobileDTO){
		MobileLogin mobileLogin = this.mobileLoginMapper.getMobileLogin(baseMobileDTO.getUuid());
		if(mobileLogin == null){
			return null;
		}
		return getUser(mobileLogin.getUserId());
	}

}
