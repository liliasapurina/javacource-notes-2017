package com.db.mySpring;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private static ApplicationContext ourInstance = new ApplicationContext("com.db");
    private final Map<Class, ObjectWithScope> components = new HashMap<>();

    public static ApplicationContext getInstance() {
        return ourInstance;
    }

    public ApplicationContext(String packageName) {
        Reflections scanner = new Reflections(packageName);
        scanner.getTypesAnnotatedWith(Component.class);
        for (Class component : scanner.getTypesAnnotatedWith(Component.class)) {
            Scope scope = ((Component) component.getAnnotation(Component.class)).scope();
            components.put(component, new ObjectWithScope(scope, component));
        }
    }

    public <T> T getComponent(Class<T> type) {
        ObjectWithScope<T> objectWithScope = components.get(type);
        if (objectWithScope != null) {
            switch (objectWithScope.getScope()) {
                case SINGLETON:
                    return objectWithScope.getObject();
                case LAZY_SINGLETON:
                    return getLazySingleton(objectWithScope);
                case PROTOTYPE:
                    return ObjectFactory.getInstance().createObject(objectWithScope.getType());
            }
        }
        return null;
    }

    private <T> T getLazySingleton(ObjectWithScope<T> objectWithScope) {
        if (objectWithScope.getObject() == null) {
            objectWithScope.setObject(ObjectFactory.getInstance().createObject(objectWithScope.getType()));
        }
        return objectWithScope.getObject();
    }
}
