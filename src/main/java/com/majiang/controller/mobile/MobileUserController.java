package com.majiang.controller.mobile;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majiang.entity.MobileUser;
import com.majiang.entity.User;
import com.majiang.service.UserService;
import com.majiang.util.RSAUtil;

@Controller
@RequestMapping("mobile")
public class MobileUserController {
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value="user/{uuid}",method=RequestMethod.GET)
	public User getMobileUser(@PathVariable("uuid") String uuid){
		User user = userService.getUser(uuid);
		if(user == null){
			user = new User();
		}
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="user/{uuid}",method=RequestMethod.POST)
	public Map<String, Object> updateMobileUser(@RequestBody MobileUser mobileUser,@RequestParam("token")String token,@PathVariable("uuid")String uuid){
		Map<String, Object> result = new HashMap<String, Object>();
		return result;
		
	}
}
