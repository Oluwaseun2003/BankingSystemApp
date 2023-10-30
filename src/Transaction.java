public class Transaction {
    private int transactionID;
    private String date;
    private double amount;
    private String transactionType;
    private String description;

    public Transaction(int transactionID, String date, double amount, String transactionType, String description){
        this.transactionID = transactionID;
        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
        this.description = description;
    }

    public int getTransactionId() {
        return transactionID;
    }

    public void setTransactionId(int transactionId) {
        this.transactionID = transactionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
