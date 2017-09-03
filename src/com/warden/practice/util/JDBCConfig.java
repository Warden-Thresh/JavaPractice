package com.warden.practice.util;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD, ElementType.TYPE,})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface JDBCConfig {
    String ip();

    int port() default 3306;

    String database();

    String encoding();

    String loginName();

    String password();
}
