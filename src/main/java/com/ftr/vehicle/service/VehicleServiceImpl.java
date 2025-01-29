

package com.ftr.vehicle.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ftr.vehicle.dto.VehicleDTO;
import com.ftr.vehicle.entity.Vehicle;
import com.ftr.vehicle.exception.VehicleException;
import com.ftr.vehicle.repository.VehicleRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository; // Assume this is the repository interface for FtrVehicle entity
    
	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public Environment environment;

    @Override
    public String insertNewVehicle(VehicleDTO vehicleDTO) throws VehicleException {
        try {
            // Convert DTO to Entity
        	Optional<Vehicle> vehicle = vehicleRepository.findById(vehicleDTO.getVehicleNumber());
        	if(vehicle.isPresent())
        		throw new VehicleException("VEHICLE_NOT_FOUND");
        	
            Vehicle v = modelMapper.map(vehicleDTO, Vehicle.class);
            vehicleRepository.save(v);
            return "VEHICLE_CREATE_SUCCESS";
        } catch (Exception e) {
            throw new VehicleException(environment.getProperty("GENERAL_EXCEPTION"));
        }
    }

    
    @Override
    public List<VehicleDTO> fetchAvailableVehicles() throws VehicleException {
        try {
            
        	Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        	return modelMapper.map(vehicles, new TypeToken<List<VehicleDTO>>() {}.getType());
        } catch (Exception e) {
            throw new VehicleException(environment.getProperty("GENERAL_EXCEPTION"));
        }
    }

    @Override
    public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws VehicleException {
        try {
            List<Vehicle> vehicles = vehicleRepository.fetchVehicleDetailsByVehicleName(vehicleName);
            if(vehicles.isEmpty())
            	throw new VehicleException("VEHICLE_NOT_FOUND");
            return modelMapper.map(vehicles, new TypeToken<List<VehicleDTO>>() {}.getType());
        }catch (Exception e) {
            throw new VehicleException(environment.getProperty("GENERAL_EXCEPTION"));
        }
    }

    @Override
    public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws VehicleException {
        try {
            Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleNumber);
            return modelMapper.map(vehicleOptional.orElseThrow(() -> new VehicleException("VEHICLE_NOT_FOUND")), VehicleDTO.class);
        } catch (Exception e) {
            throw new VehicleException(environment.getProperty("GENERAL_EXCEPTION"));
        }
    }

    @Override
    public String removeVehicle(String vehicleNumber) throws VehicleException {
        try {
            Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleNumber);
            vehicleOptional.orElseThrow(() -> new VehicleException("VEHICLE_NOT_FOUND"));
            vehicleRepository.deleteById(vehicleNumber);
            return "VEHICLE_DELETE_SUCCESS";
        } catch (Exception e) {
            throw new VehicleException(environment.getProperty("GENERAL_EXCEPTION"));
        }
    }

    @Override
    public String updateVehicleStatus(String vehicleNumber, String vehicleStatus) throws VehicleException {
        try {
            Optional<Vehicle> vehicleOptional = vehicleRepository.findById(vehicleNumber);
            Vehicle vehicalEntity = vehicleOptional.orElseThrow(() -> new VehicleException("VEHICLE_NOT_FOUND"));
            vehicalEntity.setVehicleStatus(vehicleStatus);
            return "VEHICLE_UPDATE_STATUS";
        } catch (Exception e) {
            throw new VehicleException(environment.getProperty("GENERAL_EXCEPTION"));
        }
    }
}

