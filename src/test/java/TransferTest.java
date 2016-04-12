import com.classes.Account;
import com.classes.Transfer;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by marce on 4/12/2016.
 */
public class TransferTest {
    @Test
    public void checkTaxCalc(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Bobson");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "15 04 2016"), 'A');
        Assert.assertEquals(t1.getTransferTax(), 500*0.03+2, 0);
    }

    @Test
    public void checkTaxCalcB1(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Felipe");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "15 04 2016"), 'B');
        Assert.assertEquals(t1.getTransferTax(), 10, 0);
    }

    @Test
    public void checkTaxCalcB2(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Luana");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "15 06 2016"), 'B');
        Assert.assertEquals(t1.getTransferTax(), 8, 0);
    }

    @Test
    public void checkTaxCalcC1(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Karina");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "15 06 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 6, 0);
    }

    @Test
    public void checkTaxCalcC2(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Felicia");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "10 05 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 10.5, 0);
    }

    @Test
    public void checkTaxCalcC3(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Livia");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "06 05 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 21.5, 0);
    }

    @Test
    public void checkTaxCalcC4(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Mayquel");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "01 05 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 27, 0);
    }

    @Test
    public void checkTaxCalcC5(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Bruna");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "26 04 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 33.5, 0);
    }

    @Test
    public void checkTaxCalcC6(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Nicoly");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "21 04 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 37, 0);
    }

    @Test
    public void checkTaxCalcC7(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Luna");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 500, formatDate(new Date(), "16 04 2016"), 'C');
        Assert.assertEquals(t1.getTransferTax(), 41.5, 0);
    }

    @Test
    public void checkTaxCalcD1(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Fabiana");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 10000, formatDate(new Date(), "26 04 2016"), 'D');
        Assert.assertEquals(t1.getTransferTax(), 2 + 10000*0.03 , 0);
    }
    @Test

    public void checkTaxCalcD2(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Mariana");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 30000, formatDate(new Date(), "26 04 2016"), 'D');
        Assert.assertEquals(t1.getTransferTax(), 10 , 0);
    }

    @Test
    public void checkTaxCalcD3(){
        List<Account> accs = new ArrayList<>();

        Account a1 = new Account("180232-22", "38286539877", "Marcel");
        Account a2 = new Account("935427-03", "68579254803", "Jackson");

        accs.add(a1);
        accs.add(a2);

        Transfer t1 = new Transfer(accs.get(0).getAccountNumber(), accs.get(1).getAccountNumber(), 125000, formatDate(new Date(), "21 06 2016"), 'D');
        Assert.assertEquals(t1.getTransferTax(), 125000*0.012 , 0);
    }

    //Necessary
    public Date formatDate(Date dt, String data){
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        try {
            dt = format.parse(data);
        } catch(Exception err){
            err.printStackTrace();
        }
        return dt;
    }
}
