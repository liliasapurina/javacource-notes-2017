package com.db.exampleGenerator;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ExpressionGenerator expressionGenerator = new ExpressionByTemplate();

        int reply = 0;

        while (reply == JOptionPane.YES_OPTION){
            String expression = expressionGenerator.generateExpression();
            String answer = JOptionPane.showInputDialog(expression + " =");

            double expectedAnswer = expressionGenerator.getResult(expression);
            if(Double.valueOf(answer) == expectedAnswer){
                reply = JOptionPane.showConfirmDialog(null, "Верно. Молодец! Ещё пример?", "", JOptionPane.YES_NO_OPTION);
            } else {
                reply = JOptionPane.showConfirmDialog(null, "Не верно. Ответ: " + expectedAnswer + " Ещё пример?", "", JOptionPane.YES_NO_OPTION);
            }
        }
    }
}
