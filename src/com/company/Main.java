package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //declaring variables
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        //introduces a scanner for user input and
        //assigns the float number type to input
        Scanner scanner = new Scanner(System.in);
        float principal;
        float annualInterest;
        float periodYrs;

        //while loop to accept user input for Principal
        while (true) {
            System.out.print("Principal ($1K - $1M: ");
            principal = scanner.nextFloat();
            if (principal >= 1_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        //while loop to accept user input for Interest
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a number greater than 0 and less than or equal to 30.");
        }

        //while loop to accept user input for Years
        while (true) {
            System.out.print("Period (Years): ");
            periodYrs = scanner.nextFloat();
            if (periodYrs >= 1 && periodYrs <= 30)
                break;
            System.out.println("Enter a value between 1 and 30.");
        }

        //calculates Monthly Interest and Number of Payments
        //then places both into float containers
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
        float numberOfPayments = periodYrs * MONTHS_IN_YEAR;

        //formula for calculating the user's mortgage
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        //introduces currency format for the output
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(mortgage);

        //displays the user's calculated mortgage
        System.out.println("Mortgage: " + result);
    }
}
