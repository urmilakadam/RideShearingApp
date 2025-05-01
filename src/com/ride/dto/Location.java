package com.ride.dto;

public class Location {

    private final double longitude;
    private final double latitude;

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double calcDist(Location location){
        double dx = this.latitude - location.latitude;
        double dy = this.longitude - location.longitude;
        return dx*dx + dy*dy;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
