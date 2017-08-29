package com.db.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class CompositeObject {
    private double price;
    private List<CompositeObject> thingsList = new ArrayList<>();

    public double calculatePrice() {
        double result = getPrice();
        for (CompositeObject compositeObject : thingsList) {
            result += compositeObject.calculatePrice();
        }
        return result;
    }

    protected abstract double getPrice();

    public void append(CompositeObject o) {
        thingsList.add(o);
    }
}
