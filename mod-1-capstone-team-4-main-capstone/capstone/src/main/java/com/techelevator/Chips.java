package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Item {

    public Chips(String name, BigDecimal price, String type){
        super(name, price, type);
        //super.getSound();
    }

    public String sound(){
        return "Crunch Crunch, Yum!";
    }

}
