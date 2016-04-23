package com.majiang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StatAspect {
	
//	@Before("execution(* com.majiang.*.*.*(*))")
	public void doBefore(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName());
	}

}
