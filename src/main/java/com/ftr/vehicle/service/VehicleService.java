package com.ftr.vehicle.service;

import java.util.List;

import com.ftr.vehicle.dto.VehicleDTO;
import com.ftr.vehicle.exception.VehicleException;

public interface VehicleService {
	public String insertNewVehicle(VehicleDTO vehicleDTO) throws VehicleException;
	public List<VehicleDTO> fetchAvailableVehicles() throws VehicleException;
	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException;
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleException;
	public String removeVehicle(String vehicleNumber) throws VehicleException;
	public String updateVehicleStatus(String vehicleNumber, String vehicleStatus) throws VehicleException;
}
