package com.ride.dto;

public class Car extends Vehicle{

    public Car(String number) {
        super(number);
    }

    @Override
    public double getFarePerKm(int distance) {
        return distance * 20;
    }
}
