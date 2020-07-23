/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 8 - Parking
 * Name: Stuart Harley
 * Created: 10/25/18
 */

package parking;

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

    private String color;
    private int capacity;
    private int vehiclesInLot;
    private int[] vehicleLog;
    private int currentTime;

    /**
     * Creates a parking lot. Sets vehiclesInLot to 0. Creates a int array vehicleLog
     * where the starting value of each place is 0.
     * @param color the identification color
     * @param capacity the capacity of the lot
     */
    public ParkingLot(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        vehiclesInLot = 0;
        vehicleLog = new int[500];
        currentTime = 0;
    }

    /**
     * Creates a parking lot. Does not set a identification color. Sets vehiclesInLot to 0.
     * Creates a int array vehicleLog where the starting value of each place is 0.
     * @param capacity the capacity of the lot
     */
    public ParkingLot(int capacity){
        this("test", capacity);
    }

    public String getColor(){
        return color;
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
                for(int i=time; i<500; i++) {
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
                for(int i=time; i<500; i++) {
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
        for(int i = 0; i<500; i++){
            if (vehicleLog[i] >= closedThreshold) {
                minClosed++;
            }
        }
        return minClosed;
    }

    /**
     * Prints the % capacity of the parking lot to 1 decimal place or if it is closed.
     */
    public void displayStatus(){
        System.out.print(color + " parking lot status: ");
        if(this.isClosed()) {
            System.out.println("CLOSED");
        } else {
            System.out.format("%.1f", vehiclesInLot*100.0/capacity);
            System.out.println("%");
        }
    }
}