package com.bhanu.lld.elevatorobservermodel;


import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class FloorImpl implements Floor {

    int floorNumber;
    List<Person> personList = new ArrayList<>();
    Elevator elevator;

    public FloorImpl(Elevator elevator, int floorNumber) {
        this.elevator = elevator;
        this.floorNumber = floorNumber;
    }

    public void addPerson(Person person) {
        this.personList.add(person);
        ElevatorEvent elevatorEvent = new ElevatorEvent("REQUEST_LIFT");
        elevatorEvent.addObserver(elevator);
        if (elevator.getCurrentFloor() == floorNumber) {
            System.out.println("Elevator is already in the current floor :: " + this.floorNumber);
        } else {
            System.out.println("Current floor of elevator is " + elevator.getCurrentFloor() + " currently its coming to current floor");
            elevatorEvent.setTargetFloor(floorNumber);
            elevatorEvent.triggerEvent();
        }
        elevatorEvent.setTargetFloor(person.getTargetFloor());
        elevatorEvent.setSourceFloor(this.floorNumber);
        elevatorEvent.triggerEvent();
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

    @Override
    public void update(Observable o, Object arg) {
        listenForEvents((ElevatorEvent) arg);
    }

    public void listenForEvents(ElevatorEvent elevatorEvent) {
        switch (elevatorEvent.getEventType()) {
            case "PERSON_ARRIVED":
                if (elevatorEvent.getSourceFloor() == this.floorNumber) {
                    addPerson(new Person(elevatorEvent.getTargetFloor()));
                }
            default:
//                System.out.println("I am doing nothing");
        }
    }

    public void getPersonList() {
        for (Person person : personList) {
            System.out.println("The person is :: " + person.toString());
        }
    }

    @Override
    public int getFloorNumber() {
        return this.floorNumber;
    }
}
