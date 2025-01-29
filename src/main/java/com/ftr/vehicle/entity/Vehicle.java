package com.ftr.vehicle.entity;

import java.time.LocalDate;

import com.ftr.vehicle.dto.VehicleDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "ftr_vehicles")

public class Vehicle {

    @Id
    @Column(name = "vehicle_number")
    private String vehicleNumber;

    @Column(name = "vehicle_name")
    private String vehicleName;

    @Column(name = "max_lifting_capacity")
    private Double maxLiftingCapacity;

    @Column(name = "retire_date")
    private LocalDate retireDate;

    @Column(name = "vehicle_status")
    private String vehicleStatus;

    @Column(name = "harbor_location")
    private String harborLocation;

    @Column(name = "country")
    private String country;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Double getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    public void setMaxLiftingCapacity(Double maxLiftingCapacity) {
        this.maxLiftingCapacity = maxLiftingCapacity;
    }

    public LocalDate getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(LocalDate retireDate) {
        this.retireDate = retireDate;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getHarborLocation() {
        return harborLocation;
    }

    public void setHarborLocation(String harborLocation) {
        this.harborLocation = harborLocation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Getters and Setters


}
