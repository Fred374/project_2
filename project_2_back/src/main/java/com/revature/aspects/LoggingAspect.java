package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component 
@Aspect
public class LoggingAspect {
	
		private static Logger log = LogManager.getLogger();
		
		
		@Before("within(com.revature.models.*)")
		public void logModelMethods(JoinPoint jp) {
			
			
			log.info(jp.getTarget() + " invoked " + jp.getSignature());
			
		}
		
		@AfterReturning(pointcut="execution(String fight(..))", returning="returnedObject")
		public void logSuccessfulFight(JoinPoint jp, Object returnedObject) {
			
			log.info(jp.getTarget() + " invoked " + jp.getSignature() + " and returned " + returnedObject);
			
			
			
		}
		
		
	
		
	}


