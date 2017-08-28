package com.db.lombokBuilder;

import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Getter
@ToString
@Builder
// Добаляет переменную log для логирования
@Log4j
public class Client {
    // Поле name обязательное
    @NonNull
    final private String name;
    // Для того, чтобы эти поля были обязательны используем Integer, а не int
    final private Integer bonus;
    final private Integer debt;
    // Благодаря этой аннотации можно добавлять пиво по одному
    @Singular
    private List<String> beers;
    // Для слов, не оканчивающихся на s он смотрит в словарь и создает методы для добавления в единственном числе
    @Singular
    private List<String> children;
    // Можно указать вручную название метода
    @Singular("oneFish")
    private List<String> fishes;


    public Client addBonus(int inc){
        return new Client(name, bonus + inc, debt, beers, children, fishes);
    }
}
