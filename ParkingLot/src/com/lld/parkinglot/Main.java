package com.lld.parkinglot;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("I am the beginning");
        ParkingLot parkingLot = new ParkingLot(200);
        EntranceParkingGate entranceParkingGate = new EntranceParkingGate(parkingLot);
        ExitParkingGate exitParkingGate = new ExitParkingGate(parkingLot);
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bike2 = new Bike();
        entranceParkingGate.vehicleArrived(car);
        entranceParkingGate.vehicleArrived(bike);
        exitParkingGate.vehicleArrived(bike);
        entranceParkingGate.vehicleArrived(bike2);

        Random random = new Random();
        Thread carThread = new Thread(()->{
            int i=0;
            while(i<50) {
                Vehicle carVar = new Car();
                entranceParkingGate.vehicleArrived(carVar);
                try {
                    Thread.sleep(random.nextInt(100,2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });

        Thread bikeThread = new Thread(()->{
            int i=0;
            while(i<50) {
                Vehicle bikeVar = new Bike();
                entranceParkingGate.vehicleArrived(bikeVar);
                try {
                    Thread.sleep(random.nextInt(100,1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        });

        Thread exitThread = new Thread(()-> {
            int i=0;
            while(i<30) {
                int size = parkingLot.freeParkingSpaces.size();
                Set<String> strings = parkingLot.parkingSpace.keySet();
                Optional<String> first = strings.stream().filter(s -> parkingLot.parkingSpace.get(s) != null).findFirst();
                if(first.isPresent()) {
                    Vehicle vehicle = parkingLot.parkingSpace.get(first.get());
                    if(null!=vehicle) {
                        exitParkingGate.vehicleArrived(vehicle);
                    }
                }
                try {
                    Thread.sleep(random.nextInt(100,1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }

        });
        carThread.start();
        bikeThread.start();
        exitThread.start();
        try {
            carThread.join();
            bikeThread.join();
            exitThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Map<String, Double> parkingCollected = parkingLot.parkingCollected;
        System.out.println(parkingCollected);
    }
}
