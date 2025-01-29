package com.ftr.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ftr.vehicle.entity.Vehicle;


public interface VehicleRepository extends CrudRepository<Vehicle, String> {

	@Query("SELECT v FROM Vehicle v WHERE v.vehicleName = ?1")
	public List<Vehicle> fetchVehicleDetailsByVehicleName(String vehicleName);
}
