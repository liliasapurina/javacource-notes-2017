package com.db.never_use_switch;

public class DontCallMailGenerator implements MailGenerator {
    public void generate() {
        System.out.println("Don't call us we call you");
    }
}
