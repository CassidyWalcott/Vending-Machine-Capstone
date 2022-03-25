package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Scanner;

public class LoggerTest {

    Logger logTester = new Logger();
    Scanner scanner = new Scanner("Log.log");

    @Before
    public void Setup() throws Exception {
        logTester.writeToLog("FEED MONEY", new BigDecimal ("4.00"), new BigDecimal ("10.00" ));
    }

    @Test
    public void writeToLog_Returns_Log_String(){

        Assert.assertEquals(true, scanner.hasNextLine());

    }

}
