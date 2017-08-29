package com.db.post;

public class Main {
    public static void main(String[] args) {
        FirstSubscriber firstSubscriber = new FirstSubscriber();

        BlogEngine blogEngine = new BlogEngine();
        blogEngine.subscribe(firstSubscriber);
        blogEngine.publishPost();
    }
}