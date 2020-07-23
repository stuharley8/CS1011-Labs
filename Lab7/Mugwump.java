/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 7 - Battle Simulator 3000
 * Name: Stuart Harley
 * Created: 10/11/18
 */

package harleys;

/**
 *The Mugwump class acts as the enemy of the player and can attack and do damage
 * to the player (or miss the attack), or heal itself in a turn.
 */
public class Mugwump {

    private int hitPoints;
    private int maxHitPoints;
    private Die d100;
    private Die d20;
    private Die d10;
    private Die d6;

    /**
     * Creates a Mugwump with 4 dice of 100, 20, 10, and 6 number of sides. Also
     * generates the hitpoints using the rollHitPoints method.
     */
    public Mugwump(){
        d100 = new Die(100);
        d20 = new Die(20);
        d10 = new Die(10);
        d6 = new Die(6);
        hitPoints = this.rollHitPoints();
        maxHitPoints = hitPoints;
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
        if (hitPoints>maxHitPoints){
            hitPoints = maxHitPoints;
        } else if(hitPoints<0){
            hitPoints = 0;
        }
    }

    /**
     * Simulates an attack from the Mugwump. Using the ai method it generates an attack
     * type. 1 for Razor-Sharp Claws, 2 for Fangs of Death, 3 for Healing. It then
     * rolls the appropriate dice to determine if the attack hits/misses, and then how
     * much damage it will do if it hits.
     * @return the attackDamage inflicted or 0 for a miss or negative for healing.
     */
    public int attack(){
        int attackType = this.ai();
        int attackDamage = 0;
        if(attackType==1){
            d20.roll();
            if(d20.getCurrentValue()>=12){
                d6.roll();
                attackDamage += d6.getCurrentValue();
                d6.roll();
                attackDamage += d6.getCurrentValue();
            }
        } else if(attackType==2){
            d20.roll();
            if(d20.getCurrentValue()>=16){
                d6.roll();
                attackDamage += d6.getCurrentValue();
                d6.roll();
                attackDamage += d6.getCurrentValue();
                d6.roll();
                attackDamage += d6.getCurrentValue();
            }
        } else{
            d6.roll();
            attackDamage -= d6.getCurrentValue();
        }
        return attackDamage;
    }

    private int rollHitPoints(){
        for (int i = 0; i < 10; i++){
            d10.roll();
            hitPoints += d10.getCurrentValue();
        }
        maxHitPoints = hitPoints;
        return maxHitPoints;
    }

    private int ai(){
        d100.roll();
        if(d100.getCurrentValue()<=75){
            return 1;
        } else if(d100.getCurrentValue()<=90){
            return 2;
        } else{
            return 3;
        }
    }
}
