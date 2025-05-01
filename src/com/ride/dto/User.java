package com.ride.dto;

public abstract class User {

    private final String name;
    private final Location location;

    public User(String name, String email, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public abstract void notify(String msg);
}
