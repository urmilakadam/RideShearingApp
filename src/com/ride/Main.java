package com.ride;

import com.ride.dto.*;
import com.ride.service.RideShearingService;
import com.ride.strategy.LuxuryStrategy;
import com.ride.strategy.SharedFareStrategy;
import com.ride.strategy.StandardStrategy;

public class Main {
    public static void main(String[] args) {
        Location loc1 = new Location(12.9716, 77.5946);
        Location loc2 = new Location(12.9352, 77.6245);
        Location loc3 = new Location(13.0352, 77.6175);

        Vehicle car = new Car("AB123CD");
        Vehicle bike = new Bike("XY987Z");

        Driver driver1 = new Driver("Alice", "alice@rideshare.com", loc2, car);
        Driver driver2 = new Driver("Bob", "bob@rideshare.com", loc3, bike);

        Passenger passenger1 = new Passenger("John", "john@rideshare.com", loc1);

        RideShearingService rideShearingService = new RideShearingService();
        rideShearingService.addDriver(driver1);
        rideShearingService.addDriver(driver2);
        rideShearingService.requestRide(passenger1, 100, new SharedFareStrategy());
        rideShearingService.requestRide(passenger1, 50, new LuxuryStrategy());
        rideShearingService.requestRide(passenger1, 40, new StandardStrategy());

//        RideMatchingSystem rideMatchingSystem = new RideMatchingSystem();
//        rideMatchingSystem.addDriver(driver1);
//        rideMatchingSystem.addDriver(driver2);
//
//        rideMatchingSystem.requestRide(passenger1,10,new StandardFareStrategy());
    }
}