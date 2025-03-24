package com.lld.parkinglot;

import java.util.Random;
import java.util.UUID;

public class Car implements Vehicle {

    String carNumber;
    Double timeDuration;

    public Car() {
        Random random = new Random();
        this.carNumber = UUID.randomUUID().toString();
        this.timeDuration = Double.valueOf(random.nextInt(30, 360));
    }

    @Override
    public String getVehicleNumber() {
        return this.carNumber;
    }

    @Override
    public Double getVehicleTimeInMinutes() {
        return this.timeDuration;
    }

    @Override
    public String getVehicleType() {
        return "car";
    }
}
