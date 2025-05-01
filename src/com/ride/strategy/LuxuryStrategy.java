package com.ride.strategy;

import com.ride.dto.Vehicle;

public class LuxuryStrategy implements FareStrategy{
    @Override
    public double calcFare(Vehicle vehicle, int distance) {
        return vehicle.getFarePerKm(distance) * 1.5;
    }
}
