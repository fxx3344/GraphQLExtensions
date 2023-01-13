package com.github.fxx3344;

import java.util.Collection;

import static java.lang.String.format;

/**
 * <p>Title: Assert</p>
 * <p>Description: 断言</p>
 *
 * @author xi.feng
 * @version V1.0
 * @date 2021/7/29
 */
public class Assert {
    public static <T> T assertNotNull(T object, String format, Object... args) {
        if (object != null) return object;
        throw new AssertException(format(format, args));
    }

    public static <T> T assertNotNull(T object) {
        if (object != null) return object;
        throw new AssertException("Object required to be not null");
    }

    public static <T> T assertOptionalNotNull(T object) {
        if (object != null) return object;
        throw new AssertException("返回类型Optional的方法，请使用Optional.empty()代替null");
    }

    public static <T> T assertArgNotNull(T object, String argName) {
        if (object != null) return object;
        throw new AssertException(format("%s can`t be null", argName));
    }

    public static <T> T assertNeverCalled() {
        throw new AssertException("Should never been called");
    }

    public static <T> T assertShouldNeverHappen(String format, Object... args) {
        throw new AssertException("Internal error: should never happen: " + format(format, args));
    }

    public static <T> T assertShouldNeverHappen() {
        throw new AssertException("Internal error: should never happen");
    }

    public static <T> Collection<T> assertNotEmpty(Collection<T> c, String format, Object... args) {
        if (c == null || c.isEmpty())
            throw new AssertException(format(format, args));
        return c;
    }

    public static void assertTrue(boolean condition, String format, Object... args) {
        if (condition) return;
        throw new AssertException(format(format, args));
    }

    private static final String invalidNameErrorMessage = "Name must be non-null, non-empty and match [_A-Za-z][_0-9A-Za-z]* - was '%s'";

    /**
     * Validates that the Lexical token name matches the current spec.
     * currently non null, non empty,
     *
     * @param name - the name to be validated.
     *
     * @return the name if valid, or AssertException if invalid.
     */
    public static String assertValidName(String name) {
        if (name != null && !name.isEmpty() && name.matches("[_A-Za-z][_0-9A-Za-z]*")) {
            return name;
        }
        throw new AssertException(String.format(invalidNameErrorMessage,name));
    }
}
