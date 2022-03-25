package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{

    public Gum(String name, BigDecimal price, String type){
        super(name, price, type);
        //super.getSound();
    }

    public String sound(){
        return "Chew Chew, Yum!";
    }

}
