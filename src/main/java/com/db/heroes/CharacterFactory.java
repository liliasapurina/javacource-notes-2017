package com.db.heroes;

import java.util.Random;

public class CharacterFactory {
    public Character createCharacter() {
        Random random = new Random();
        int characterId = random.nextInt(3);

        switch (characterId) {
            case 0:
                return new Hobbit();
            case 1:
                return new Elf();
            case 2:
                return new King();
            case 3:
                return new Knight();
        }
        return null;
    }
}
