import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1 -> System.out.println("Balance: $" + account.getBalance());
                case 2 -> {
                    System.out.print("Enter deposit amount: $");
                    account.deposit(scanner.nextDouble());
                }
                case 3 -> {
                    System.out.print("Enter withdrawal amount: $");
                    account.withdraw(scanner.nextDouble());
                }
                case 4 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option. Try again.");
            }
        } while (option != 4);

        scanner.close();
    }
}
class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(new BankAccount(1000.00));
        atm.run();
    }
}
