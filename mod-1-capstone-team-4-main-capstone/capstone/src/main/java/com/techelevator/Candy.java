package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item{

    public Candy(String name, BigDecimal price, String type){
        super(name, price, type);
        //super.getSound();
    }

    public String sound(){
        return "Munch Munch, Yum!";
    }

}
