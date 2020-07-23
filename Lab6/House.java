/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 6 - First Program
 * Name: Dr. Chris Taylor
 * Created: 09/27/16
 * Modified: 10/01/18
 */

package harleys;

import java.util.Scanner;

/**
 * Makes use of the BuildingCostEstimator class to estimate the
 * cost of building a house based on the user's desires.
 *
 * @author Dr. Chris Taylor
 * @version 2018.10.01_2
 */
public class House {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BuildingCostEstimator estimator = new BuildingCostEstimator();
        System.out.println("This program will help you estimate the "
                + "cost of building a house.");
        System.out.println("For your desired house:");
        System.out.print("Enter the total number of square feet: ");
        String line = in.nextLine();
        int sqFeet = Integer.parseInt(line);
        estimator.setSquareFeet(sqFeet);
        System.out.print("Enter the number of full bathrooms: ");
        int numFullBaths = Integer.parseInt(in.nextLine());
        estimator.setNumFullBaths(numFullBaths);
        System.out.print("Enter the number of half bathrooms: ");
        line = in.nextLine();
        estimator.setNumHalfBaths(Integer.parseInt(line));
        System.out.print("Enter the number of bedrooms: ");
        int numBeds = Integer.parseInt(in.nextLine());
        estimator.setNumBedrooms(numBeds);
        System.out.print("Enter the number of windows: ");
        estimator.setNumWindows(Integer.parseInt(in.nextLine()));
        System.out.print("Enter the number of garage spaces (e.g., 2.5): ");
        line = in.nextLine();
        estimator.setNumGarages(Double.parseDouble(line));
        if(estimator.getNumGarages()<2.0) {
            System.out.println("We are in Wisconsin.");
            System.out.println("Perhaps you should reconsider the number of garage stalls.");
            System.out.print("Enter the number of garage spaces (e.g., 2.5): ");
            estimator.setNumGarages(Double.parseDouble(in.nextLine()));
        }

        // Display characteristics and cost of the house
        System.out.print("The cost of building this house with ");
        System.out.format("%d full baths, %d half baths,\n",
                estimator.getNumFullBaths(),
                estimator.getNumHalfBaths());
        System.out.format("%d bedrooms, %d windows,\n",
                estimator.getNumBedrooms(),
                estimator.getNumWindows());
        System.out.format("with a %f car garage and taking ",
                estimator.getNumGarages());
        System.out.format("up %d square feet\n",
                estimator.getSquareFeet());
        System.out.format("will take $%.2f to build.",
                estimator.costToBuild());
    }
}
