package com.db.heroes;

public class Hobbit extends Character {

    public Hobbit() {
        setPower(0);
        setHp(3);
    }

    public void kick(Character enemy) {
        this.toCry();
    }

    private void toCry() {
        System.out.println(this.getHeroType() + " " + this.getName() + " say: Хнык-хнык...");
    }
}
