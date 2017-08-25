package exampleGenerator;

import lombok.Data;

import java.util.Random;

@Data
public abstract class ExampleGenerator {
    Random random = new Random();

    private int getRandomBetween(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public int getArgument(int min, int max){
        return getRandomBetween(min, max);
    }

    public abstract ExampleGenerator generateExample(ExampleGenerator firstArgument, ExampleGenerator secondArgument);

    public abstract void result(ExampleGenerator example);
}
