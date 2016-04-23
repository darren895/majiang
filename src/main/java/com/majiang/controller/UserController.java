package com.majiang.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majiang.dto.UserFanDTO;
import com.majiang.entity.User;
import com.majiang.service.FightFanService;
import com.majiang.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FightFanService fightFanService;
	
	private final int size = 20;
	
	@RequestMapping("/view_users")
	public String viewUsers(Model model){
		return "viewUsers";
	}
	
	@ResponseBody
	@RequestMapping(value="/users/{page}",method=RequestMethod.GET)
	public List<User> users(@PathVariable("page")int page){
		List<User> users = userService.getUserByPage(page, size);
		if(users==null){
			return Collections.EMPTY_LIST;
		}else{
			return users;
		}
	}
	
	@RequestMapping("/view_user/{id}")
	public String viewUser(@PathVariable("id")int userId,Model model){
		User user = userService.getUser(userId);
		if(user != null){
			List<UserFanDTO> userFanDTOs = this.fightFanService.getUserFanDTO(userId);
			model.addAttribute("userFanDTOs",userFanDTOs);
			model.addAttribute("user", user);
		}
		return "user";
	}

}
