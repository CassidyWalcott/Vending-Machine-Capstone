package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class GumTest {
    Gum gumTester;

    @Before

    public void Setup(){
        gumTester = new Gum("Chiclets", new BigDecimal("0.75"), "Gum");
    }

    @Test
    public void Gum_Name_and_Price_Test() {
        Assert.assertEquals("Chiclets", gumTester.getName());
        Assert.assertEquals("0.75", gumTester.getPrice().toString());
        Assert.assertEquals("Gum", gumTester.getType());
    }

}
