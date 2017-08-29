package com.db.post;

public class FirstSubscriber implements Subscriber {
    public void getMessage(String message) {
        System.out.println(this.getClass() + " get message: " + message);
    }
}
