package reflections;

import collections.Client;

import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ReflectionUtil.printAbsoluteAllMethods(client);
    }
}
