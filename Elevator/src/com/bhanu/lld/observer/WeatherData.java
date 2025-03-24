package com.bhanu.lld.observer;

import java.util.Observable;

public class WeatherData extends Observable {
    private String weather;

    public WeatherData() {

    }

    public void setWeather(String weather) {
        this.weather = weather;
        setChanged();
        notifyObservers(weather);
    }
}
