package com.majiang.controller.mobile;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majiang.annotation.MobileLogined;
import com.majiang.dto.BaseMobileDTO;
import com.majiang.dto.LoginDTO;
import com.majiang.dto.UserFanDTO;
import com.majiang.entity.User;
import com.majiang.service.FightFanService;
import com.majiang.service.UserService;

@Controller
@RequestMapping("mobile")
public class MobileUserController extends BaseController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private FightFanService fightFanService;

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
	public User getLoginUser(HttpServletRequest request){
		String uuid = request.getHeader("uuid");
		User user = this.userService.getUser(new BaseMobileDTO(uuid));
		return user;
	}
	
	@ResponseBody
	@RequestMapping(value="regedit",method=RequestMethod.POST)
	public Map<String, Object> regedit(@RequestBody User user){
		User newUser = this.userService.regeditUser(user);
		Map<String, Object> result = new HashMap<String, Object>();
		if(newUser == null){
			result.put("error", true);
			result.put("result", false);
			result.put("errorMessage", "注册失败");
		}else{
			result.put("error", false);
			result.put("result", true);
		}
		return result;
	}
	
	@MobileLogined
	@ResponseBody
	@RequestMapping(value="unlogin",method=RequestMethod.DELETE)
	public Map<String, Object> unLogin(HttpServletRequest request){
		String uuid = request.getHeader("uuid");
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", this.userService.unLogin(uuid));
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@MobileLogined
	@ResponseBody
	@RequestMapping(value="userfan",method=RequestMethod.GET)
	public List<UserFanDTO> getUserFan(HttpServletRequest request){
		String uuid = request.getHeader("uuid");
		User user = this.userService.getUser(new BaseMobileDTO(uuid));
		List<UserFanDTO> userFanDTOs = fightFanService.getUserFanDTO(user.getId());
		if(userFanDTOs!=null && !userFanDTOs.isEmpty()){
			return userFanDTOs;
		}else{
			return Collections.EMPTY_LIST;
		}
	}
}
