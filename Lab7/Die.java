/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 7 - Battle Simulator 3000
 * Name: Stuart Harley
 * Created: 10/11/18
 */

package harleys;

/**
 * Creates a Die object with a variable number of sides which can be rolled
 */
public class Die {

    private int numSides;
    private int currentValue;

    /**
     * Constructs a Die object with a numSides between 2 and 100. If a value outside
     * this range is attempted, the numSides is set to 6. The current value is set
     * as a random number between 1 and numSides.
     * @param numSides number of sides of the die
     */
    public Die(int numSides){
        if(numSides<2 || numSides>100) {
            this.numSides = 6;
        } else{
            this.numSides = numSides;
        }
        currentValue = (int)(Math.random()*this.numSides+1);
    }

    public int getCurrentValue(){
        return currentValue;
    }

    /**
     * Generates a random number between 1 and numSides representing a die roll
     */
    public void roll(){
        currentValue = (int)(Math.random()*numSides+1);
    }
}
