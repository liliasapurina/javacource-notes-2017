package com.db.reflections;

import java.lang.reflect.Method;

public class ReflectionUtil {
    /*
    Только методы данного класса (не папы и дедушки)
     */
    public static void printMethods(Object o){
        Class<?> type = o.getClass();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /*
    Вообще все методы, но без приватных!
     */
    public static void printAllMethods(Object o){
        Class<?> type = o.getClass();
        Method[] methods = type.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /*
    Все все методы, включая private
     */
    public static void printAbsoluteAllMethods(Object o){
        Class<?> type = o.getClass();
        while(type != null){
            Method[] methods = type.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
            type = type.getSuperclass();
        }
    }

    public static void printIsInterface(Class type){
        if(type.isInterface()){
            System.out.println("Is Interface!");
        }
    }
}
