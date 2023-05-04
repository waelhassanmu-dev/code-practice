package org.code.ch01;

public class EvenNumber {

    private EvenNumber() {
        throw new IllegalStateException("utility class -> contains only static methods");
    }
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

}
