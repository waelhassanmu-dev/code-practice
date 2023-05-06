package org.code.ch01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RedactTextTest {
    /**
     * Method under test: {@link RedactText#redactTextFile(String, String[])}
     */
    private File originalFile;
    private File redactedFile;
    private BufferedReader redactedFileReader;
    private BufferedReader originalFileReader;

    private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();

    @Before
    public void setUpEach() {
        System.setOut(new PrintStream(printOut));
    }

    @After
    public void cleanUpEach() {
        System.setOut(System.out);
    }

    @Test
    public void redactTextFile_ensureRedaction() {

        try {
            RedactText.redactTextFile("sample.txt",
                    new String[] { "sally", "Kat", "ready to go" });

            redactedFile = new File("redacted-sample.txt");
            redactedFileReader = new BufferedReader(
                    new FileReader(redactedFile));

            redactedFileReader.lines().forEach(line -> {
                assertFalse(line.contains("sally"));
                assertFalse(line.contains("Kat"));
                assertFalse(line.contains("ready to go"));
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void redactTextFile_ensureSameRemainingContents() {

        try {

            RedactText
                    .redactTextFile("sample.txt",
                            new String[] { "sally", "Kat",
                                    "ready to go" });

            originalFile = new File("sample.txt");
            originalFileReader = new BufferedReader(
                    new FileReader(originalFile));

            redactedFile = new File("redacted-sample.txt");
            redactedFileReader = new BufferedReader(
                    new FileReader(redactedFile));

            List<String> redactedLines = originalFileReader.lines()
                    .map(line -> line.replace("sally",
                                    "REDACTED")
                            .replace("kat",
                                    "REDACTED")
                            .replace("Kat",
                                    "REDACTED")
                            .replace("Sally",
                                    "REDACTED")
                            .replace("ready to go",
                                    "REDACTED"))
                    .collect(Collectors.toList());

            redactedLines.forEach(line -> {
                try {
                    assertEquals(line, redactedFileReader.readLine());
                } catch (IOException e) {
                    System.out.println("ERROR");
                }
            });

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    public void redactTextFile_ensureSameNumberOfLines() {

        try {
            RedactText.redactTextFile("sample.txt",
                    new String[] { "sally", "Kat" });

            originalFile = new File("sample.txt");
            originalFileReader = new BufferedReader(
                    new FileReader(originalFile));

            redactedFile = new File("redacted-sample.txt");
            redactedFileReader = new BufferedReader(
                    new FileReader(redactedFile));

            List<String> redactedLines = originalFileReader.lines()
                    .map(line -> line.replace("sally",
                                    "REDACTED")
                            .replace("kat",
                                    "REDACTED")
                            .replace("Kat",
                                    "REDACTED")
                            .replace("Sally",
                                    "REDACTED")
                            .replace("ready to go",
                                    "REDACTED"))
                    .collect(Collectors.toList());

            originalFileReader.reset();
            assertEquals(originalFileReader.lines().toArray().length,
                    redactedLines.size());

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}

