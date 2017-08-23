package heroes;

public abstract class Human extends Character {
    public void kick(Character enemy) {
        enemy.setHp(enemy.getHp() - getRandomBetween(0, this.getPower()));
    }
}
