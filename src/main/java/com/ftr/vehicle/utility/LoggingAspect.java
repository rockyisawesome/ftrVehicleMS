package com.ftr.vehicle.utility;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ftr.vehicle.exception.VehicleException;

@Component
@Aspect
public class LoggingAspect {
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	
	@AfterThrowing(pointcut = "execution(* com.ftr.vehicle.service.*Impl.*(..))", throwing = "exception")
	public void logServiceException(VehicleException exception) {
		LOGGER.error(exception.getMessage());
	}
	

}
