package com.ftr.vehicle.controller;

import com.ftr.vehicle.dto.VehicleDTO;
import com.ftr.vehicle.exception.VehicleException;
import com.ftr.vehicle.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
//@RequestMapping("/api/vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleServiceImpl;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private Environment environment;
    
    
    @Operation(summary = "isTesting", description = "To check wether service is running or not")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successful")})
    @GetMapping(value = "/hello")
    public ResponseEntity<String> getMethodName() {
        return new ResponseEntity<String>("Hello bete", HttpStatus.OK);
    }
    

    // Endpoint to insert a new vehicle
    @PostMapping(value = "/ftr/vehicles", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertNewVehicle(@RequestBody VehicleDTO vehicleDTO) throws VehicleException{
        try {
            String message = vehicleServiceImpl.insertNewVehicle(vehicleDTO);
            return new ResponseEntity<>(environment.getProperty(message) + " " + vehicleDTO.getVehicleNumber(), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
        }
    }

    // Endpoint to fetch all available vehicles
    @GetMapping(value = "/ftr/vehicles")
    public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() {
        try {
            List<VehicleDTO> vehicles = vehicleServiceImpl.fetchAvailableVehicles();
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (VehicleException e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
        }
    }

//    // Endpoint to fetch vehicles by vehicle name
    @GetMapping("/ftr/vehicles/managed-name/{vehicleName}")
    public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName) {
        try {
            List<VehicleDTO> vehicles = vehicleServiceImpl.fetchVehicleDetailsByVehicleName(vehicleName);
            return new ResponseEntity<>(vehicles, HttpStatus.OK);
        } catch (Exception e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
        }
    }

    // Endpoint to fetch vehicle details by vehicle number
    @GetMapping("/ftr/vehicles/managed-number/{vehicleNumber}")
    public ResponseEntity<VehicleDTO> getVehicleByNumber(@PathVariable String vehicleNumber) {
        try {
            VehicleDTO vehicleDTO = vehicleServiceImpl.fetchVehicleDetailsByVehicleNumber(vehicleNumber);
            return new ResponseEntity<>(vehicleDTO, HttpStatus.OK);
        } catch (VehicleException e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
        }
    }

    // Endpoint to remove a vehicle by vehicle number
    @DeleteMapping("/ftr/vehicles/{vehicleNumber}")
    public ResponseEntity<String> removeVehicle(@PathVariable String vehicleNumber) {
        try {
            String message = vehicleServiceImpl.removeVehicle(vehicleNumber);
            return new ResponseEntity<>(environment.getProperty(message), HttpStatus.OK);
        } catch (VehicleException e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
        }
    }

    // Endpoint to update vehicle status by vehicle number
    @PutMapping("/ftr/vehicles/{vehicleNumber}")
    public ResponseEntity<String> updateVehicleStatus( @PathVariable String vehicleNumber,  @RequestBody Map<String, Object> request) {
        try {
        	String vehicleStatus = (String) request.get("vehicleStatus");
            String message = vehicleServiceImpl.updateVehicleStatus(vehicleNumber,  vehicleStatus);
            return new ResponseEntity<>(environment.getProperty(message) + " " + vehicleStatus, HttpStatus.OK);
        }catch (VehicleException e) {
        	throw new ResponseStatusException(HttpStatus.BAD_REQUEST, environment.getProperty(e.getMessage()), e);
        }
    }
}
