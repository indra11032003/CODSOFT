import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
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
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}

class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void handleOption(int option) {
        switch (option) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > 0) {
                    bankAccount.withdraw(withdrawAmount);
                } else {
                    System.out.println("Invalid amount!");
                }
                break;

            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                if (depositAmount > 0) {
                    bankAccount.deposit(depositAmount);
                } else {
                    System.out.println("Invalid amount!");
                }
                break;

            case 3:
                System.out.println("Current Balance: $" + bankAccount.getBalance());
                break;

            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);

            default:
                System.out.println("Invalid option!");
        }
    }
}

public class bank {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = new Scanner(System.in).nextInt();
            atm.handleOption(choice);
        }
    }
}

/* OUTPUT:
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Enter your choice: 3
Current Balance: $1000.0
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Enter your choice: 2
Enter deposit amount: 500
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Enter your choice: 3
Current Balance: $1500.0
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Enter your choice: 1
Enter withdrawal amount: 200
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Enter your choice: 3
Current Balance: $1300.0
1. Withdraw
2. Deposit
3. Check Balance
4. Exit
Enter your choice: 4
Exiting ATM. Thank you!*/