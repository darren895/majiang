package com.majiang.controller.mobile;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majiang.annotation.MobileLogined;
import com.majiang.dto.BaseMobileDTO;
import com.majiang.dto.BaseResultDTO;
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
		int userId = (int) request.getAttribute("userId");
		User user = this.userService.getUser(userId);
		return user; 
	}
	
	@ResponseBody
	@RequestMapping(value="regedit",method=RequestMethod.POST)
	public BaseResultDTO regedit(@RequestBody User user){
		User newUser = this.userService.regeditUser(user);
		BaseResultDTO baseResultDTO = new BaseResultDTO();
		if(newUser == null){
			baseResultDTO.setResult(false);
			baseResultDTO.setMessage("注册失败");
		}else{
			baseResultDTO.setResult(true);
		}
		return baseResultDTO;
	}
	
	@MobileLogined
	@ResponseBody
	@RequestMapping(value="unlogin",method=RequestMethod.DELETE)
	public BaseResultDTO unLogin(HttpServletRequest request){
		String uuid = request.getHeader("uuid");
		BaseResultDTO baseResultDTO = new BaseResultDTO();
		baseResultDTO.setResult(this.userService.unLogin(uuid));
		return baseResultDTO;
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
