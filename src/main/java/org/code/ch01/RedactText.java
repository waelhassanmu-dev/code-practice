package org.code.ch01;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Scanner;

public class RedactText {

    public static void redactTextFile(String fileName, String[] redactedWordsArray) {
        if (!fileName.endsWith(".txt")) {
            System.out.println("This is not a text file.");
            return;
        }

        File in = new File("src/main/resources/in/" + fileName);
        File out = new File("src/main/resources/out/redacted-" + fileName);

        try (BufferedReader originalFileReader = new BufferedReader(new FileReader(in));
             BufferedWriter redactedFileWriter = new BufferedWriter(new FileWriter(out))){

            String currentLine = originalFileReader.readLine();

            while (currentLine != null) {
                for (String redactedWord : redactedWordsArray) {
                    currentLine = StringUtils.replaceIgnoreCase(currentLine, redactedWord, "REDACTED");
                }

                redactedFileWriter.append(currentLine).append("\n");
                currentLine = originalFileReader.readLine();
            }

        } catch (IOException e) {
            System.out.println("Trouble reading or writing to file" + e);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        redactTextFile(fileName, redactedWordsList);

        scanner.close();
    }
}
