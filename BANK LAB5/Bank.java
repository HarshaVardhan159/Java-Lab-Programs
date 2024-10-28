import java.util.Scanner;

abstract class Account {
    String customerName;
    String accountNumber;
    double balance;

    public Account(String customerName, String accountNumber) {
        this.customerName = customerName;  
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public abstract void displayBalance();
    public abstract void withdraw(double amount);
}

class SavAcct extends Account {
    double interestRate;

    public SavAcct(String customerName, String accountNumber, double interestRate) {
        super(customerName, accountNumber);
        this.interestRate = interestRate;
    }

    public void computeAndDepositInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        System.out.println("Interest of " + interest + " has been added to your account");
    }

    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
    }
}

class CurAcct extends Account {
    private double minimumBalance;
    private double serviceCharge;

    public CurAcct(String customerName, String accountNumber, double minimumBalance, double serviceCharge) {
        super(customerName, accountNumber);
        this.minimumBalance = minimumBalance; 
        this.serviceCharge = serviceCharge;
    }

    public void displayBalance() {
        System.out.println("Current Account Balance: " + balance);
        checkMinimumBalance();
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount);
            checkMinimumBalance();
        } else {
            System.out.println("Insufficient funds for withdrawal of " + amount);
        }
    }

    private void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Service charge of " + serviceCharge + " has been applied");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        System.out.println("Harsha Vardhan\n1BM23CS136");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the type of account (current or savings):");
        String accountType = sc.nextLine(); // Fixed variable name
        System.out.println("Enter customer name:");
        String customerName = sc.nextLine(); // Fixed variable name
        System.out.println("Enter account number:");
        String accountNumber = sc.nextLine();
        Account account = null;

        if (accountType.equalsIgnoreCase("savings")) {
            System.out.println("Enter interest rate:");
            double interestRate = sc.nextDouble();
            account = new SavAcct(customerName, accountNumber, interestRate);
        } else if (accountType.equalsIgnoreCase("current")) {
            System.out.println("Enter minimum balance:");
            double minBalance = sc.nextDouble();
            System.out.println("Enter service charge:");
            double serviceCharge = sc.nextDouble();
            account = new CurAcct(customerName, accountNumber, minBalance, serviceCharge);
        } else {
            System.out.println("Invalid account type");
            return;
        }

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            if (account instanceof SavAcct) {
                System.out.println("4. Compute and Deposit Interest");
            }
            System.out.println("5. Exit");
            System.out.println("Select an option:");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    if (account instanceof SavAcct) {
                        ((SavAcct) account).computeAndDepositInterest();
                    } else {
                        System.out.println("Invalid option for current account");
                    }
                    break;
                case 5:
                    System.out.println("Exiting");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option");
            }
 
        }
    }
}