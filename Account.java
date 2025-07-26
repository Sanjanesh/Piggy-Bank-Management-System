public class Account {
    private String ownerName;
    private double balance;

    public Account(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0.0;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
            } else {
                System.out.println("Insufficient funds. Unable to withdraw $" + amount);
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Account owner: " + ownerName);
        System.out.println("Current balance: $" + balance);
    }
}
