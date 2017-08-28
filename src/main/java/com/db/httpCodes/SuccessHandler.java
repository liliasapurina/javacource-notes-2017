package com.db.httpCodes;

public class SuccessHandler implements HttpCodeHandler {
    public void handle(){
        System.out.println("Success message!");
    }
}
