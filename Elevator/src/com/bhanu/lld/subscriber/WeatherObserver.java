package com.bhanu.lld.subscriber;

import java.util.concurrent.Flow;

public class WeatherObserver implements Flow.Subscriber<WeatherData> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(WeatherData item) {
        System.out.println("Item received is :: " + item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("The exception is :: " + throwable.getLocalizedMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("All items are completed");
    }
}
