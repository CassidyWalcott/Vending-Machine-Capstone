package com.techelevator;

import java.math.BigDecimal;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
public class VendingMachine {

    BigDecimal currentBalance = new BigDecimal(0.00).setScale(2);
    //boolean hasItem;
    //int itemQuantity;
    //String[] slots;
    List<Item> itemList = new ArrayList<>();
    Map<String, List<Item>> inventory = new TreeMap<>();
    Logger log = new Logger();

    //constructor

    public VendingMachine(){}
    public VendingMachine(Map<String, List<Item>> inventory){
        this.inventory = inventory;
    }

    //methods(verbs)
    public void displayItemsInStock(){
        for(Map.Entry<String, List<Item>> item : inventory.entrySet()){
            String slot = item.getKey();
            List namePriceArray = item.getValue();
            if (namePriceArray.size() == 1){
                System.out.println(slot + "Out of stock");
            }else{

            }
            System.out.println(slot + ": " + namePriceArray.subList(0, 1) + " " + (namePriceArray.size()-1));
        }
    }

    public void feedMoney(int insertCash){
        String transactionType = "FEED MONEY: ";

        if(insertCash == 1){
            currentBalance = currentBalance.add(new BigDecimal(1.00));
            log.writeToLog(transactionType, new BigDecimal(1.00).setScale(2), currentBalance);
        } else if (insertCash == 2){
            currentBalance = currentBalance.add(new BigDecimal(2.00));
            log.writeToLog(transactionType, new BigDecimal(2.00).setScale(2), currentBalance);

        } else if (insertCash == 3){
            currentBalance = currentBalance.add(new BigDecimal(5.00));
            log.writeToLog(transactionType, new BigDecimal(3.00).setScale(2), currentBalance);

        } else if (insertCash == 4){
            currentBalance = currentBalance.add(new BigDecimal(10.00));
            log.writeToLog(transactionType, new BigDecimal(4.00).setScale(2), currentBalance);
        }
        System.out.println("Balance: " + currentBalance);
    }

    public void purchase(String userChoice) {
        if(!inventory.containsKey(userChoice)) {
            System.out.println("This is an invalid selection");
        }
        if (inventory.containsKey(userChoice)) {
            if (inventory.get(userChoice).size() == 0) {
                System.out.println("This item is out of stock");
            }
            else if (inventory.get(userChoice).size() >= 1) {
                if(currentBalance.compareTo(inventory.get(userChoice).get(0).price) >= 0){
                    currentBalance = currentBalance.subtract(inventory.get(userChoice).get(0).price);
                    Item itemPurchased = inventory.get(userChoice).remove(0);
                    itemList.add(itemPurchased);

                    BigDecimal itemPrice = inventory.get(userChoice).get(0).price;
                    String itemName = inventory.get(userChoice).get(0).toString() + " " + userChoice;
                    log.writeToLog(itemName, itemPrice, currentBalance);

                }

                }
            System.out.println("current balance is " + currentBalance);
            }
        }

        //if selection doesnt exist, notify doesnt exist
        //if valid selection, dispense sounds
        //update balance
        //return to purchase menu


    public void endTransaction(){
    String transactionType = "GIVE CHANGE: ";
        Change returnChange = new Change();
        returnChange.getChange(currentBalance);
        log.writeToLog(transactionType, currentBalance, new BigDecimal(0.00).setScale(2));
        while (itemList.size() > 0){
            Item purchasedItems = itemList.remove(0);
            System.out.println(purchasedItems.sound());
        }



        //give change to customer (nickels, dimes, quarters)
        //set machine balance to 0 remaining
        //return to main menu


    }













}
