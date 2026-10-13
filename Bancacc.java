
class BankAccount {
    String name, accountNumber;
    double balance, initialBalance, deposits = 0, withdrawals = 0;

    BankAccount(String name, String accountNumber, double balance) {
        this.name = name.trim().toUpperCase();
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.initialBalance = balance;
    }

    void deposit(double amount) {
        deposit(amount, "Cash Deposit");
    }

    void deposit(double amount, String description) {
        if (amount > 0) {
            balance += amount;
            deposits += amount;
            System.out.printf("%s: Rs. %.2f%n", description, amount);
            System.out.println("Transaction Status : Deposit Successful");
            System.out.printf("Updated Balance     : Rs. %.2f%n", balance);
        }
    }

    void withdraw(double amount) {
        withdraw(amount, "Cash Withdrawal");
    }

    void withdraw(double amount, String description) {
        System.out.printf("%s: Rs. %.2f%n", description, amount);

        if (amount <= 0) {
            System.out.println("Transaction Status : Invalid Amount");
        } else if (amount <= balance) {
            balance -= amount;
            withdrawals += amount;
            System.out.println("Transaction Status : Withdrawal Successful");
            System.out.printf("Updated Balance     : Rs. %.2f%n", balance);
        } else {
            System.out.println("Transaction Status : Insufficient Balance");
            System.out.printf("Available Balance   : Rs. %.2f%n", balance);
        }
    }

    void summary(String customerName) {
        System.out.println("\n---------- ACCOUNT SUMMARY ----------");
        System.out.println("Account Holder : " + name);
        System.out.println("Account Number : " + accountNumber);
        System.out.printf("Total Deposits : Rs. %.2f%n", deposits);
        System.out.printf("Total Withdrawals : Rs. %.2f%n", withdrawals);
        System.out.printf("Final Balance  : Rs. %.2f%n", balance);

        if (name.equalsIgnoreCase(customerName.trim())) {
            System.out.println("Account Holder Verification: Names Match");
        } else {
            System.out.println("Account Holder Verification: Names Do Not Match");
        }
    }
}

public class Bancacc {
    public static void main(String[] args) {
        BankAccount b = new BankAccount("Ravi Kumar", "1234567890", 10000);

        System.out.println("======= PERSONAL BANKING LEDGER =======");
        System.out.println("Account Holder Name : " + b.name);
        System.out.println("Account Number      : " + b.accountNumber);
        System.out.printf("Initial Balance     : Rs. %.2f%n", b.initialBalance);

        System.out.println("\n---------- TRANSACTION DETAILS ----------");
        b.deposit(5000, "Deposit Amount");
        System.out.println();
        b.withdraw(2000, "Withdrawal Amount");
        System.out.println();
        b.withdraw(20000, "Withdrawal Amount");

        b.summary("Ravi Kumar");
    }
}
