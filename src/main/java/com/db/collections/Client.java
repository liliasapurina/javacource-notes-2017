package com.db.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Evegeny on 24/08/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Comparable<Client> {
    private String name;
    private int bonus;

    @Override
    public int compareTo(Client o) {
        return this.getName().compareTo(o.getName());
    }
}







