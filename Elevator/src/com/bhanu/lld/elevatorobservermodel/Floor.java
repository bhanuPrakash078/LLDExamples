package com.bhanu.lld.elevatorobservermodel;


import java.util.Observer;

public interface Floor extends Observer {

    void requestElevator(int targetFloor);

    void addPerson(Person person);

    void getPersonList();

    int getFloorNumber();
}
