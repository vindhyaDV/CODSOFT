import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("Choose an option: ");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                System.out.println("Enter amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Current balance: " + account.getBalance());
                } else {
                    System.out.println("Insufficient funds!");
                }
                break;
            case 2:
                System.out.println("Enter amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                System.out.println("Deposit successful. Current balance: " + account.getBalance());
                break;
            case 3:
                System.out.println("Your current balance is: " + account.getBalance());
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
}

 class Atminterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            atm.displayOptions();
            int option = scanner.nextInt();
            atm.processOption(option);

            System.out.println("Do you want to perform another transaction? (Y/N)");
            String continueOption = scanner.next();
            if (!continueOption.equalsIgnoreCase("Y")) {
                exit = true;
                System.out.println("Thank you for using the ATM.");
            }
        }
        scanner.close();
    }
}