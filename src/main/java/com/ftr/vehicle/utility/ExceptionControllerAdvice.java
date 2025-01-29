package com.ftr.vehicle.utility;

import org.apache.commons.logging.LogFactory;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ftr.vehicle.exception.VehicleException;

//@RestControllerAdvice
public class ExceptionControllerAdvice {
//	private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);
//	
//	@Autowired
//	Environment environment;
//	
//	@ExceptionHandler
//	public ResponseEntity<VehicleErrorInfo> vehicleExceptionHandler(VehicleException exception){
//		LOGGER.error(exception.getMessage());
//		VehicleErrorInfo vehicleErrorInfo = new VehicleErrorInfo();
//		vehicleErrorInfo.setErrorMessage(environment.getProperty(exception.getMessage()));
//		vehicleErrorInfo.setErrorCode(HttpStatus.NOT_FOUND.value());
//		vehicleErrorInfo.setTimeStamp(LocalDateTime.now());
//		return new ResponseEntity<>(vehicleErrorInfo, HttpStatus.NOT_FOUND);
//	}
}
