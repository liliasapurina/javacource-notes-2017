package heroes;

import lombok.Data;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.Random;

@Data
public abstract class Character {
    private int power;
    private int hp;
    private String name;

    public Character(){
        DataFactory dataFactory = new DataFactory();
        name = dataFactory.getName() + " " + dataFactory.getLastName();
    }

    public abstract void kick(Character c);

    public boolean isAlive(){
        return hp > 0;
    }

    public int getRandomBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public String getHeroType() {
        return this.getClass().getSimpleName();
    }
}
