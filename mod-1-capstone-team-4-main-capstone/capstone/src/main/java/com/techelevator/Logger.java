package com.techelevator;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Logger {

    public void writeToLog(String transactionType, BigDecimal amountOfMoney, BigDecimal vmBalance){

        LocalDate date = LocalDate.now();
        String dateString = date.toString();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MM-dd-yyy"));

        LocalTime time = LocalTime.now();
        String timeString = time.toString().substring(0, time.toString().length() - 7);

        try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("Log.log"), true))){

            String printTransactionType = transactionType.toString();
            String printVMBalance = vmBalance.toString();
            String printAmountOfMoney = amountOfMoney.toString();

            logWriter.println(formattedDate + " " + timeString + " " + printTransactionType +  " " + printAmountOfMoney + " " + printVMBalance);

        }catch (FileNotFoundException fnf) {
            fnf.getMessage();
        }
    }


}
