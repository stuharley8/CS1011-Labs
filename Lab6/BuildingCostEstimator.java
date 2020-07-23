/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 6 - First Program
 * Name: Stuart Harley
 * Created: 10/11/18
 */

package harleys;

/**
 * Creates the BuildingCostEstimator to calculate the cost of building a house
 */

public class BuildingCostEstimator {

    private static final int COST_PER_SQUARE_FOOT = 135;
    private static final int COST_PER_FULL_BATH = 15000;
    private static final int COST_PER_HALF_BATH = 7000;
    private static final int COST_PER_BED = 3000;
    private static final int COST_PER_WINDOW = 800;
    private static final int COST_PER_GARAGE = 8000;

    private int sqFeet;
    private int numFullBaths;
    private int numHalfBaths;
    private int numBeds;
    private int numWindows;
    private double numGarages;

    public void setSquareFeet(int sqFeet) {
        this.sqFeet = sqFeet;
    }

    public void setNumFullBaths(int numFullBaths) {
        this.numFullBaths = numFullBaths;
    }

    public void setNumHalfBaths(int numHalfBaths) {
        this.numHalfBaths = numHalfBaths;
    }

    public void setNumBedrooms(int numBeds) {
        this.numBeds = numBeds;
    }

    public void setNumWindows(int numWindows) {
        this.numWindows = numWindows;
    }

    public void setNumGarages(double numGarages) {
        this.numGarages = numGarages;
    }

    public double getNumGarages() {
        return numGarages;
    }

    public int getNumFullBaths() {
        return numFullBaths;
    }

    public int getNumHalfBaths() {
        return numHalfBaths;
    }

    public int getNumBedrooms() {
        return numBeds;
    }

    public int getNumWindows() {
        return numWindows;
    }

    public int getSquareFeet() {
        return sqFeet;
    }

    /**
     * Calculates the cost of building a house
     * @return cost of building a house
     */
    public double costToBuild(){
        double totalCost = 0;
        totalCost += sqFeet*COST_PER_SQUARE_FOOT;
        totalCost += numFullBaths*COST_PER_FULL_BATH;
        totalCost += numHalfBaths*COST_PER_HALF_BATH;
        totalCost += numBeds*COST_PER_BED;
        totalCost += numWindows*COST_PER_WINDOW;
        totalCost += numGarages*COST_PER_GARAGE;
        return totalCost;
    }
}
