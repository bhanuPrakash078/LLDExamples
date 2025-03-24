package com.bhanu.lld.simpleimpl;

public class SimpleImplRunner {

    public static void main(String[] args) {
        Elevator.Person person = new Elevator.Person(3);
        Elevator elevator = new ElevatorImpl();
        Floor groundFloor = new FloorImpl(elevator, 0);
        groundFloor.addPerson(person);

        Floor firstFloor = new FloorImpl(elevator, 1);
        Elevator.Person person1 = new Elevator.Person(3);
        firstFloor.addPerson(person1);

        Floor secondFloor = new FloorImpl(elevator, 2);
        Elevator.Person person2 = new Elevator.Person(3);
        secondFloor.addPerson(person2);

    }
}
