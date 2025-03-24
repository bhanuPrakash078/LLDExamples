package com.bhanu.lld.elevatorobservermodel;

import java.util.Observable;

public class ElevatorImpl implements Elevator {

    public int currentFloor;
    public boolean elevatorMoving;

    public ElevatorImpl() {
        this.currentFloor = 0;
        this.elevatorMoving = false;
    }

    @Override
    public void move(int targetFloor) {
        try {
            System.out.println("The Elevator is moving.....");
            Thread.sleep(Math.abs(targetFloor - currentFloor));
        } catch (Exception e) {
            System.err.println("I am crashed");
        }
        this.currentFloor = targetFloor;
        System.out.println("Elevator reached the targetFloor :: " + targetFloor);
    }

    @Override
    public int getCurrentFloor() {
        return this.currentFloor;
    }

    @Override
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public void update(Observable o, Object arg) {
        listenForEvents((ElevatorEvent) arg);
    }

    public void listenForEvents(ElevatorEvent elevatorEvent) {
        switch (elevatorEvent.getEventType()) {
            case "REQUEST_LIFT":
                int targetFloor = elevatorEvent.getTargetFloor();
                System.out.println("The current floor of elevator is " + currentFloor);
                System.out.println("The target floor for Elevator is " + elevatorEvent.getTargetFloor());
                System.out.println("The Elevator is requested from " + elevatorEvent.getSourceFloor());
                try {
                    System.out.println("The Elevator is moving.....");
                    Thread.sleep(Math.abs(targetFloor - currentFloor) * 1000);
                } catch (Exception e) {
                    System.err.println("I am crashed");
                }
                this.currentFloor = targetFloor;
                System.out.println("Elevator reached the targetFloor :: " + targetFloor);
            default:
//                System.out.println("I am doing nothing");
        }
    }

}
