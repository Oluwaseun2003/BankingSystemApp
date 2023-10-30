import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Transaction>  transactions = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();

    public void createAccount(Account account){
        accounts.add(account);
    }

    public void updateBalance(int accountNumber, double amount){
        for (Account account : accounts){
            if (account.getAccountNumber() == accountNumber){
                account.setBalance(account.getBalance() + amount);
            } break;
        }
    }

    public void transaction(Transaction transaction){
        transactions.add(transaction);
    }

    public ArrayList<Transaction> getTransactionHistory(int accountNumber){
        ArrayList<Transaction> transactionsHistory = new ArrayList<>();
        for (Transaction transaction : transactions){
            if (transaction.getAccountNumber() == accountNumber){
                transactionsHistory.add(transaction);
            }
        } return  transactionsHistory;
    }

    public void listAllAccount(){
        for (Account account : accounts){
            System.out.println("Account Name: " + account.getAccountName());
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Balance: " + account.getBalance());
            System.out.println("Account Type: " + account.getAccoutType());
        }

    }

    public void manageCustomerInfo(Customer customer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Managing Customer Info");

        System.out.println("1. Update your name?");
        System.out.println("2. Update your Contact Info?");
        System.out.println("3. Update your ID?");
        System.out.println("4. View Your Details?");
        System.out.println("5. Delete Your account?");
        System.out.println("6. Go back");

        System.out.println("Enter your choice Sir/Ma \n");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                System.out.println("Enter your preferred new Name");
                String newName = scanner.nextLine();
                customer.setName(newName);
                System.out.println("Name updated successfully\n");
                break;

            case 2:
                System.out.println("Enter new Contact Information\n");
                String newContactInfo = scanner.nextLine();
                customer.setContactInfo(newContactInfo);
                System.out.println("Your Contact Info has been updated");
                break;

            case 3:
                System.out.println("Enter your preferred ID(e.g 20231031001)");
                String newCustomerId = scanner.nextLine();
                customer.setCustomerID(newCustomerId);
                break;

            case 4:
                System.out.println("These are your details");
                System.out.println("Customer name: " + customer.getName());
                System.out.println("Contact Information: " + customer.getContactInfo());
                System.out.println("Customer ID: " + customer.getCustomerID());
                break;

            case 5:
                System.out.println("Are you sure you want to delete your account? Yes/No");
                String deleteConfirmation = scanner.nextLine();
                if (deleteConfirmation.equals("yes")){
                    String idToDelete  = customer.getCustomerID();
                    boolean accountsDeleted = false;

                    ArrayList<Account> accountsToDelete = new ArrayList<>();
                    ArrayList<Customer> customersToDelete = new ArrayList<>();

                    for (Account account: accounts){
                        if (account.getAccountName().equals(accountsToDelete)){
                            accountsToDelete.add(account);
                        }
                    }

                    for (Customer customer1: customers){
                        if (customer1.getCustomerID().equals(customersToDelete)){
                            customersToDelete.add(customer1);
                        }
                    }

                    for (Account account: accountsToDelete){
                        accounts.remove(account);
                        accountsDeleted = true;
                    }

                    if (accountsDeleted) {
                        System.out.println("Account Deleted successfully!");
                    } else {
                        System.out.println("No account with the name you inputted was found");
                    }
                } else {
                    System.out.println("Account Deletion Cancelled");
                }
                break;

            case 6:
                System.out.println("Going back to the main menu");
                break;

            default:
                System.out.println("Invalid choice, try again");

        }

    }
}
