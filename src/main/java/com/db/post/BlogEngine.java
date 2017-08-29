package com.db.post;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class BlogEngine {
    List<Subscriber> subscriberList = new ArrayList<>();

    @SneakyThrows
    public void publishPost() {
        String message = "New post!";
        while(true){
            System.out.println(message);
            Thread.sleep(3000);
            sendMessageToSubscribers(message);
        }
    }

    public void sendMessageToSubscribers(String message) {
        for (Subscriber subscriber : subscriberList) {
            subscriber.getMessage(message);
        }
    }

    public void subscribe(Subscriber o) {
        subscriberList.add(o);
    }
}
