/*
 * Course: CS1011 - 081
 * Fall 2018
 * Lab 5 - Library Classes
 * Name: Stuart Harley
 * Created: 10/4/2018
 */

package harleys;

import java.util.Random;
import java.util.Scanner;

/**
 * Lab explores library classes
 */
public class Lab5 {

    public static void main(String[] args) {
        final String PI = (Math.PI*.1 + "");
        boolean goodInput;
        String goAgain = "y";
        Scanner in = new Scanner(System.in);
        while(goAgain.equals("y")) {
            System.out.print("\nEnter a number of randomly generated points to be used to estimate pi: ");
            String input = in.nextLine();
            do {
                goodInput = true;
                if (input.length() > 0) {
                    for (int i = 0; i < input.length(); i++) {
                        if (!Character.isDigit(input.charAt(i))) {
                            goodInput = false;
                        }
                    }
                } else {
                    goodInput = false;
                }
                if (!goodInput) {
                    System.out.print("Invalid entry, try again. ");
                    input = in.nextLine();
                }
            } while (!goodInput);
            int numPoints = Integer.parseInt(input);
            int numPointsUnder = 0;
            int numCorrectDigits = 0;
            Random random = new Random();
            for (int i = 0; i < numPoints; i++) {
                if ((Math.pow(random.nextDouble(), 2) + Math.pow(random.nextDouble(), 2)) <= 1) {
                    numPointsUnder++;
                }
            }
            double estimatedPi = (double) (numPointsUnder) / numPoints * 4;
            System.out.println("Pi was estimated to be " + estimatedPi + ".");
            String estimated = estimatedPi*.1 + "";
            while(PI.charAt(numCorrectDigits+2)==(estimated.charAt(numCorrectDigits+2))) {
                numCorrectDigits++;
            }
            System.out.println("You had the first " + numCorrectDigits + " digits correct.");
            System.out.print("Do you want to generate a new estimate for pi? (y or n): ");
            goAgain = in.nextLine();
            goAgain = goAgain.toLowerCase();
            while (!goAgain.equals("y") && !goAgain.equals("n")) {
                System.out.print("Invalid entry. Do you want to try again? (y or n): ");
                goAgain = in.nextLine();
            }
        }
    }
}