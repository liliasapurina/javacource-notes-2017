package sortedClients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Lilia", 1);
        ArrayList<Client> clientList = new ArrayList<Client>();
        clientList.add(new Client("Lilia", 10));
        clientList.add(new Client("Vasya", 8));
        printSortedClients(clientList);
    }

    public static void printSortedClients(ArrayList<Client> clientArray) {
        Collections.sort(clientArray, new Comparator<Client>() {
            @Override
            public int compare(final Client object1, final Client object2) {
                return (object1.getBonus() > object2.getBonus()) ? object1.getBonus() : object2.getBonus();
            }
        });
        System.out.println(clientArray);
    }
}
