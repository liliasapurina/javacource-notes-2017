package com.db.mySpring;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lilia on 30.08.17.
 */
@Retention(RUNTIME)
public @interface Component {
    Scope scope() default Scope.SINGLETON;
}
