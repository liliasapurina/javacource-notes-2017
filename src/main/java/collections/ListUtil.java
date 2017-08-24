package collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Evegeny on 24/08/2017.
 */
public class ListUtil {

    public static void removeClientByName(List<Client> clients, String name) {
        int i = 0;
        while (i < clients.size()) {
            if(clients.get(i).getName().equals(name)){
                System.out.println(clients.get(i));
                clients.remove(i);
            }
            i++;
        }
        // Оптимизация: итаратор или обычный цикл с конца
        // В Java 8 вообще красиво: clients.removeIf(client -> client.getName().equalsIgnoreCase(name));
    }

    public  static void printSorted(List<? extends Comparable> list) {
        Collections.sort(list);
        for (Comparable element : list) {
            System.out.println(element);
        }
    }


    public static <T> void printSorted(List<T> list, Comparator<T> comparator) {
        Collections.sort(list,comparator);
        for (T element : list) {
            System.out.println(element);
        }
    }
}













