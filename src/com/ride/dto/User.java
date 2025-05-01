package com.ride.dto;

public abstract class User {

    private final String name;
    private final String email;
    private final Location location;


    public User(String name, String email, Location location) {
        this.name = name;
        this.email = email;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Location getLocation() {
        return location;
    }
}
