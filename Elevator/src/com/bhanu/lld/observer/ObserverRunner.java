package com.bhanu.lld.observer;

public class ObserverRunner {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        WeatherObserver observer1 = new WeatherObserver();
        WeatherObserver observer2 = new WeatherObserver();
        weatherData.addObserver(observer1);
        weatherData.addObserver(observer2);
        weatherData.setWeather("Sunny");
        weatherData.setWeather("Rainy");
    }
}
