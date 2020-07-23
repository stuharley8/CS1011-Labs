/*
 * Course: CS-1011-011
 * Fall 2018
 * Lab 7 - Battle Simulator 3000
 * Name: Stuart Harley
 * Created: 10/11/18
 */

package harleys;

import java.util.Scanner;

/**
 * Runs the battle between the warrior and the mugwump as many times as the player wants
 */
public class BattleSim {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Battle Simulator 3000! The world's more low " +
                "tech battle Simulator!");
        System.out.println("You are a Valiant Warrior defending your humble village " +
                "from an evil Mugwump!\nFight Bravely, or the citizens of your town " +
                "will be the Mugwump's dinner!");
        System.out.println("You have your Trusty Sword, which deals decent damage, " +
                "but can be tough to hit with sometimes.");
        System.out.println("You also have your Shield of Light, which is not as " +
                "strong as your sword, but is easier to deal damage with.");
        System.out.println("Let the epic battle begin!\n");

        boolean playAgain;
        String winner;

        do {
            Warrior warrior = new Warrior();
            Mugwump mugwump = new Mugwump();
            do {
                report(warrior, mugwump);
                winner = battle(warrior, mugwump, in);
            } while (winner.equals("none"));
            report(warrior, mugwump);
            victory(winner);
            playAgain = playAgain(in);
        } while (playAgain);
        System.out.println("Thank you for playing Battle Simulator 3000!");
    }

    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in){
        int warriorAttack;
        int mugwumpAttack;
        int whoAttacksFirst = initiative();
        if(whoAttacksFirst == 2) {
            System.out.println("The mugwump attacks first!");
            mugwumpAttack = mugwump.attack();
            if (mugwumpAttack > 0) {
                warrior.takeDamage(mugwumpAttack);
                System.out.println("The mugwump snaps at you and does " +
                        mugwumpAttack + " damage!");
            } else if (mugwumpAttack < 0) {
                mugwump.takeDamage(mugwumpAttack);
                System.out.println("The mugwump heals itself for " +
                        Math.abs(mugwumpAttack) + " health!");
            } else {
                System.out.println("The mugwump snaps at you and misses!");
            }
        } else {
            System.out.println("You attack first!");
            int attackChoice = attackChoice(in);
            warriorAttack = warrior.attack(attackChoice);
            if(warriorAttack > 0) {
                mugwump.takeDamage(warriorAttack);
                System.out.println("You hit the foul creature for " +
                        warriorAttack + " damage!");
            } else{
                System.out.println("You missed the foul creature!");
            }
        }
        if(whoAttacksFirst==1 && mugwump.getHitPoints()>0){
            mugwumpAttack = mugwump.attack();
            if (mugwumpAttack > 0) {
                warrior.takeDamage(mugwumpAttack);
                System.out.println("The mugwump snaps at you and does " +
                        mugwumpAttack + " damage!");
            } else if (mugwumpAttack < 0) {
                mugwump.takeDamage(mugwumpAttack);
                System.out.println("The mugwump heals itself for " +
                        Math.abs(mugwumpAttack) + " health!");
            } else {
                System.out.println("The mugwump snaps at you and misses!");
            }
        } else if (whoAttacksFirst==2 && warrior.getHitPoints()>0){
            int attackChoice = attackChoice(in);
            warriorAttack = warrior.attack(attackChoice);
            if(warriorAttack > 0) {
                mugwump.takeDamage(warriorAttack);
                System.out.println("You hit the foul creature for " +
                        warriorAttack + " damage!");
            } else{
                System.out.println("You missed the foul creature!");
            }
        }
        if (mugwump.getHitPoints()==0) {
            return "Warrior";
        } else if(warrior.getHitPoints()==0){
            return "Mugwump";
        } else {
            return "none";
        }
    }

    private static void report(Warrior warrior, Mugwump mugwump){
        System.out.println("Warrior HP: " + warrior.getHitPoints());
        System.out.println("Mugwump HP: " + mugwump.getHitPoints() + "\n");
    }

    private static int attackChoice(Scanner in){
        System.out.println("How would you like to attack?");
        System.out.println("1. Your Trusty Sword");
        System.out.println("2. Your Shield of Light");
        System.out.print("Enter Choice: ");
        String input = in.next();
        while (!(input.equals("1") || input.equals("2"))) {
            System.out.print("Invalid choice, try again: ");
            input = in.next();
        }
        return Integer.parseInt(input);
    }

    private static int initiative(){
        Die d10 = new Die(10);
        int warriorRoll = 0;
        int mugwumpRoll = 0;
        while(warriorRoll == mugwumpRoll) {
            d10.roll();
            warriorRoll = d10.getCurrentValue();
            d10.roll();
            mugwumpRoll = d10.getCurrentValue();
        }
        if (warriorRoll > mugwumpRoll){
            return 1;
        } else {
            return 2;
        }
    }

    private static void victory(String winner){
        if(winner.equals("Warrior")){
            System.out.println("Congratulations, you defeated the mugwump!");
        } else if(winner.equals("Mugwump")){
            System.out.println("You were defeated in battle! The villagers were eaten!");
        }
    }

    private static boolean playAgain(Scanner in){
        System.out.println("Do you want to play again? (yes/no) ");
        String answer = in.next();
        return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }
}