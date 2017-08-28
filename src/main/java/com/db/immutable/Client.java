package com.db.immutable;

import lombok.Getter;
import lombok.ToString;

/**
 * Дизайн паттерн Builder
 */

@ToString
@Getter
final public class Client {
    final private String name;
    final private int bonus;
    final private int debt;

    private Client(String name, int bonus, int debt) {
        this.name = name;
        this.bonus = bonus;
        this.debt = debt;
    }

    public Client addBonus(int inc){
        return new Client(name, bonus + inc, debt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private String name;
        private int bonus;
        private int debt;

        private boolean alreadyUsed = false;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setBonus(int bonus) {
            this.bonus = bonus;
            return this;
        }

        public Builder setDebt(int debt) {
            this.debt = debt;
            return this;
        }

        public Client build(){
            validate();
            alreadyUsed = true;
            return new Client(name, bonus, debt);
        }

        public void validate() {
            if(alreadyUsed){
                throw new Error("Builder closed!");
            }

            if(name.isEmpty()){
                throw new Error("Name can't be NULL!");
            }
        }
    }
}
