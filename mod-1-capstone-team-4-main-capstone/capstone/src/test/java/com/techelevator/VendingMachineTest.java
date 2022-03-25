package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachineTest{

    VendingMachine vendingMachineTester;
    Gum gumCLassTester = new Gum ("Chiclets", new BigDecimal("0.75"), "Gum");
    List<Item> itemArrayForTest = new ArrayList<>();
    Map<String, List<Item>> GumForVendingMachineTest = new TreeMap<>();

    @Before
    public void Setup() throws Exception{
        vendingMachineTester = new VendingMachine(GumForVendingMachineTest);
        itemArrayForTest.add(gumCLassTester);
        itemArrayForTest.add(gumCLassTester);
        GumForVendingMachineTest.put("D3", itemArrayForTest);
    }



    @Test
    public void feedMoneyMethodTester(){

        vendingMachineTester.feedMoney(2);
        Assert.assertEquals(new BigDecimal("2.00"), vendingMachineTester.currentBalance);
        vendingMachineTester.endTransaction();
    }
    @Test
    public void purchaseMethodTester() {
        vendingMachineTester.feedMoney(3);
        vendingMachineTester.purchase("D3");
        Assert.assertEquals(new BigDecimal("4.25"), vendingMachineTester.currentBalance);
        vendingMachineTester.endTransaction();
    }
    @Test
    public void endTransactionMethodTester() {
        vendingMachineTester.feedMoney(1);
        vendingMachineTester.purchase("D3");
        vendingMachineTester.endTransaction();
        Assert.assertEquals(new BigDecimal("0.25"), vendingMachineTester.currentBalance);
    }



}
