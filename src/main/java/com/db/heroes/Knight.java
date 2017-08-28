package com.db.heroes;

public class Knight extends Human {
    public Knight() {
        setHp(getRandomBetween(2, 12));
        setPower(getRandomBetween(2, 12));
    }
}
