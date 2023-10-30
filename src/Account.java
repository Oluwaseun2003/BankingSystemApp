public class Account {
    private String accountName;
    private int accountNumber;
    private double balance;

    private String accountType;

    public Account(String accountName, int accountNumber, double balance, String accountType){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccoutType() {
        return accountType;
    }

    public void setAccoutType(String accoutType) {
        this.accountType = accoutType;
    }
}
