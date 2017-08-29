package com.db.composite;

import lombok.Data;
import lombok.Getter;

@Getter
public class Room extends CompositeObject {
    private final double price = 100.00;
}
