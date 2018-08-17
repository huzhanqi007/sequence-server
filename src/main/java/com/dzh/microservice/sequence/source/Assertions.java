package com.dzh.microservice.sequence.source;

/**
 * Created by herbert on 2018/7/7.
 */
public class Assertions {
    public static <T> T notNull(String name, T value) {
        if(value == null) {
            throw new IllegalArgumentException(name + " can not be null");
        } else {
            return value;
        }
    }

    public static void isTrue(String name, boolean condition) {
        if(!condition) {
            throw new IllegalStateException("state should be: " + name);
        }
    }

    public static void isTrueArgument(String name, boolean condition) {
        if(!condition) {
            throw new IllegalArgumentException("state should be: " + name);
        }
    }
    private Assertions() {
    }
}
