package com.lld.parkinglot;

public class ExitParkingGate implements ParkingGate {

    ParkingLot parkingLot;

    public ExitParkingGate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public synchronized String vehicleArrived(Vehicle vehicle) {
        String vehicleNumber = vehicle.getVehicleNumber();
        parkingLot.updateParkingCollections(vehicleNumber, vehicle.getVehicleTimeInMinutes() * ParkingFees.parkingFees.get(vehicle.getVehicleType()));
        parkingLot.freeParkingSpace(vehicleNumber);
        return vehicleNumber + " leaving ParkingLot";
    }
}
