package guess_game_lab;

import javax.swing.*;
import java.util.Random;

public class GuessGame {

    public int play(int max){
        Random random = new Random();
        int num = random.nextInt(max);
        int tryCount = 1;
        String guess = JOptionPane.showInputDialog("Input number between " + 0 + " and " + max);
        return guess(num, tryCount, Integer.parseInt(guess));
    }

    private int guess(int num, int tryCount, int guess){
        tryCount++;
        System.out.println("try = " + tryCount);

        if(guess > num){
            String again = JOptionPane.showInputDialog("Bigger than actual value! Try again.");
            guess(num, tryCount, Integer.parseInt(again));
        } else if (guess < num){
            String again = JOptionPane.showInputDialog("Smaller than actual value! Try again.");
            guess(num, tryCount, Integer.parseInt(again));
        }
        return tryCount;
    }

    public void printBestScore(String name, int result){
        JOptionPane.showInputDialog("Best result: " + name + " with score " + result);
    }
}
