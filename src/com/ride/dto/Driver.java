package com.ride.dto;

public class Driver extends User{

    private final Vehicle vehicle;
    private Status status;

    public Driver(String name, String email, Location location, Vehicle vehicle) {
        super(name, email, location);
        this.vehicle = vehicle;
        this.status = Status.AVAILABLE;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void notify(String msg) {
        System.out.println("Driver: " + msg);
    }
}
