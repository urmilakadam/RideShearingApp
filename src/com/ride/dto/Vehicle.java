package com.ride.dto;

public abstract class Vehicle {

    private final String num;

    public String getNum() {
        return num;
    }

    public Vehicle(String num){
        this.num = num;
    }

    public abstract double getFarePerKm(int distance);
}
