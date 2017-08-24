package sortedClients;

import lombok.Data;

@Data
public class Client {
    String name;
    int bonus;

    public Client(String name, int bonus){
        this.name = name;
        this.bonus = bonus;
    }
}
