package guess_game_lab;

import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Score bestResult = new Score();
        bestResult.setResult(0);
        String name;
        GuessGame guessGame = new GuessGame();
        int gameResult;

        Random random = new Random();
        int max = random.nextInt(5);

        while (true) {
            name = JOptionPane.showInputDialog("Input your name");

            gameResult = guessGame.play(5);
            System.out.println("gameResult, " + gameResult);
            if (bestResult.getResult() == 0) {
                bestResult.setName(name);
                bestResult.setResult(gameResult);
            } else if (max / bestResult.getResult() < max / gameResult) {
                bestResult.setResult(gameResult);
                bestResult.setName(name);
            }
            guessGame.printBestScore(bestResult.getName(), bestResult.getResult());
        }
    }
}
