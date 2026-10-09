public abstract class Transaction {
    protected double amount;

    public Transaction(double amount) {
        this.amount = amount;
    }

    /** Signed amount: positive for deposits, negative for withdrawals. */
    public abstract double getAmount();

    /** Row of HTML describing this transaction. */
    public abstract String getReport();
}