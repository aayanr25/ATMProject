import java.util.Scanner;
public class ATM {
    private Customer owner;
    private Account savings;
    private Account checking;
    private TransactionHistory transactions;
    private Scanner scan;
    public ATM() {
        welcomeUser();

    }

    public void mainMenu() {
        System.out.println("Enter a number (1-7) corresponding to the action you wish to take");
        System.out.println();
        System.out.println("(1) Withdraw money\n(2) Deposit money\n(3) Transfer money between accounts\n(4) Get account balances\n(5) Get transaction history\n(6)Change PIN\n(7) Exit");
        int choice = scan.nextInt();
        while(choice != 7) {
            if (choice == 1) {
                boolean success = withdrawal();
                if (success) {
                    System.out.println("Successful withdrawal");
                }
            }
            else if (choice == 2) {
            }
            else if (choice == 3) {
            }
            else if (choice == 4) {
            }
            else if (choice == 5) {
            }
            else if(choice == 6) {
            }
            else {
                System.out.println("Invalid entry.");
            }
        }

    }

    private void welcomeUser() {
        scan = new Scanner(System.in);
        System.out.println("Welcome! Please enter your information to create your accounts.");
        System.out.println("Customer name: ");
        String name = scan.nextLine();
        System.out.println("Enter new PIN:");
        int pin = scan.nextInt();
        scan.nextLine();
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
        if (amt > account.getCurrentBalance()) {
            System.out.println("Insufficient funds!");
            return false;
        } else {
            if (amt % 5 == 0) {
                account.withdrawFunds(amt);
                return true;
            } else {
                System.out.println("ATM only has $5 and $20 bills");
                return false;
            }
        }
    }





}
