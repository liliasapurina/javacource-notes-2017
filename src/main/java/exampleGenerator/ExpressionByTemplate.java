package exampleGenerator;

import lombok.SneakyThrows;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionByTemplate implements ExpressionGenerator{
    private static final String TEMPLATE_FILENAME = "exercise.templates";
    private static final Pattern VARIABLES_PATTERN = Pattern.compile("\\d+[a-z]+");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d+");

    public int generateArgument(int digitNumber){
        int min = (int) Math.pow(10, digitNumber - 1);
        int max = (int) Math.pow(10, digitNumber) - 1;
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public String generateExpression(){
        String exerciseTemplate = getRandomTemplate(readTemplates());
        String variable;
        int digitNumber;
        Matcher variablesMatcher = VARIABLES_PATTERN.matcher(exerciseTemplate);
        Matcher digitMatcher;

        while (variablesMatcher.find()){
            variable = variablesMatcher.group();
            digitMatcher = DIGIT_PATTERN.matcher(variable);

            if(digitMatcher.find()){
                digitNumber = Integer.valueOf(digitMatcher.group());
                exerciseTemplate = variablesMatcher.replaceFirst(String.valueOf(generateArgument(digitNumber)));
            }

            variablesMatcher = VARIABLES_PATTERN.matcher(exerciseTemplate);
        }
        return exerciseTemplate;
    }

    public double getResult(String expression){
        Expression e = new ExpressionBuilder(expression)
                .build();
        return e.evaluate();
    }

    @SneakyThrows
    private ArrayList<String> readTemplates(){
        ArrayList<String> templates = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(ExpressionByTemplate.class.getResourceAsStream("/" + TEMPLATE_FILENAME)));
        String line;
        while ((line = reader.readLine()) != null) {
            templates.add(line);
        }

        return templates;
    }

    private String getRandomTemplate(ArrayList<String> templates){
        return templates.get(getRandomIndex(templates.size()));
    }

    private int getRandomIndex(int length){
        return (int) (Math.random() * length);
    }
}
