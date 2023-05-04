package org.code.ch01;


public class BillCalculator {

    private static final double MINIMUM_CHARGER = 18.84; // for two CCFs [1496 gallons]
    private static final double ADDITIONAL_CHARGER = 3.90; // per CCF
    private static final double MINIMUM_GALLONS = 1496;
    private static final double CCF = 748;

    public static double calculateBill(double gallonsUsage) {

        if (gallonsUsage <= MINIMUM_GALLONS)
            return MINIMUM_CHARGER;

        double additionalNumberOfGallons = gallonsUsage - MINIMUM_GALLONS;

        int numberOfCCF = (int) (additionalNumberOfGallons / CCF);
        int reminderNumberOfCCF = (int) (additionalNumberOfGallons % CCF);
        numberOfCCF = reminderNumberOfCCF > 0 ? numberOfCCF + 1 : numberOfCCF;

        return MINIMUM_CHARGER + (numberOfCCF * ADDITIONAL_CHARGER);
    }

    public static double calculateBillUsingMath(double gallonsUsage) {

        if (gallonsUsage <= MINIMUM_GALLONS)
            return MINIMUM_CHARGER;

        double additionalNumberOfGallons = gallonsUsage - MINIMUM_GALLONS;

        double extraAmount = Math.ceil(additionalNumberOfGallons/CCF) * ADDITIONAL_CHARGER;

        return MINIMUM_CHARGER + extraAmount;
    }

}
