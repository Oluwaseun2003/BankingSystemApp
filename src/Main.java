import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankingSystem bankingSystem = new BankingSystem();


        System.out.println("Welcome to Oluwaseun's bank, what do you want to do today?");

        while (true){
            System.out.println("1. Create Account");
            System.out.println("2. Update Balance");
            System.out.println("3. Add Transaction");
            System.out.println("4. Get Transaction History");
            System.out.println("5. List All Account");
            System.out.println("6 Manage Customer info");
            System.out.println("7. Exit");
            System.out.println("Enter your choice\n");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter Account Number(i.e 0000000): ");
                    if (scanner.hasNextInt()) {
                        long accountNumber = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Enter Customer Name: ");
                        String accountName = scanner.nextLine();

                        System.out.print("Enter Initial Balance: ");
                        if (scanner.hasNextDouble()) {
                            double initialBalance = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.print("Enter Account Type: ");
                            String accountType = scanner.nextLine();

                            Account account = new Account(accountName, (int) accountNumber, initialBalance, accountType);
                            bankingSystem.createAccount(account);
                            System.out.println("Account created successfully!");
                        } else {
                            System.out.println("Invalid input for initial balance. Please enter a valid number.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid input for account number. Please enter a valid integer.");
                        scanner.next();
                    }
                    break;


                case 2:
                    System.out.print("Enter Account Number: ");
                    if (scanner.hasNextInt()) {
                        int accountNumberToUpdate = scanner.nextInt();
                        System.out.print("Enter Amount to Update (positive for deposit, negative for withdrawal): ");
                        if (scanner.hasNextDouble()) {
                            double updateAmount = scanner.nextDouble();
                            bankingSystem.updateBalance(accountNumberToUpdate, updateAmount);
                        } else {
                            System.out.println("Invalid input for amount. Please enter a valid number.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid input for account number. Please enter a valid integer.");
                        scanner.next();
                    }
                    break;


                case 3:
                    System.out.print("Enter Account Number: ");
                    if (scanner.hasNextInt()) {
                        int accountNumberForTransaction = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Transaction Amount: ");
                        if (scanner.hasNextDouble()) {
                            double transactionAmount = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.print("Enter Transaction Type (Deposit/Withdrawal): ");
                            String transactionType = scanner.nextLine().trim().toLowerCase();
                            if (transactionType.equals("deposit") || transactionType.equals("withdrawal")) {
                                System.out.print("Enter Transaction Description: ");
                                String transactionDescription = scanner.nextLine();
                                bankingSystem.addTransaction(accountNumberForTransaction, transactionAmount, transactionType, transactionDescription);
                            } else {
                                System.out.println("Invalid transaction type. Please enter 'Deposit' or 'Withdrawal'.");
                            }
                        } else {
                            System.out.println("Invalid input for transaction amount. Please enter a valid number.");
                            scanner.next();
                        }
                    } else {
                        System.out.println("Invalid input for account number. Please enter a valid integer.");
                        scanner.next();
                    }
                    break;

                case 4:
                    System.out.print("Enter account number to get transaction history: ");
                    int accountNumber = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<Transaction> transactionHistory = bankingSystem.getTransactionHistory(accountNumber);
                    if (transactionHistory.isEmpty()) {
                        System.out.println("No transactions found for this account.");
                    } else {
                        System.out.println("Transaction History:");
                        for (Transaction transaction : transactionHistory) {
                            System.out.println(transaction);
                        }
                    }
                    break;


                case 5:
                    bankingSystem.listAllAccount();
                    break;

                case 6:
                    System.out.print("Enter customer ID: ");
                    String customerID = scanner.nextLine();
                    bankingSystem.manageCustomerInfo(customerID);
                    break;

                case 7:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }

    }
}