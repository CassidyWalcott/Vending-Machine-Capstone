package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Item{

    public Beverages(String name, BigDecimal price, String type){
        super(name, price, type);
        //super.getSound();
    }

    public String sound(){
        return "Glug Glug, Yum!";
    }

}
