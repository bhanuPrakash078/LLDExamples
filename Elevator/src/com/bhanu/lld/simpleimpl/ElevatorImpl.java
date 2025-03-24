package com.bhanu.lld.simpleimpl;

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
            Thread.sleep(Math.abs(targetFloor - currentFloor) * 3000);
        } catch (Exception e) {
            System.err.println("I am crashed");
        }
        this.currentFloor=targetFloor;
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

}
