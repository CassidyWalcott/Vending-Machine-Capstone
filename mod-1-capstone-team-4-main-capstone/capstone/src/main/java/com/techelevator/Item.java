package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {

    //private members
    private String name;
     BigDecimal price;
     public String type;
    //String sound; using as method

    //getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public String getType(){
        return type;
    }
    public void setType(){
        this.type = type;
    }
   // public String getSound(){
      //  return sound;
   // }
   // public void setSound(){
     //   this.sound = sound;
    //}

    //constructors
    public Item(){}

    public Item(String name, BigDecimal price, String type){
        this.name = name;
        this.price = price;
        this.type = type;
        // this.sound = sound;
    }


    @Override
    public String toString() {
        String stringResult = name + " " + price + " " + type;
        return stringResult;
    }



    //method
    public abstract String sound();



}
