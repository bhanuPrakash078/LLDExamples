package com.bhanu.lld.elevatorobservermodel;

import java.util.Observable;

public class ElevatorEvent extends Observable {

    private String eventType;
    private int targetFloor;
    private int sourceFloor;

    public ElevatorEvent(String eventType) {
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void setTargetFloor(int targetFloor) {
        this.targetFloor = targetFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    public void triggerEvent() {
        setChanged();
        notifyObservers(this);
    }
}
