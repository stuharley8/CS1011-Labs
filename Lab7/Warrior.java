/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 7 - Battle Simulator 3000
 * Name: Stuart Harley
 * Created: 10/11/18
 */

package harleys;

/**
 * The warrior is the player controlled character that fights the Mugwump.
 * It has two possible attacks it can use.
 */
public class Warrior {

    private int hitPoints;
    private Die d20;
    private Die d10;
    private Die d8;
    private Die d4;

    /**
     * Creates a Warrior with 4 dice of 20, 10, 8, and 4 number of sides. Also
     * generates the hitpoints using the rollHitPoints method.
     */
    public Warrior() {
        d20 = new Die(20);
        d10 = new Die(10);
        d8 = new Die(8);
        d4 = new Die(4);
        hitPoints = this.rollHitPoints();
    }

    public int getHitPoints(){
        return hitPoints;
    }

    /**
     * Subtracts hp from hitPoints to simulate taking damage from an attack
     * @param hp number of hit points to take off
     */
    public void takeDamage(int hp){
        hitPoints -= hp;
        if(hitPoints < 0){
            hitPoints = 0;
        }
    }

    /**
     * Simulates an attack from the Warrior. Depending on the input the Warrior can
     * use one of two attacks, the Trusty Sword or the Shield of Light. It then
     * rolls the appropriate dice to determine if the attack hits/misses, and then how
     * much damage it will do if it hits.
     * @param type the type of attack, 1 for Trusty Sword, 2 for Shield of Light
     * @return the attackDamage inflicted, 0 if none
     */
    public int attack(int type){
        int attackDamage = 0;
        if(type==1){
            d20.roll();
            if(d20.getCurrentValue()>=12){
                d8.roll();
                attackDamage += d8.getCurrentValue();
                d8.roll();
                attackDamage += d8.getCurrentValue();
            }
        } else if(type==2){
            d20.roll();
            if(d20.getCurrentValue()>=8){
                d4.roll();
                attackDamage += d4.getCurrentValue();
            }
        }
        return attackDamage;
    }

    private int rollHitPoints(){
        for (int i = 0; i < 6; i++){
            d10.roll();
            hitPoints += d10.getCurrentValue();
        }
        return hitPoints;
    }
}
