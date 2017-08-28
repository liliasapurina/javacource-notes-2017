package com.db.httpCodes;

public class InformationalHandler implements HttpCodeHandler{
    public void handle(){
        System.out.println("Information message!");
    }
}