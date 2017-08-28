package com.db.heroes;

public class Elf extends Character {

    public Elf() {
        setHp(10);
        setPower(10);
    }

    public void kick(Character enemy) {
        if (this.getPower() > enemy.getPower()) {
            enemy.setHp(0);
        } else {
            enemy.setPower(enemy.getPower() - 1);
        }
    }
}
