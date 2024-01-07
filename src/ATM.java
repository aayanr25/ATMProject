import java.util.Scanner;
public class ATM {
    private Customer owner;
    private Account savings;
    private Account checking;
    private TransactionHistory transactions;
    private Scanner scan;
    public ATM() {
        welcomeUser();
        mainMenu();

    }

    public void mainMenu() {
        String keepGoing = "y";
        while(!keepGoing.equals("n")) {
            System.out.println("Enter a number (1-7) corresponding to the action you wish to take");
            System.out.println();
            System.out.println("--------------------");
            System.out.println("(1) Withdraw money\n(2) Deposit money\n(3) Transfer money between accounts\n(4) Get account balances\n(5) Get transaction history\n(6)Change PIN\n(7) Exit");
            System.out.println("--------------------");
            int choice = scan.nextInt();
            if (choice == 1) {
                withdrawal();
            }
            else if (choice == 2) {
                deposit();
            }
            else if (choice == 3) {
                moneyTransfer();
            }
            else if (choice == 4) {
                System.out.println("Savings Account: $" + savings.getCurrentBalance());
                System.out.println("Checking Account: $" + checking.getCurrentBalance());
            }
            else if (choice == 5) {

            }
            else if(choice == 6) {
                System.out.print("Enter new PIN: ");
                String newPin = scan.nextLine();
                owner.setPinNum(newPin);
                System.out.println("~Successfully changed PIN~");
            }
            else if(choice == 7) {
                break;
            }
            else {
                System.out.println("Invalid entry.");
            }
            System.out.println("Would you like to do something else? (y/n) ");
            keepGoing = scan.nextLine();
        }

    }

    private void welcomeUser() {
        scan = new Scanner(System.in);
        System.out.println("Welcome! Please enter your information to create your accounts.");
        System.out.println("Customer name: ");
        String name = scan.nextLine();
        System.out.println("Enter new PIN:");
        String pin = scan.nextLine();
        owner = new Customer(name, pin);
        savings = new Account("savings", owner);
        checking = new Account("checking", owner);
        transactions = new TransactionHistory(owner);

    }

    private Account chooseAccount() {
        System.out.println("Would you like to use your (1) savings or (2) checking account?");
        int choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.println("Enter a 1 or a 2: ");
            choice = scan.nextInt();
        }
        if (choice == 1) {
            return savings;
        } else {
            return checking;
        }
    }

    private boolean withdrawal() {
        Account account = chooseAccount();
        System.out.println("ATM has $5 and $20 bills. Enter withdrawal amount: ");
        int amt = scan.nextInt();
        scan.nextLine();
        if (amt > account.getCurrentBalance()) {
            System.out.println("Insufficient funds!");
            return false;
        } else {
            if (amt % 5 == 0) {
                account.withdrawFunds(amt);
                System.out.println("~Successfully withdrew $" + amt + "~");
                return true;
            } else {
                System.out.println("ATM only has $5 and $20 bills");
                return false;
            }
        }
    }

    private void deposit() {
        Account account = chooseAccount();
        System.out.println("Enter the deposit amount: ");
        double amt = scan.nextDouble();
        scan.nextLine();
        account.depositFunds(amt);
        System.out.println("Successfully deposited $" + amt + "~");
    }

    private void moneyTransfer() {
        System.out.print("FROM: ");
        Account fromAcc = chooseAccount();
        System.out.print("TO: ");
        Account toAcc = chooseAccount();
        System.out.println("Enter transfer amount from your " + fromAcc.getType() + " to your " + toAcc.getType() + ":");
        double amt = scan.nextDouble();
        scan.nextDouble();
        if (amt > fromAcc.getCurrentBalance()) {
            System.out.println("Insufficient funds!");
        } else {
            fromAcc.withdrawFunds(amt);
            toAcc.depositFunds(amt);
            System.out.println("~Successfully transferred $" + amt + " from " + fromAcc.getType() + " to " + toAcc.getType() + "~");
        }
    }





    public String receipt() {
        String str = "";



        transactions.addReceipt(str);
        return str;
    }





}
