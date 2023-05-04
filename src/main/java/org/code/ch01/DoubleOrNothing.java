package org.code.ch01;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothing {

    private static final int POINTS = 10;

    private static final Random random = new Random();
    private DoubleOrNothing() {
        throw new IllegalStateException("utility class -> contains only static methods");
    }

    private static boolean userDecision() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("double or nothing? - press Y if [yes], and N if [no]");
            String userInput = input.nextLine();
            String firstLetter = String.valueOf(userInput.charAt(0));
            while (!firstLetter.equalsIgnoreCase("Y") && !firstLetter.equalsIgnoreCase("N")) {
                System.out.println("you pressed incorrect character - please press Y if [yes], and N if [no], or press Q to [quite]");
                userInput = input.nextLine();
                firstLetter = String.valueOf(userInput.charAt(0));
                if (firstLetter.equalsIgnoreCase("Q"))
                    System.exit(0);
            }
            return firstLetter.equalsIgnoreCase("Y");
        }

    }
    public static int play() {
        if (userDecision()) {
            int randomNum = random.nextInt(2);
            if (randomNum == 0)
                return 0;
            return POINTS * 2;
        }
        return POINTS;
    }

}
