package com.bhanu.lld.simpleimpl;

import java.util.ArrayList;
import java.util.List;

public class FloorImpl implements Floor {

    int floorNumber;
    List<Elevator.Person> personList = new ArrayList<>();
    Elevator elevator;

    public FloorImpl(Elevator elevator, int floorNumber) {
        this.elevator = elevator;
        this.floorNumber = floorNumber;
    }

    public void addPerson(Elevator.Person person) {
        this.personList.add(person);
        requestElevator(person.getTargetFloor());
    }

    @Override
    public void requestElevator(int targetFloor) {
        System.out.println("HI i am in floor :: " + this.floorNumber);
        System.out.println("HI i am requesting the Elevator for floor :: " + targetFloor);
        if (elevator.getCurrentFloor() == floorNumber) {
            System.out.println("Elevator is already in the current floor :: " + this.floorNumber);
            elevator.move(targetFloor);
        } else {
            System.out.println("Elevator is not in the current floor, currently its coming to current floor");
            elevator.move(floorNumber);
            System.out.println("Elevator reached the current floor :: " + this.floorNumber);
            elevator.move(targetFloor);
        }
    }
}
