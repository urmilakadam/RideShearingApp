package com.ride.dto;

public class Bike extends Vehicle{
    public Bike(String number) {
        super(number);
    }

    @Override
    public double getFarePerKm(int distance) {
        return distance * 10;
    }
}
