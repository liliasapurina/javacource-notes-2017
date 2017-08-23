package lombokBuilder;

public class Main {
    public static void main(String[] args) {
        Client client = Client.builder().name("Lilia").bonus(10).debt(0).beer("Жигулёвское").beer("Strongbow Dark Fruit").child("Ребенок").oneFish("Рыбка").build();
        System.out.println("Client" + client);
    }
}
