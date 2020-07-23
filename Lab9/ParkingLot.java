/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 9 - Lots of Parking
 * Name: Stuart Harley
 * Created: 11/1/18
 */

package parking;

import java.text.DecimalFormat;

/**
 * ParkingLot class creates parkingLot object and class methods
 * @author Stuart Harley
 */
public class ParkingLot {

    /**
     * If lot is %80 full it is determined to be closed so drivers do not waste gas
     * driving around. Drivers can ignore this and still enter
     */
    public static final double CLOSED_THRESHOLD = 80.0;
    private static final int SUPPORTED_MINUTES = 500;
    private static DecimalFormat formatter = new DecimalFormat("#.#");

    //Instance Variables
    private String name;
    private int capacity;
    private int vehiclesInLot;
    private int[] vehicleLog;
    private int currentTime;

    //Constructors

    /**
     * Creates a parking lot. Sets vehiclesInLot to 0. Creates a int array vehicleLog
     * where the starting value of each place is 0.
     * @param name the identification name
     * @param capacity the capacity of the lot
     */
    public ParkingLot(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        vehiclesInLot = 0;
        vehicleLog = new int[SUPPORTED_MINUTES];
        currentTime = 0;
    }

    /**
     * Creates a parking lot. Does not set a identification name. Sets vehiclesInLot to 0.
     * Creates a int array vehicleLog where the starting value of each place is 0.
     * @param capacity the capacity of the lot
     */
    public ParkingLot(int capacity){
        this("test", capacity);
    }

    //Methods
    public String getName(){
        return name;
    }

    public int getCurrentTime() {
        return currentTime;
    }

    /**
     * Represents a vehicle entering the parking lot. Checks to see if the current
     * time is valid. Checks to see if the parking lot is at capacity.
     * Adds 1 vehicle to vehiclesInLot. Sets values of vehicleLog at and after time
     * to vehiclesInLot.
     * @param time represents the time a vehicle enters
     */
    public void markVehicleEntry(int time){
        if(currentTime <= time) {
            currentTime = time;
            if (vehiclesInLot < capacity) {
                vehiclesInLot++;
                for(int i = time; i<SUPPORTED_MINUTES; i++) {
                    vehicleLog[i] = vehiclesInLot;
                }
            }
        }
    }

    /**
     * Represents a vehicle exiting the parking lot. Checks to see if the current
     * time is valid. Checks to see if the parking lot capacity is greater than 0.
     * Subtracts 1 vehicle from vehiclesInLot. Sets values of vehicleLog at and after
     * time to vehiclesInLot.
     * @param time represents the time a vehicle enters
     */
    public void markVehicleExit(int time){
        if (currentTime <= time) {
            currentTime = time;
            if (vehiclesInLot > 0) {
                vehiclesInLot--;
                for(int i = time; i<SUPPORTED_MINUTES; i++) {
                    vehicleLog[i] = vehiclesInLot;
                }
            }
        }
    }

    public int vehiclesInLot(){
        return vehiclesInLot;
    }

    /**
     * Checks to see if vehiclesInLot is greater than or equal to 80% of the capacity.
     * @return true if greater than or equal to 80%, false if less than 80%
     */
    public boolean isClosed(){
        return (vehiclesInLot >= capacity*CLOSED_THRESHOLD/100);
    }

    /**
     * Checks to see if vehiclesInLot is greater than or equal to 80% of the capacity
     * at a specific time.
     * @param time the time being checked
     * @return true if greater than or equal to 80%, false if less than 80%
     */
    public boolean isClosed(int time){
        boolean closed = false;
        if(vehicleLog[time] >= capacity*CLOSED_THRESHOLD/100) {
            closed = true;
        }
        return closed;
    }

    /**
     * Calculates the number of minutes the garage was closed. Checks the value of
     * vehicleLog at each minute. If that value is greater than or equal to 80% of the capacity
     * it adds 1 minute to minClosed.
     * @return minClosed
     */
    public int closedMinutes(){
        int minClosed = 0;
        double closedThreshold = capacity*CLOSED_THRESHOLD/100;
        for(int i = 0; i<SUPPORTED_MINUTES; i++){
            if (vehicleLog[i] >= closedThreshold) {
                minClosed++;
            }
        }
        return minClosed;
    }

    /**
     * Formats the information in a parking lot so it can be used
     * @return a string representing the status of the parking lot
     */
    public String toString(){
        String status = "Status for " + name + " parking lot: " + vehiclesInLot() + " vehicles (";
        if(this.isClosed()) {
            status += "CLOSED)";
        } else {
            status += formatter.format(vehiclesInLot*100.0/capacity) + "%)";
        }
        return status;
    }
}