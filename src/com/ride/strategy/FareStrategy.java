package com.ride.strategy;

import com.ride.dto.Vehicle;

public interface FareStrategy {

    double calcFare(Vehicle vehicle, int distance);
}
