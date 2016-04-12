package com.classes;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by marce on 4/12/2016.
 */
public class Transfer {
    private String originAccount;
    private String destinyAccount;
    private double transferAmount;
    private double transferTax;
    private Date transferDate;
    private char transferType;
    private UUID tokenID; //Security.

    public Transfer(String originAccount, String destinyAccount, double transferAmount, Date transferDate, char transferType){
        this.originAccount = originAccount;
        this.destinyAccount = destinyAccount;
        this.transferAmount = DecimalNumberFormat(transferAmount);
        this.transferDate = transferDate;
        this.transferType = transferType;
        this.transferTax = DecimalNumberFormat(
                calculateTransferTax(transferDate, transferAmount, transferType)
        );
        this.tokenID = UUID.randomUUID();
    }

    //Tomada de decisões e calculos de taxa.
    public double calculateTransferTax(Date transferDate, double transferAmount, char transferType){
        double tax = 0;
        double diff = setDays(transferDate.getTime() - new Date().getTime());

        //Premissa, tipo D.
        if (transferType == 'D'){
            transferType = dTest(transferAmount);
        }

        //Maior facilidade para o controle de fluxo de acordo com o Type.
        switch(transferType){
            case 'A':
                tax = 2 + transferAmount*0.03;
                break;

            case 'B':
                if (diff <= 30)
                    tax = 10;
                else
                    tax = 8;
                break;

            case 'C':
                if (diff <= 5)
                    tax = transferAmount*0.083;
                else if (diff <= 10)
                    tax = transferAmount*0.074;
                else if (diff <= 15)
                    tax = transferAmount*0.067;
                else if (diff <= 20)
                    tax = transferAmount*0.054;
                else if (diff <= 25)
                    tax = transferAmount*0.043;
                else if (diff <= 30)
                    tax = transferAmount*0.021;
                else if (diff > 30)
                    tax = transferAmount*0.012;
                break;
            default:
                System.out.println("Error: invalid transfer TYPE -> "+ transferType + ".");
        }
        return tax;
    }

    public double setDays(double diff){
        diff = Math.round(diff / (24 * 60 * 60 * 1000));
        return diff;
    }

    public char dTest(double transferAmount){
        char response = '_';
        if (transferAmount < 0)
            System.out.println("Error: Invalid Amount -> "+ transferAmount + ".");
        else if (transferAmount > 0 && transferAmount <= 25000)
            response = 'A';
        else if (transferAmount >= 25001 && transferAmount <= 120000)
            response = 'B';
        else if (transferAmount > 120000)
            response = 'C';

        return response;
    }

    //Formatação
    public double DecimalNumberFormat(double number){
        DecimalFormat df = new DecimalFormat("#.##");
        number = Double.valueOf(df.format(number));
        return number;
    }

    //Getters
    public String getOriginAccount() {
        return originAccount;
    }

    public String getDestinyAccount() {
        return destinyAccount;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public double getTransferTax() {
        return transferTax;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public char getTransferType() {
        return transferType;
    }

    public UUID getTokenID(){
        return tokenID;
    }
}