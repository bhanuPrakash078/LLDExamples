package com.lld.parkinglot;

public class EntranceParkingGate implements ParkingGate {

    ParkingLot parkingLot;

    public EntranceParkingGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public synchronized String vehicleArrived(Vehicle vehicle) {
        if (parkingLot.isParkingAvailable()) {
            parkingLot.vehicleEntered(vehicle);
            return "Vehicle Entered Parking";
        }
        return "Parking Lot is full";
    }
}
