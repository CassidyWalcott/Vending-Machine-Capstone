package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    public Map<String, List<Item>> fileInventory() {
        File inventoryItems = new File("C:\\Users\\Student\\workspace\\mod-1-capstone-team-4\\capstone\\vendingmachine.csv");

        Map<String, List<Item>> vendingMachineInventoryOfficial = new HashMap<>();

        try (Scanner itemStocker = new Scanner(inventoryItems)) {


            while(itemStocker.hasNextLine()) {
                String lineInput = itemStocker.nextLine();


                if (!lineInput.isEmpty()) {
                    String[] itemStockerArray = lineInput.split("\\|");

                    if(itemStockerArray[0].contains("A")) {
                        List<Item> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {

                            Chips chipSelector = new Chips(itemStockerArray[1],
                                    new BigDecimal(itemStockerArray[2]),
                                    new String(itemStockerArray[3]));
                            itemArray.add(chipSelector);
                        }
                        vendingMachineInventoryOfficial.put(itemStockerArray[0], itemArray);

                    }else if(itemStockerArray[0].contains("B")) {
                        List<Item> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {

                            Candy candySelector = new Candy(itemStockerArray[1],
                                    new BigDecimal(itemStockerArray[2]),
                                    new String(itemStockerArray[3]));
                            itemArray.add(candySelector);
                        }
                        vendingMachineInventoryOfficial.put(itemStockerArray[0], itemArray);

                    }else if(itemStockerArray[0].contains("C")) {
                        List<Item> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {

                            Beverages bevSelector = new Beverages(itemStockerArray[1],
                                    new BigDecimal(itemStockerArray[2]),
                                    new String(itemStockerArray[3]));
                            itemArray.add(bevSelector);
                        }
                        vendingMachineInventoryOfficial.put(itemStockerArray[0], itemArray);

                    }else if(itemStockerArray[0].contains("D")) {
                        List<Item> itemArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {

                            Gum gumSelector = new Gum(itemStockerArray[1],
                                    new BigDecimal(itemStockerArray[2]),
                                    new String(itemStockerArray[3]));
                            itemArray.add(gumSelector);
                        }
                        vendingMachineInventoryOfficial.put(itemStockerArray[0], itemArray);
                    }

                }

            }
            return vendingMachineInventoryOfficial;

        }catch (FileNotFoundException fnf){
            System.out.println("File does not exist");
            System.exit(1);
            return vendingMachineInventoryOfficial;
        }

    }
}
