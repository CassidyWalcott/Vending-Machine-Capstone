package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ChipsTest {
    Chips chipTester;

    @Before
    public void Setup(){
        chipTester = new Chips("Stackers", new BigDecimal("1.45"), "Chip");
    }
    @Test
    public void Chips_Name_and_Price_Test() {
        Assert.assertEquals("Stackers", chipTester.getName());
        Assert.assertEquals("1.45", chipTester.getPrice().toString());
        Assert.assertEquals("Chip", chipTester.getType());
    }
}
