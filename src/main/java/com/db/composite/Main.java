package com.db.composite;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        Wardrobe wardrobe = new Wardrobe();
        Shell shell = new Shell();
        room.append(wardrobe);
        wardrobe.append(shell);
        System.out.println(room.calculatePrice());
    }
}
