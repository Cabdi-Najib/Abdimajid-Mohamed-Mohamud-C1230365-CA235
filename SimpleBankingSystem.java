import java.util.Scanner;

public class SimpleBankingSystem {
    private static int balance = 0;
    private static String userPIN;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Create a 4-digit PIN: ");
        userPIN = scanner.nextLine();

        while (!isValidPIN(userPIN)) {
            System.out.print("Invalid PIN. Please enter a 4-digit numeric PIN: ");
            userPIN = scanner.nextLine();
        }

        boolean authenticated = false;
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter your PIN: ");
            String inputPIN = scanner.nextLine();

            if (inputPIN.equals(userPIN)) {
                authenticated = true;
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (3 - attempts));
            }
        }

        if (!authenticated) {
            System.out.println("System locked due to 3 incorrect attempts.");
            scanner.close();
            return;
        }


        int choice;
        do {
            System.out.println("\n=== Banking Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1 to 4.");
            }
        } while (choice != 4);

        scanner.close();
    }


    public static boolean isValidPIN(String pin) {
        return pin.matches("\\d{4}");
    }


    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully. New balance: $" + balance);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }


    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn successfully. New balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
        }
    }


    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }
}