package org.code.ch01;

import java.util.regex.Pattern;

public class PasswordPattern {

    private PasswordPattern() {
        throw new IllegalStateException("utility class -> contains only static methods");
    }
    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    private static final String WEAK_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
    private static final Pattern PATTERN = Pattern.compile(WEAK_PASSWORD_PATTERN);

    public static boolean isPasswordComplex(String password) {
        return PATTERN.matcher(password).matches();
    }

}
