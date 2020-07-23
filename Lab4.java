/*Stuart Harley
*CS 1011
* Fall Semester
* Lab 4
* 9/27/2018
*
*Your grandfather needs life insurance, choose either recieving a set amount, or an exponential amount, for a random number of weeks
 */

import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        String redo = "y";
        while(redo.equals("y")) {
            System.out.println("Your grandfather is getting old and doesn't know how long he has left. He has asked "
                    + "you to set up a life insurance policy for him.\nYou have the option of recieving a "
                    + "set amount (randomly set between $0 and $5000 per week (option 1), or an exponential amount "
                    + "starting at $.01 that doubles every week. (option 2)\nYour grandfather is not expected to live "
                    + "more than a year (52 weeks). Which option would you like to take? (1 or 2)");
            Scanner in = new Scanner(System.in);
            String option = in.next();
            while (!(option.equals("1") || option.equals("2"))) {
                System.out.print("Invalid response, please try again. (1 or 2) ");
                in = new Scanner(System.in);
                option = in.next();
            }
            double startingLinearAmount = Math.random() * 5000 + 1;
            int weeks = (int) (Math.random() * 52 + 1);
            double linearAmount = (int) ((startingLinearAmount * weeks + .005) * 100);
            linearAmount /= 100;
            System.out.println(linearAmount);
            double exponentialAmount = .01;
            for (int currentWeek = 1; currentWeek <= weeks; currentWeek++) {
                System.out.format("Week %2d Linear: $%.2f, Exponential: $%.2f\n", currentWeek, startingLinearAmount * currentWeek, exponentialAmount);
                exponentialAmount *= 2;
            }
            exponentialAmount /= 2;
            System.out.println("\nYour grandfather dies after " + weeks + " weeks.");
            if (linearAmount > exponentialAmount && option.equals("1")) {
                System.out.format("You guessed correctly and ended with an extra $%.2f", (linearAmount - exponentialAmount));
            } else if (exponentialAmount > linearAmount && option.equals("2")) {
                System.out.format("You guessed correctly and ended with an extra $%.2f", (exponentialAmount - linearAmount));
            } else if (linearAmount > exponentialAmount && option.equals("2")) {
                System.out.format("You guessed incorrectly and missed out on $%.2f", (linearAmount - exponentialAmount));
            } else if (exponentialAmount > linearAmount && option.equals("1")) {
                System.out.format("You guessed incorrectly and missed out on $%.2f", (exponentialAmount - linearAmount));
            } else {
                System.out.println("What are the odds? Both options ended up returning the same amount.");
            }
            System.out.println("\nDo you want to try again? (y or n) ");
            in = new Scanner(System.in);
            redo = in.next();
            while(!(redo.equals("y") || redo.equals("n"))){
                System.out.print("Invalid response, please try again. (y or n)");
                in = new Scanner(System.in);
                redo = in.next();
            }
        }
    }
}