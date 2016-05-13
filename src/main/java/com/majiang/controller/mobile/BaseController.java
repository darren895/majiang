package com.majiang.controller.mobile;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.majiang.exception.UnLoginException;

public class BaseController {

	@ResponseBody
	@ExceptionHandler()
	public Map<String, Object> exc(Exception ex){
		Map<String, Object> result = new HashMap<String, Object>();
		if(ex instanceof UnLoginException){
			result.put("error", true);
			result.put("errorMessage", "请登录");
		}else{
			result.put("error", true);
			result.put("errorMessage", "系统出错");
		}
		return result;
	}
}
