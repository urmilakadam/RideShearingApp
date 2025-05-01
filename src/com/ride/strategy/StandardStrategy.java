package com.ride.strategy;

import com.ride.dto.Vehicle;

public class StandardStrategy implements FareStrategy{

    @Override
    public double calcFare(Vehicle vehicle, int distance) {
        return vehicle.getFarePerKm(distance);
    }
}
