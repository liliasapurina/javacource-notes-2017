package com.db.exampleGenerator;

public interface ExpressionGenerator {
    public int generateArgument(int digitNumber);

    public String generateExpression();

    public double getResult(String expression);
}
