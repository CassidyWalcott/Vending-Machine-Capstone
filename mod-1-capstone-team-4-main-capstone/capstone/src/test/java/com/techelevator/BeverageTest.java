package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BeverageTest {
    Beverages beverageTester;

    @Before
    public void Setup() {
        beverageTester = new Beverages("Cola", new BigDecimal("1.25"), "Drink");
    }
    @Test
    public void Beverages_Name_and_Price_Test() {
        Assert.assertEquals("Cola", beverageTester.getName());
        Assert.assertEquals("1.25", beverageTester.getPrice().toString());
        Assert.assertEquals("Drink", beverageTester.getType());
    }


}
