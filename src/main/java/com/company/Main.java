package com.company;

import com.classes.Account;
import com.classes.Transfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Transfer> scheduled = new ArrayList<>();
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Bobson");
        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "15 04 2016"), 'D');
        Transfer t2 = new Transfer(accs.get(1).getAccountNumber(), accs.get(0).getAccountNumber(), 2500, formatDate(new Date(), "18 04 2016"), 'D');
        Transfer t3 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 10000, formatDate(new Date(), "23 04 2016"), 'D');
        Transfer t4 = new Transfer(accs.get(1).getAccountNumber(), accs.get(0).getAccountNumber(), 150000, formatDate(new Date(), "17 05 2016"), 'D');
        scheduled.add(t1);
        scheduled.add(t2);
        scheduled.add(t3);
        scheduled.add(t4);

        getScheduleList(scheduled);
    }

    public static void getScheduleList (List<Transfer> list){
        int x = list.size();
        for (int i = 0; i < x; i++){
            System.out.println( "Transfer "+ (i+1) + ". Token segurança -> "+list.get(i).getTokenID()+ " - Datails");
            System.out.println( "Origin Account: "+ list.get(i).getOriginAccount().toString());
            System.out.println( "Destiny Account: "+ list.get(i).getDestinyAccount().toString());
            System.out.println( "Scheduled Date: "+ list.get(i).getTransferDate());
            System.out.println( "Amount: "+ list.get(i).getTransferAmount());
            System.out.println( "Transfer Tax: "+ list.get(i).getTransferTax());
            System.out.println( "Type: "+ list.get(i).getTransferType());
            System.out.println( "Total Transfer Value: "+ (list.get(i).getTransferAmount() + list.get(i).getTransferTax()) );
            System.out.println( "*-*-*-*-*-*-*-*-*\n");
        }
    }

    public static Date formatDate(Date dt, String data){
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        try {
            dt = format.parse(data);
        } catch(Exception err){
            err.printStackTrace();
        }
        return dt;
    }
}
