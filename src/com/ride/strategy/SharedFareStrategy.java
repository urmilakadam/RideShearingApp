package com.ride.strategy;

import com.ride.dto.Vehicle;

public class SharedFareStrategy implements FareStrategy{
    @Override
    public double calcFare(Vehicle vehicle, int distance) {
        return vehicle.getFarePerKm(distance) * 0.5;
    }
}
