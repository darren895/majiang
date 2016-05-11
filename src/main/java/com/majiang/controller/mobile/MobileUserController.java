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

import com.majiang.annotation.MobileLogined;
import com.majiang.dto.BaseMobileDTO;
import com.majiang.dto.LoginDTO;
import com.majiang.entity.MobileUser;
import com.majiang.entity.User;
import com.majiang.service.UserService;
import com.majiang.util.RSAUtil;

@Controller
@RequestMapping("mobile")
public class MobileUserController extends BaseController {
	
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public Map<String, Object> login(@RequestBody LoginDTO loginDTO){
		Map<String, Object> result = new HashMap<>();
		String token = this.userService.login(loginDTO);
		if(token==null){
			result.put("status", false);
		}else{
			result.put("status", true);
			result.put("token", token);
		}
		return result;
	}
	
	@MobileLogined
	@ResponseBody
	@RequestMapping(value="user",method=RequestMethod.GET)
	public User getLoginUser(@RequestBody BaseMobileDTO baseMobileDTO){
		User user = this.userService.getUser(baseMobileDTO);
		return user;
	}
}
