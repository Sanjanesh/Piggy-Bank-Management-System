import java.util.*;

public class PiggyBank {
    private List<Account> accounts;

    public PiggyBank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully.");
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        System.out.println("Account for " + account.getOwnerName() + " removed successfully.");
    }

    public void deposit(String ownerName, double amount) {
        Account account = findAccount(ownerName);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String ownerName, double amount) {
        Account account = findAccount(ownerName);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String ownerName) {
        Account account = findAccount(ownerName);
        if (account != null) {
            account.checkBalance();
        } else {
            System.out.println("Account not found.");
        }
    }

    private Account findAccount(String ownerName) {
        for (Account account : accounts) {
            if (account.getOwnerName().equalsIgnoreCase(ownerName)) {
                return account;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        PiggyBank piggyBank = new PiggyBank();
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        while (!quit) {
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account owner's name: ");
                    scanner.nextLine(); // Consume newline character
                    String ownerName = scanner.nextLine();
                    Account newAccount = new Account(ownerName);
                    piggyBank.addAccount(newAccount);
                    break;
                case 2:
                    System.out.println("Select an account to remove:");
                    displayAccountList(piggyBank);
                    System.out.print("Enter the account number: ");
                    int accountToRemove = scanner.nextInt();
                    Account account = piggyBank.accounts.get(accountToRemove - 1);
                    if (account != null) {
                        piggyBank.removeAccount(account);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.println("Select an account to deposit:");
                    displayAccountList(piggyBank);
                    System.out.print("Enter the account number: ");
                    int accountToDeposit = scanner.nextInt();
                    System.out.print("Enter deposit amount: $");
                    double depositAmount = scanner.nextDouble();
                    Account depositAccount = piggyBank.accounts.get(accountToDeposit - 1);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.println("Select an account to withdraw:");
                    displayAccountList(piggyBank);
                    System.out.print("Enter the account number: ");
                    int accountToWithdraw = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawalAmount = scanner.nextDouble();
                    Account withdrawAccount = piggyBank.accounts.get(accountToWithdraw - 1);
                    if (withdrawAccount != null) {
                        withdrawAccount.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("Select an account to check balance:");
                    displayAccountList(piggyBank);
                    System.out.print("Enter the account number: ");
                    int accountToCheck = scanner.nextInt();
                    Account checkAccount = piggyBank.accounts.get(accountToCheck - 1);
                    if (checkAccount != null) {
                        checkAccount.checkBalance();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println();
        }
        System.out.println("Thank you for using the Piggy Bank!");
    }

    private static void displayAccountList(PiggyBank piggyBank) {
        int count = 1;
        for (Account account : piggyBank.accounts) {
            System.out.println(count + ". " + account.getOwnerName());
            count++;
        }
    }
}
