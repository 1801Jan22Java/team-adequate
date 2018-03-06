package com.adequate.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="loggingAspect")
public class LoggingAspect {

	// could be configured as a bean
	private static Logger log = Logger.getRootLogger();
	
	@After("execution (* com.adequate.*.*(..))")
	public void logBefore(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	
	@AfterThrowing(pointcut="within(com.adequate.*.*)")
	public void logAfterThrow(JoinPoint jp) {
		log.error(jp.getSignature());
	}
}
