package com.bhanu.lld.elevatorobservermodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ElevatorObserverModelRunner {

    public static void main(String[] args) {
        Elevator elevator = new ElevatorImpl();
        List<Floor> floorList = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            Floor floorTemp = new FloorImpl(elevator, i);
            floorList.add(floorTemp);
        }
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Person personTemp = new Person(random.nextInt(31));
            personTemp.personArrived(floorList.get(random.nextInt(31)));
        }

    }
}
