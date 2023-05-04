package org.code.ch01;

import java.util.Scanner;

public class BillCalculator {

    private static final double MINIMUM_CHARGER = 18.84; // for two CCFs [1496 gallons]
    private static final double ADDITIONAL_CHARGER = 3.90; // per CCF
    private static final double MINIMUM_GALLONS = 1496;
    private static final double CCF = 748;

    public static double calculateWaterBill(double gallonsUsage) {
        if (gallonsUsage <= MINIMUM_GALLONS)
            return MINIMUM_CHARGER;

        double additionalNumberOfGallons = gallonsUsage - MINIMUM_GALLONS;

        int numberOfCCF = (int) (additionalNumberOfGallons / CCF);
        int reminderNumberOfCCF = (int) (additionalNumberOfGallons % CCF);
        numberOfCCF = reminderNumberOfCCF > 0 ? numberOfCCF + 1 : numberOfCCF;

        return MINIMUM_CHARGER + (numberOfCCF * ADDITIONAL_CHARGER);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " + calculateWaterBill(usage));
        scanner.close();
    }
}
