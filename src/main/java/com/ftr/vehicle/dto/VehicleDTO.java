package com.ftr.vehicle.dto;



import java.util.Date;




public class VehicleDTO {

    private String vehicleNumber;
    private String vehicleName;
    private Double maxLiftingCapacity;
    private Date retireDate;
    private String vehicleStatus;
    private String harborLocation;
    private String country;

    // Getters and Setters

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setMaxLiftingCapacity(Double maxLiftingCapacity) {
        this.maxLiftingCapacity = maxLiftingCapacity;
    }

    public void setRetireDate(Date retireDate) {
        this.retireDate = retireDate;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public void setHarborLocation(String harborLocation) {
        this.harborLocation = harborLocation;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public Double getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    public Date getRetireDate() {
        return retireDate;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public String getHarborLocation() {
        return harborLocation;
    }

    public String getCountry() {
        return country;
    }
}
