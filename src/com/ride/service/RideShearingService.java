package com.ride.service;

import com.ride.dto.*;

import java.util.ArrayList;
import java.util.List;

public class RideShearingService {

    List<Driver> drivers = new ArrayList<>();
    List<Passenger> passengers = new ArrayList<>();

    public void addDriver(Driver driver){
        drivers.add(driver);
    }

    public void addClients(Passenger passenger){
        passengers.add(passenger);
    }

    public void bookRide(Passenger passenger, int distance){

        if(drivers.isEmpty()){
            System.out.println("No drivers available for a ride..!!");
            return;
        }

        double minDist = Double.MAX_VALUE;
        Driver assignDriver = null;

        for (Driver driver: drivers) {
            double currentDriverDist = driver.getLocation().calcDist(passenger.getLocation());
            if (driver.getStatus() == Status.AVAILABLE && minDist > currentDriverDist) {
                minDist = currentDriverDist;
                assignDriver = driver;
            }
        }
        drivers.remove(assignDriver);
        assert assignDriver != null;
        assignDriver.setStatus(Status.BOOKED);
        double fare = assignDriver.getVehicle().getFarePerKm(distance);
        System.out.println("Ride booked for "+ passenger.getName() + " with driver " + assignDriver.getName() +" for a fare of " + fare);
        System.out.println("Driver is on the way " + assignDriver.getName());
    }
}
