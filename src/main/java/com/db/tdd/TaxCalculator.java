package com.db.tdd;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
public class TaxCalculator {
    NDSResolverImpl ndsResolver = new NDSResolverImpl();

    public double withNDS(double price){
        return price + price * ndsResolver.getNDS();
    }
}
