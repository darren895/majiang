package com.majiang.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.majiang.dto.BaseMobileDTO;
import com.majiang.exception.UnLoginException;
import com.majiang.service.MobileCommonService;

@Component
@Aspect
public class MobleAspect {
	
	@Autowired
	private MobileCommonService mobileCommonService;
	
	@Pointcut("@annotation(com.majiang.annotation.MobileLogined)")
	public void loginPointCut(){}

	@Before("loginPointCut()")
	public void verifyLogin(JoinPoint joinPoint) throws UnLoginException{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		String uuid = request.getHeader("uuid");
		String token = request.getHeader("token");
		String time = request.getHeader("time");
		if(uuid!= null && token != null && time != null){
			BaseMobileDTO baseMobileDTO = new BaseMobileDTO();
			baseMobileDTO.setTime(Long.parseLong(time));
			baseMobileDTO.setUuid(uuid);
			baseMobileDTO.setToken(token);
			int userId = this.mobileCommonService.verifyToken(baseMobileDTO);
			if(userId!=0){
				request.setAttribute("userId", userId);
				return;
			}
		}
		throw new UnLoginException();
		
	}
}
