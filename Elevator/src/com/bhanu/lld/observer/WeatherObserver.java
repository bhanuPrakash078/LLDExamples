package com.bhanu.lld.observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("The argument os :: "+arg);
    }
}
