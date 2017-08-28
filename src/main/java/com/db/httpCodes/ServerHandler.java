package com.db.httpCodes;

public class ServerHandler implements HttpCodeHandler {
    public void handle(){
        System.out.println("Server Error message!");
    }
}
