package com.db.mySpring;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ObjectWithScope <T> {
    private final Scope scope;
    private final Class<T> type;
    @Setter
    private T object;

    public ObjectWithScope(Scope scope, Class<T> type) {
        this.scope = scope;
        this.type = type;
        if (scope == Scope.SINGLETON) {
            object = ObjectFactory.getInstance().createObject(type);
        }
    }
}
