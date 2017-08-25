package reflections;

import collections.Client;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ReflectionUtil.printAbsoluteAllMethods(client);
    }
}
