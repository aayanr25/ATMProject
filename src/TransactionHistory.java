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


    public void

}
