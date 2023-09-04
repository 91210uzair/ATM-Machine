import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ATM {
    private static Map<String, BankAccount> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create sample accounts
        accounts.put("user1", new BankAccount("user1", "password1", 1000.0));
        accounts.put("Uzair", new BankAccount("Uzair", "uzair@07", 500.0));

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        BankAccount currentAccount = accounts.get(username);
        if (currentAccount == null) {
            System.out.println("Invalid username.");
            return;
        }

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (!currentAccount.verifyPassword(enteredPassword)) {
            System.out.println("Invalid password.");
            return;
        }

        System.out.println("Welcome, " + currentAccount.getUsername() + "!");
        performTransactions(currentAccount, scanner);
    }

    private static void performTransactions(BankAccount account, Scanner scanner) {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}