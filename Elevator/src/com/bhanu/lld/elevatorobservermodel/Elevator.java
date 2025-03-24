package com.bhanu.lld.elevatorobservermodel;

import java.util.Observer;

public interface Elevator extends Observer {
    void move(int targetFloor);

    int getCurrentFloor();

    void setCurrentFloor(int currentFloor);

}
