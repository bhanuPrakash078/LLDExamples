package com.bhanu.lld.elevatorobservermodel;

public class Person {
    int targetFloor;

    public Person(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public void personArrived(Floor floor) {
        ElevatorEvent elevatorEvent = new ElevatorEvent("PERSON_ARRIVED");
        elevatorEvent.setSourceFloor(floor.getFloorNumber());
        elevatorEvent.setTargetFloor(this.targetFloor);
        elevatorEvent.addObserver(floor);
        elevatorEvent.triggerEvent();
    }

    @Override
    public String toString() {
        return "Person {" +
                "targetFloor=" + targetFloor +
                '}';
    }
}
