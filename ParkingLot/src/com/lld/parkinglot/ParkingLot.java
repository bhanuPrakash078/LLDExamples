package com.lld.parkinglot;

import java.util.*;

public class ParkingLot {

    Map<String, Vehicle> parkingSpace;
    int parkingCapacity;
    List<String> freeParkingSpaces = new ArrayList<>();
    Map<String, Double> parkingCollected;

    public ParkingLot(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
        this.parkingSpace = new HashMap<>();
        for (int i = 0; i < parkingCapacity; i++) {
            String parkingId = UUID.randomUUID().toString();
            parkingSpace.put(parkingId, null);
            freeParkingSpaces.add(parkingId);
        }
        parkingCollected = new HashMap<>();
    }

    public boolean isParkingAvailable() {
        return null != freeParkingSpaces && freeParkingSpaces.size() > 0;
    }

    public synchronized void vehicleEntered(Vehicle vehicle) {
        String parkingId = freeParkingSpaces.remove(0);
        parkingSpace.put(parkingId, vehicle);
    }

    public synchronized void updateParkingCollections(String vehicleNumber, Double amountCollected) {
        this.parkingCollected.put(vehicleNumber, amountCollected);
    }

    public synchronized void freeParkingSpace(String vehicleNumber) {
        String freeParkingId = "";
        for (Map.Entry<String, Vehicle> entry : parkingSpace.entrySet()) {
            if (null!=entry.getValue() && entry.getValue().getVehicleNumber().equals(vehicleNumber)) {
                freeParkingId=entry.getKey();
            }
        }
        freeParkingSpaces.add(freeParkingId);
        parkingSpace.put(freeParkingId,null);
    }
}
