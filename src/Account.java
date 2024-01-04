public class Account {
    private String type;
    private double currentBalance;
    private Customer owner;
    private TransactionHistory transaction;
    public Account(String type, Customer owner) {
        this.type = type;
        this.owner = owner;
        currentBalance = 0;
    }

    public String getType() {
        return type;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
    public void depositFunds(double money) {
        currentBalance += money;
    }

    public void withdrawFunds(double money) {
        currentBalance -= money;
    }



}
