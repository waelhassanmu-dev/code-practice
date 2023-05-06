package org.code.ch01;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TicketUtils {
    public static List<TicketHolder> importTicketHoldersFromCSV(String fileName) throws IOException, CsvValidationException {

        List<TicketHolder> ticketHolderList = new ArrayList<>();

        if (!fileName.endsWith(".csv")) {
            System.out.println("This is not a CSV file: " + fileName);
            return ticketHolderList;
        }
        File in = new File("src/main/resources/" + fileName);

        try (FileInputStream fis = new FileInputStream(in);
             InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
             CSVReader csvReader = new CSVReader(reader)) {

            csvReader.readNext();
            String[] row;
            while ((row = csvReader.readNext()) != null) {
                ticketHolderList.add(new TicketHolder(row[0].trim(), Integer.parseInt(row[1])));
            }
        }

        return ticketHolderList;
    }

    public static Optional<TicketHolder> findTicketHolder(String name, List<TicketHolder> ticketHoldersList) {

        return ticketHoldersList.stream()
                .filter(ticketHolder -> StringUtils.equalsIgnoreCase(name, ticketHolder.getName()))
                .findFirst();
    }

    public static boolean processTickets(TicketHolder ticketHolder, int numberInParty, List<TicketHolder> ticketHolderList) {

        int leftover = ticketHolder.getQuantity() - numberInParty;

        if (leftover < 0) {
            System.out.println("You don't have enough tickets for your whole party. You only have "+ ticketHolder.getQuantity());
            return false;
        }

        if (leftover != 0) {
            System.out.println("I see you still have more coming. I'm keeping your name on the list for them!");
            ticketHolder.setQuantity(leftover);
            return true;
        }

        ticketHolderList.remove(ticketHolder);
        return true;
    }

    public static void main(String[] args) {

        List<TicketHolder> ticketHoldersList = new ArrayList<>();

        try {
            ticketHoldersList.addAll(TicketUtils.importTicketHoldersFromCSV("ticket-holders.csv"));
        } catch (IOException | CsvValidationException e) {
            System.out.println(e);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the full name under the ticket?");
        String name = scanner.nextLine();

        Optional<TicketHolder> ticketHolderOpt = TicketUtils.findTicketHolder(name, ticketHoldersList);

        if (ticketHolderOpt.isEmpty()) {
            System.out.println("I can't let you in because I can't find your name");
            scanner.close();
            return;
        }

        System.out.println("How many are in your party?");
        int numberInParty = scanner.nextInt();
        scanner.close();

        TicketHolder ticketHolder = ticketHolderOpt.get();

        if (!TicketUtils.processTickets(ticketHolder,
                numberInParty, ticketHoldersList)) {
            System.out.println("I can't let your party in because you didn't buy enough tickets.");
            return;
        }

        System.out.println("Enjoy the show!");
    }
}
