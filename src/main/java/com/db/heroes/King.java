package com.db.heroes;

public class King extends Human {

    public King() {
        setHp(getRandomBetween(5, 15));
        setPower(getRandomBetween(5, 15));
    }
}
