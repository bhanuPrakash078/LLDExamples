package com.lld.parkinglot;

import java.util.Random;
import java.util.UUID;

public class Bike implements Vehicle {

    String bikeNumber;
    Double timeDuration;

    public Bike() {
        Random random = new Random();
        this.bikeNumber = UUID.randomUUID().toString();
        this.timeDuration = Double.valueOf(random.nextInt(30, 120));
    }

    @Override
    public String getVehicleNumber() {
        return this.bikeNumber;
    }

    @Override
    public Double getVehicleTimeInMinutes() {
        return this.timeDuration;
    }

    @Override
    public String getVehicleType() {
        return "bike";
    }
}
