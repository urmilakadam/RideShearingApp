package com.ride.service;

import com.ride.dto.*;
import com.ride.strategy.FareStrategy;

import java.util.ArrayList;
import java.util.List;

public class RideShearingService {

    List<Driver> availableDrivers = new ArrayList<>();

    public void addDriver(Driver driver){
        availableDrivers.add(driver);
    }

    public void requestRide(Passenger passenger, int distance, FareStrategy fareStrategy){

        if(availableDrivers.isEmpty()){
            System.out.println("No drivers available for a ride..!!");
            return;
        }

        Driver assignDriver = findNearestDriver(passenger.getLocation());

        availableDrivers.remove(assignDriver);
        assignDriver.setStatus(Status.BOOKED);
        double fare = fareStrategy.calcFare(assignDriver.getVehicle(), distance);
        System.out.println("Ride booked for "+ passenger.getName() + " with driver " + assignDriver.getName() +" for a fare of " + fare);
        System.out.println("Driver is on the way " + assignDriver.getName());
    }

    private Driver findNearestDriver(Location passengerLocation){
        Driver assignedDriver = null;
        double minDist = Double.MAX_VALUE;

        for(Driver driver: availableDrivers){
            double distance = driver.getLocation().calcDist(passengerLocation);
            if(distance<minDist){
                minDist = distance;
                assignedDriver = driver;
            }
        }
        return assignedDriver;
    }
}
