package com.db.reflections;

import com.db.collections.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ReflectionUtil.printAbsoluteAllMethods(client);
    }
}
