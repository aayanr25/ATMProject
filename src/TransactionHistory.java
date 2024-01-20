import java.util.ArrayList;
public class TransactionHistory {
    private Customer owner;
    private int accTransactionNum;
    private int secTransactionNum;
    private ArrayList<String> receiptList;
    public TransactionHistory(Customer owner) {
        this.owner = owner;
        accTransactionNum = 0000;
        secTransactionNum = 0000;
        receiptList = new ArrayList<String>();
    }

    // Each new account transaction requires a new Transaction ID, this method returns the next account ID number available.
    public String newAccTransID() {
        accTransactionNum++;
        String printedNum = "" + accTransactionNum;
        if (accTransactionNum < 10) {
            printedNum = "000" + accTransactionNum;
        } else if (accTransactionNum < 100) {
            printedNum = "00" + accTransactionNum;
        } else if (accTransactionNum < 1000) {
            printedNum = "0" + accTransactionNum;
        }

        return "A" + printedNum;
    }

    // Each new security transaction requires a new Transaction ID, this method returns the next security ID number available.
    public String newSecTransID() {
        secTransactionNum++;
        String printedNum = "" + secTransactionNum;
        if (secTransactionNum < 10) {
            printedNum = "000" + secTransactionNum;
        } else if (secTransactionNum < 100) {
            printedNum = "00" + secTransactionNum;
        } else if (secTransactionNum < 1000) {
            printedNum = "0" + secTransactionNum;
        }

        return "S" + printedNum;
    }

    // this method adds a String to the receiptList array list.
    public void addReceipt(String receipt) {
        receiptList.add(receipt);
    }


    // returns the full transaction list in order from earliest transaction to latest transaction.
    public String printableTransactionList() {
        String str = "";
        for (int i = 0; i < receiptList.size(); i++) {
            str += (i + 1) + ") \n";
            str += receiptList.get(i);
            str += "\n\n";
        }
        return str;
    }


}
