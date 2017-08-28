package com.db.heroes;

public class GameManager {

    public void fight(Character c1, Character c2){
        while(true){
            if(c1.isAlive()){
                c1.kick(c2);
                System.out.println("-> " + c1.getHeroType() + " " +  c1.getName() + " (hp = " + c1.getHp() + ")" + " kicked " + c2.getHeroType() + " " +  c2.getName() + " (hp = " + c2.getHp() + ")");
            } else {
                System.out.println("\n" + c1.getHeroType() + " " +  c1.getName() + " was dead...");
                break;
            }

            if(c2.isAlive()){
                c2.kick(c1);
                System.out.println("-> " + c2.getHeroType() + " " +  c2.getName() + " (hp = " + c2.getHp() + ")" + " kicked " + c1.getHeroType() + " " +  c1.getName() + " (hp = " + c1.getHp() + ")");
            } else {
                System.out.println("\n" + c2.getHeroType() + " " + c2.getName() + " was dead...");
                break;
            }
        }
    }

}
