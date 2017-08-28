package com.db.arrayList;

public class Main {
    public static void main(String[] args) {
        SimpleArrayList<String> simpleArrayList = new SimpleArrayList<String>();
        simpleArrayList.add("One");
        simpleArrayList.add("Two");
        simpleArrayList.add("Three");

        System.out.println(simpleArrayList.isEmpty());

        System.out.println(simpleArrayList.get(1));
        System.out.println(simpleArrayList.get(2));
        simpleArrayList.remove(2);
        System.out.println(simpleArrayList.get(2));
        System.out.println(simpleArrayList.contains("One1"));
        System.out.println("Size = " + simpleArrayList.size());
        simpleArrayList.clear();
        System.out.println(simpleArrayList.size());
    }
}
