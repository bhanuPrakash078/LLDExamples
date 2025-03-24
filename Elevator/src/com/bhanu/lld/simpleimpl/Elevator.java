package com.bhanu.lld.simpleimpl;

public interface Elevator {
    public void move(int targetFloor);

    int getCurrentFloor();

    void setCurrentFloor(int currentFloor);

    class Person {
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
    }
}
