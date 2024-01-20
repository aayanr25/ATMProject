import java.util.Scanner;
public class ATM {
    private Customer owner;
    private Account savings;
    private Account checking;
    private TransactionHistory transactions;
    private Scanner scan;
    public ATM() {
        welcomeUser();
        mainMenu();  // the mainMenu method is where the program is run, runs until the user is finished.

    }

    public void mainMenu() {
        String keepGoing = "y";
        String receipt = "";
        outerloop:  // defines first while loop so that it can be ended with a break function within the loop
        while(!keepGoing.equals("n")) {
            ConsoleUtility.clearScreen();
            System.out.print("Please re enter your PIN for security: ");
            String PIN = scan.nextLine();
            int num = 0;
            while(!PIN.equals(owner.getPinNum())) {  // if the user enters their PIN incorrectly 3 times in a row, they get locked out of their account
                if (num > 2) {
                    System.out.println("Too many incorrect PIN entries. Have a nice day.");
                    break outerloop;
                }
                System.out.print("Incorrect PIN.");
                System.out.print("\n\nPlease re enter your PIN for security: ");
                PIN = scan.nextLine();
                System.out.println();
                num++;
            }
            System.out.println();
            System.out.println("--------------------");
            System.out.println("(1) Withdraw money\n(2) Deposit money\n(3) Transfer money between accounts\n(4) Get account balances\n(5) Get transaction history\n(6) Change PIN\n(7) Exit");
            System.out.println("--------------------");
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
            System.out.print("Enter a number (1-7) corresponding to the action you wish to take: ");
            int choice = scan.nextInt();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
            ConsoleUtility.clearScreen();
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
                System.out.println(currentBalances());
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                System.out.println();
                System.out.println(ConsoleUtility.WHITE + "RECEIPT" + ConsoleUtility.RESET);
                System.out.println("********************");
                receipt  = "~" + ConsoleUtility.CYAN + "Successfully obtained account balances." + ConsoleUtility.RESET + "~";
                receipt += "\nTransaction ID: " + transactions.newSecTransID();
                System.out.println(receipt);
                transactions.addReceipt(receipt);  // action goes on the total list of transactions completed by this user.
                System.out.println("********************");
                System.out.println();
                scan.nextLine();
            }
            else if (choice == 5) {
                System.out.println(transactions.printableTransactionList());
                System.out.println();
                System.out.println(ConsoleUtility.WHITE + "RECEIPT" + ConsoleUtility.RESET);
                System.out.println("********************");
                receipt = "~" + ConsoleUtility.CYAN + "Successfully obtained transaction history." + ConsoleUtility.RESET + "~";
                receipt += "\nTransaction ID: " + transactions.newSecTransID();
                System.out.println(receipt);
                transactions.addReceipt(receipt);
                System.out.println("********************");
                System.out.println();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                scan.nextLine();
            }
            else if(choice == 6) {
                System.out.print("Enter new PIN: ");
                scan.nextLine();
                String newPin = scan.nextLine();
                owner.setPinNum(newPin);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("error");
                }
                System.out.println();
                System.out.println(ConsoleUtility.WHITE + "RECEIPT" + ConsoleUtility.RESET);
                System.out.println("********************");
                receipt = "~" + ConsoleUtility.CYAN + "Successfully changed PIN" + ConsoleUtility.RESET + "~";
                receipt += "\nTransaction ID: " + transactions.newSecTransID();
                System.out.println(receipt);
                transactions.addReceipt(receipt);
                System.out.println("********************");
                System.out.println();
            }
            else if(choice == 7) {
                System.out.println("Thank you for choosing this ATM. Have a great day!");
                break;
            }
            else {
                System.out.println("Invalid entry.");
            }
            System.out.print("Would you like to do something else? (y/n) ");
            keepGoing = scan.nextLine();
            if (keepGoing.equals("n")) {  // once user enters 'n' the overall while loop ends, and program finishes.
                System.out.println("Thank you for choosing this ATM. Have a great day!");
            }
        }

    }

    // private helper method serves as a constructor which initializes instance variables within the class
    private void welcomeUser() {
        scan = new Scanner(System.in);
        System.out.println("Welcome to the greatest ATM in all the land! \nPlease enter your information to create your accounts.");
        System.out.print("Customer name: ");
        String name = scan.nextLine();
        System.out.print("\nEnter new PIN: ");
        String pin = scan.nextLine();
        owner = new Customer(name, pin);
        savings = new Account("savings", owner);
        checking = new Account("checking", owner);
        transactions = new TransactionHistory(owner);
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println(currentBalances());
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    // returns the account that the user would like to take an action on, for choice 1, 2, or 3.
    private Account chooseAccount() {
        System.out.print("Would you like to use your (1) savings or (2) checking account: ");
        int choice = scan.nextInt();
        while (choice != 1 && choice != 2) {
            System.out.print("Enter a 1 or a 2: ");
            choice = scan.nextInt();
        }
        if (choice == 1) {
            return savings;
        } else {
            return checking;
        }
    }

    private void withdrawal() {
        String receipt = "NO ACTION TAKEN";
        Account account = chooseAccount();
        System.out.print("ATM has $5 and $20 bills. Enter withdrawal amount: ");
        int amt = scan.nextInt();
        scan.nextLine();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error");
        }
        if (amt > account.getCurrentBalance()) {
            System.out.println(ConsoleUtility.RED + "Insufficient funds!" + ConsoleUtility.RESET);
            receipt += ConsoleUtility.RED + "\nUnsuccessful withdrawal" + ConsoleUtility.RESET;
        } else {
            if (amt % 5 == 0) {
                int numTwenties = numBills(amt);
                int numFives = (amt - (numTwenties * 20)) / 5;
                account.withdrawFunds(amt);
                receipt = "~" + ConsoleUtility.GREEN + "Successfully withdrew " + numTwenties + " $20 bills and " + numFives + " $5 bills" + ConsoleUtility.RESET + "~";
                receipt += "Total withdrawal amount: $" + amt + ".00";
                receipt += "\nTransaction ID: " + transactions.newAccTransID();
                receipt += "\n" + currentBalances();
                transactions.addReceipt(receipt);
            } else {
                System.out.println("ATM only has $5 and $20 bills");
            }
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println();
        System.out.println(ConsoleUtility.WHITE + "RECEIPT" + ConsoleUtility.RESET);
        System.out.println("********************");
        System.out.println(receipt);
        System.out.println("********************");
        System.out.println();
    }

    // returns the number of $20 bills the user wants their withdrawal to include
    private int numBills(int withdrawalAmt) {
        int max = withdrawalAmt / 20;
        System.out.print("Enter quantity of $20 bills to withdraw (max:" + max + "): ");
        int num = scan.nextInt();
        return num;
    }

    private void deposit() {
        String receipt = "";
        Account account = chooseAccount();
        System.out.print("Enter the deposit amount: ");
        double amt = scan.nextDouble();
        scan.nextLine();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error");
        }
        account.depositFunds(amt);
        receipt += "~" +ConsoleUtility.GREEN + "Successfully deposited $" + amt + ConsoleUtility.RESET + "~";
        receipt += "\nTransaction ID: " + transactions.newAccTransID();
        receipt += "\n" + currentBalances();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println();
        System.out.println(ConsoleUtility.WHITE + "RECEIPT" + ConsoleUtility.RESET);
        System.out.println("********************");
        System.out.println(receipt);
        System.out.println("********************");
        System.out.println();
        transactions.addReceipt(receipt);
    }

    private String currentBalances() {
        String str = "Savings Account: $" + savings.getCurrentBalance();
        str += "\nChecking Account: $" + checking.getCurrentBalance();
        return str;
    }

    private void moneyTransfer() {
        scan.nextLine();
        String receipt = "NO ACTION TAKEN";
        System.out.print("FROM: ");
        Account fromAcc = chooseAccount();
        System.out.print("TO: ");
        Account toAcc = chooseAccount();
        System.out.print("Enter transfer amount from your " + fromAcc.getType() + " to your " + toAcc.getType() + ": ");
        double amt = scan.nextDouble();
        scan.nextLine();
        if (amt > fromAcc.getCurrentBalance()) {
            System.out.println(ConsoleUtility.RED + "Insufficient funds!" + ConsoleUtility.RESET);
            receipt += ConsoleUtility.RED + "\nUnsuccessful transfer" + ConsoleUtility.RESET;
        } else {
            fromAcc.withdrawFunds(amt);
            toAcc.depositFunds(amt);
            receipt = "~" + ConsoleUtility.GREEN + "Successfully transferred $" + amt + " from " + fromAcc.getType() + " to " + toAcc.getType() + ConsoleUtility.RESET +"~";
            receipt += "\nTransaction ID: " + transactions.newAccTransID();
            receipt += "\n" + currentBalances();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("error");
            }
        }
            System.out.println();
            System.out.println(ConsoleUtility.WHITE + "RECEIPT" + ConsoleUtility.RESET);
            System.out.println("********************");
            System.out.println(receipt);
            System.out.println("********************");
            System.out.println();
            transactions.addReceipt(receipt);
        }

    }
