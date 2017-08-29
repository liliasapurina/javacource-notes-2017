package com.db.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeObject {
    double price;
    static List<CompositeObject> thingsList = new ArrayList<>();

    public double calculatePrice(){
        double result = this.getPrice();
        System.out.println(this.getClass());
        System.out.println(result);
        for (CompositeObject compositeObject : CompositeObject.thingsList) {
            result += compositeObject.getPrice();
            System.out.println(compositeObject.getClass());
            System.out.println(compositeObject.getPrice());
        }
        return result;
    }

    public void append(CompositeObject o){
        thingsList.add(o);
    }

    public double getPrice() {
        return price;
    }
}
