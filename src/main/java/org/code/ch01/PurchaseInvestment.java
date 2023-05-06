package org.code.ch01;

import java.util.List;

public class PurchaseInvestment {

    public static double calculateAverageChangeInvested(List<Double> purchases) {
        double sum = 0;
        for (Double amount: purchases) {
            double invested = Math.ceil(amount) - amount;
            sum = sum + invested;
        }
        return sum / purchases.size();
    }

    public static double calculateAverageChangeInvestedV2(List<Double> purchases) {
       return purchases.stream().mapToDouble(amount -> Math.ceil(amount) - amount).average().orElse(0d);
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
