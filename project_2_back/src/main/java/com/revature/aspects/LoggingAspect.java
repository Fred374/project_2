package com.revature.aspects;

import org.aspectj.bridge.AbortException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component 
@Aspect
public class LoggingAspect {
	
	Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	
	@Before("within(com.revature.controllers.*)")
	public void logModelMethods(JoinPoint jp) {
		
		log.trace(jp.getTarget() + " invoked " + jp.getSignature());
	}
	
	@Around(value="execution(* com.revature.controllers.*.*(..))")
	public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {
		
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} catch (Exception e) {
			log.info("AbortException status code {}", e.getCause());
			log.info("Message {}", e.getLocalizedMessage());
		}
		
		return null;
		
	}
	
}


