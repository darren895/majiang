package com.majiang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	public void verifyLogin(JoinPoint joinPoint) throws Throwable{
		Object[] params = joinPoint.getArgs();
		for (Object param : params) {
			if((param instanceof BaseMobileDTO) && mobileCommonService.verifyToken((BaseMobileDTO) param)){
				return ;
			}
		}
		throw new UnLoginException();
		
	}
}
