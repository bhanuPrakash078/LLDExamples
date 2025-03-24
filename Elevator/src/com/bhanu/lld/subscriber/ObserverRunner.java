package com.bhanu.lld.subscriber;

import java.util.concurrent.SubmissionPublisher;

public class ObserverRunner {

    public static void main(String[] args) {
        SubmissionPublisher<WeatherData> publisher = new SubmissionPublisher();
        WeatherObserver weatherObserver = new WeatherObserver();
        publisher.subscribe(weatherObserver);
        publisher.submit(new WeatherData("Cloudy"));
        publisher.submit(new WeatherData("Rainy"));
        publisher.submit(new WeatherData("Windy"));
        publisher.close();
    }
}
