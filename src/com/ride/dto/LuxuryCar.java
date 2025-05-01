package com.ride.dto;

public class LuxuryCar extends Vehicle{

    public LuxuryCar(String number){
        super(number);
    }

    @Override
    public double getFarePerKm(int distance) {
        return distance * 50;
    }
}
