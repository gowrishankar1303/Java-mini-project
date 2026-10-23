
import java.util.Scanner;
import java.util.ArrayList;

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String toString() {
        return type + " : Rs." + amount;
    }
}

class DigitalWallet {
    double balance = 0;
    ArrayList<Transaction> history = new ArrayList<>();

    void addMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add(new Transaction("Added", amount));
            System.out.println("Money added successfully!");
        } else {
            System.out.println("Enter a valid amount!");
        }
    }

    void spendMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Enter a valid amount!");
        } else if (amount <= balance) {
            balance -= amount;
            history.add(new Transaction("Spent", amount));
            System.out.println("Money spent successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void checkBalance() {
        System.out.println("Current Balance: Rs." + balance);
    }

    void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction t : history) {
                System.out.println(t);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DigitalWallet wallet = new DigitalWallet();
        int choice;

        do {
            System.out.println("\n--- Digital Wallet System ---");
            System.out.println("1. Add Money");
            System.out.println("2. Spend Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to add: ");
                    double add = sc.nextDouble();
                    wallet.addMoney(add);
                    break;

                case 2:
                    System.out.print("Enter amount to spend: ");
                    double spend = sc.nextDouble();
                    wallet.spendMoney(spend);
                    break;

                case 3:
                    wallet.checkBalance();
                    break;

                case 4:
                    wallet.showHistory();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Digital Wallet!"
                    );
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
