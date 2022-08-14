package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component 
@Aspect
public class LoggingAspect {
	
	Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	@Before("within(com.revature.controllers.*)")
	public void logModelMethods(JoinPoint jp) {
		
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
		
	}
	
//	@AfterReturning(pointcut="within(com.revature.controllers.*)", returning="returnedObject")
//	public void logSuccessfulFight(JoinPoint jp, Object returnedObject) {
//		
//		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " and returned " + returnedObject);	
//		
//	}
}


