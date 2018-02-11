package com.example.java;
import java.util.Scanner;
import java.text.NumberFormat;

public class Main {


    public static void main(String[] args) {

        double user_total = 0;
        Scanner scanner = new Scanner(System.in);
        //setting up loop that will run indefinetely unless user gives bad data
        while (user_total >= 0) {
            System.out.println("Enter the cost of your item in USD. Enter 0 to checkout");

            double price = scanner.nextDouble();

            if (price == 0) {
                calc_total(user_total);
                return;
            } else {
                user_total += price;

            }

        }
    }
    private static void calc_total(double total) {
        double tax_rate = 0.025;
        double total_tax = total * tax_rate;
        double total_with_tax = total + total_tax;
        double total_tip = total_with_tax * 0.175;
        String totalout;    //strings will be used for printing of total in proper currency form
        String usertotal_;
        String taxtotal;
        String tip_format;


        NumberFormat nF = NumberFormat.getNumberInstance();
        nF.setGroupingUsed(true);  //puts a comma every 3 digits
        nF.setMaximumFractionDigits(2); //max and min number of decimal places set to 2
        nF.setMinimumFractionDigits(2);
        totalout = nF.format(total_with_tax);
        usertotal_ = nF.format(total);
        taxtotal = nF.format(total_tax);
        tip_format = nF.format(total_tip);

        System.out.println("The total cost of the items was:  $" + usertotal_);
        System.out.println();
        System.out.println("The total cost of taxes was:  $" + taxtotal);
        System.out.println();
        System.out.println("The total amount due is:  $" + totalout);
        System.out.println();
        System.out.println("A tip would be greatly appreciated. With your total a tip of 17.5% would be $" + tip_format);
    }
}