public class TransactionHistory {
    private Customer owner;
    private int totalTransactions;
    private int accTransactionNum;
    private int secTransactionNum;
    public TransactionHistory(Customer owner) {
        this.owner = owner;
        totalTransactions = 0;
        accTransactionNum = 0000;
        secTransactionNum = 0000;
    }

    public void incrementTransactions() {
        totalTransactions++;
    }


    public String newAccTransID() {
        accTransactionNum++;
        String printedNum = "" + accTransactionNum;
        if (accTransactionNum < 10) {
            printedNum = "000" + accTransactionNum;
        } if (accTransactionNum < 100) {
            printedNum = "00" + accTransactionNum;
        } if (accTransactionNum < 1000) {
            printedNum = "0" + accTransactionNum;
        }

        return "A" + printedNum;
    }
    public String newSecTransID() {
        secTransactionNum++;
        String printedNum = "" + secTransactionNum;
        if (secTransactionNum < 10) {
            printedNum = "000" + secTransactionNum;
        } if (secTransactionNum < 100) {
            printedNum = "00" + secTransactionNum;
        } if (secTransactionNum < 1000) {
            printedNum = "0" + secTransactionNum;
        }

        return "S" + printedNum;
    }

    public String receipt() {
        String str = "";

    }

}
