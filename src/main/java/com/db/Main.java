package com.db;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(12);
        System.out.println(person.getAge());

        double nums[] = {1.0, 2.3, 3.3};
        doubleToInt(nums);
    }

    private static void doubleToInt(double nums[]){
        Arrays.stream(nums).forEach(s -> {
            if(s == (int) s){
                System.out.println((int) s);
            }else{
                System.out.println(s);
            }
        });
    }
}