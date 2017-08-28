package com.db.immutable;

public class Main {
    public static void main(String[] args) {
        Client client = Client.builder().setName("Lilia").setBonus(55).setDebt(0).build();
        client = client.addBonus(100);
        System.out.println("Client bonus = " +  client.getBonus());
    }
}
