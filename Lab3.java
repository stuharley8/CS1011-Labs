/* CS 1011 081 (Software Development 1)
* Fall Semester
* Lab 3
* Stuart Harley
* 9/20/2018
 */
package HarleyS;

import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        System.out.println("Are you filing joint? yes/no ");
        Scanner keyboard = new Scanner(System.in);
        final String FILING_JOINT = keyboard.next();
        System.out.print("Enter your expected income for 2018: ");
        Scanner in = new Scanner(System.in);
        double income = in.nextDouble();
        final int INCOME = (int)(income + .5);
        double totalTaxes = 0;
        if(FILING_JOINT.equals("no")) {
            int tempIncome = INCOME;
            if (INCOME > 500000){
                totalTaxes += ((tempIncome-500000)*.37);
                tempIncome = 500000;
            }
            if(INCOME>200000){
                totalTaxes += ((tempIncome-200000)*.35);
                tempIncome = 200000;
            }
            if(INCOME>157500){
                totalTaxes += ((tempIncome-157500)*.32);
                tempIncome = 157000;
            }
            if(INCOME>82500){
                totalTaxes += ((tempIncome-82500)*.24);
                tempIncome = 82500;
            }
            if(INCOME>38700){
                totalTaxes += ((tempIncome-38700)*.22);
                tempIncome = 38700;
            }
            if(INCOME>9525) {
                totalTaxes += ((tempIncome - 9525) * .12);
                tempIncome = 9525;
            }
            totalTaxes += (tempIncome*.10);
        }
        else if(FILING_JOINT.equals("yes")){
            int tempIncome = INCOME;
            if(INCOME > 600000){
                totalTaxes += ((tempIncome-600000)*.37);
                tempIncome = 600000;
            }
            if(INCOME > 400000){
                totalTaxes += ((tempIncome-400000)*.35);
                tempIncome = 400000;
            }
            if(INCOME > 315000){
                totalTaxes += ((tempIncome-315000)*.32);
                tempIncome = 315000;
            }
            if(INCOME > 165000){
                totalTaxes += ((tempIncome-165000)*.24);
                tempIncome = 165000;
            }
            if(INCOME > 77400){
                totalTaxes += ((tempIncome-77400)*.22);
                tempIncome = 77400;
            }
            if(INCOME > 19050){
                totalTaxes += ((tempIncome-19050)*.12);
                tempIncome = 19050;
            }
            totalTaxes += (tempIncome*.10);
        }
        double taxRate = (totalTaxes/INCOME)*100;
        int roundTaxRate = (int)(taxRate*100);
        taxRate = roundTaxRate/100.00;
        System.out.println("Your estimated taxes for 2018 are $" + (int)(totalTaxes+.5));
        System.out.println("Your effective tax rate is %" + taxRate);
    }
}