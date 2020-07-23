/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 10 - Lots of Parking Revisited
 * Name: Stuart Harley
 * Created: 11/5/18
 */

package parking;

import java.util.ArrayList;

/**
 * District class creates district object and class methods
 * @author [Stuart Harley]
 * <p/>
 * Capture usage information for parking lots in a district.
 */
public class District {

    /**
     * The max number of parking lots a district can contain
     */
    public static final int MAX_LOTS = 20;

    private ArrayList<ParkingLot> lots = new ArrayList<>();
    private int numLots;
    private int currentTime;

    /**
     * Adds a ParkingLot object to the lots array if numLots is less than MAX_LOTS
     * @param name the name of the new ParkingLot
     * @param capacity the capacity of the new Parkinglot
     * @return the index of the new lot or -1 if the lot was not added
     */
    public int addLot(String name, int capacity) {
        if (numLots < MAX_LOTS) {
            lots.add(new ParkingLot(name, capacity));
            numLots++;
        }
        return numLots-1<MAX_LOTS ? numLots-1 : -1;
    }

    /**
     * assumes a valid index is entered, return the parking lot at that index in lots
     * @param index an index less than MAX_LOTS
     * @return the parking lot at that index
     */
    public ParkingLot getLot(int index) {
        return lots.get(index);
    }

    /**
     * Record a vehicle entering a given lot at a given time.
     * @param lotNumber index of a parking lot in lots
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleEntry for the lot corresponding
     *                  to lotNumber.
     */
    public void markVehicleEntry(int lotNumber, int time) {
        getLot(lotNumber).markVehicleEntry(time);
        currentTime = getLot(lotNumber).getCurrentTime();
    }

    /**
     * Record a vehicle exiting a given lot at a given time.
     * @param lotNumber index of a parking lot in lots
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleExit for the lot corresponding
     *                  to lotNumber
     */
    public void markVehicleExit(int lotNumber, int time) {
        getLot(lotNumber).markVehicleExit(time);
        currentTime = getLot(lotNumber).getCurrentTime();
    }

    /**
     * Checks the status of all lots in the district and
     * returns true if they are all closed and false otherwise.
     * @return whether all lots are closed in the district
     */
    public boolean isClosed() {
        boolean allClosed = true;
        for(int i = 0; i<numLots; i++) {
            if(!getLot(i).isClosed()) {
                allClosed = false;
            }
        }
        return allClosed;
    }

    /**
     * Checks the status of all lots in the district at a certain time and
     * return true is they are all closed and false otherwise
     * @param time the time being checked
     * @return whether all lots are closed in the district at time
     */
    public boolean isClosed(int time) {
        boolean allClosed = true;
        for(int i = 0; i<numLots; i++) {
            if(!getLot(i).isClosed(time)) {
                allClosed = false;
            }
        }
        return allClosed;
    }

    /**
     * Computes the time all lots were reported as closed.
     *
     * @return number of minutes all lots were closed
     */
    public int closedMinutes() {
        int allClosed = 0;
        for (int i = 0; i<=currentTime; i++) {
            if(isClosed(i)) {
                allClosed++;
            }
        }
        return allClosed;
    }

    /**
     * Formats the information in the district so that is can be viewed
     * @return a String representing the status of the district
     */
    public String toString() {
        String status = "District status:\n";
        for (int i = 0; i<numLots; i++) {
            status += getLot(i).toString() + "\n";
        }
        return status;
    }

     /**
     * Determines the total number of vehicles parked in all of the parking lots in the district
     * @return total vehicles parked in all parking lots in lots
     */
    public int vehiclesParkedInDistrict() {
        int totalVehicles = 0;
        for (int i = 0; i<numLots; i++){
            totalVehicles += getLot(i).vehiclesInLot();
        }
        return totalVehicles;
    }
}
