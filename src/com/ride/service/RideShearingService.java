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

        Driver nearestDriver = findNearestDriver(passenger.getLocation());

        availableDrivers.remove(nearestDriver);
        nearestDriver.setStatus(Status.BOOKED);

        double fare = fareStrategy.calcFare(nearestDriver.getVehicle(), distance);
        passenger.notify("Ride schedued with fare + Rs"+ fare);
        nearestDriver.notify("You have a new ride request for "+ fare);

        nearestDriver.setStatus(Status.ONGOING);

        nearestDriver.setStatus(Status.COMPLETED);
        availableDrivers.add(nearestDriver);

        nearestDriver.notify("You are available to accept new ride.");
        nearestDriver.setStatus(Status.AVAILABLE);
    }

    private Driver findNearestDriver(Location passengerLocation){
        Driver assignedDriver = null;
        double minDist = Double.MAX_VALUE;

        for(Driver driver : availableDrivers){
            double distance = driver.getLocation().calcDist(passengerLocation);
            if(driver.getStatus() == Status.AVAILABLE && distance<minDist){
                minDist = distance;
                assignedDriver = driver;
            }
        }
        return assignedDriver;
    }
}
