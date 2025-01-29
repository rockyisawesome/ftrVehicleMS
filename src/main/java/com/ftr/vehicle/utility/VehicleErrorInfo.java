package com.ftr.vehicle.utility;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class VehicleErrorInfo {
	private String errorMessage;
	private int errorCode;
	private LocalDateTime timeStamp;

}
