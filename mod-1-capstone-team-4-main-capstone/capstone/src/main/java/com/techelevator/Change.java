package com.techelevator;

import java.math.BigDecimal;

public class Change {

    double machineBalance;
    int nickels;
    int dimes;
    int quarters;


    public void getChange(BigDecimal currentBalance){

        machineBalance = (currentBalance.doubleValue() * 100);
        quarters = ((int) machineBalance/25);
        machineBalance = machineBalance - (quarters * 25);
        dimes = ((int) machineBalance / 10);
        machineBalance = machineBalance - (dimes * 10);
        nickels = ((int) machineBalance / 5);
        machineBalance = machineBalance - (nickels * 5);

        System.out.println("Change: " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels.");

    }

}
