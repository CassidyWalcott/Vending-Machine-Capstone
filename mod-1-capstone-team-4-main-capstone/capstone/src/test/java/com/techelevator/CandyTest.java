package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CandyTest {
    Candy candyTester;

    @Before
    public void Setup(){
        candyTester = new Candy("Moonpie", new BigDecimal("1.80"), "Candy");}

    @Test
    public void Candy_Name_and_Price_Test() {
        Assert.assertEquals("Moonpie", candyTester.getName());
        Assert.assertEquals("1.80", candyTester.getPrice().toString());
        Assert.assertEquals("Candy", candyTester.getType());




}


}
