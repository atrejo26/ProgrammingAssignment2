import java.util.ArrayList;
import java.util.List;

public class Checking extends Account {
    private List<Transaction> transactions;

    public Checking(String acctNumber, String first, String last, String address) {
        super(acctNumber, first, last, address);
        transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        transactions.add(new Deposit(amount));
    }

    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            transactions.add(new Withdraw(amount));
        }
    }

    public double getBalance() {
        double total = 0.0;
        for (Transaction t : transactions) {
            total += t.getAmount();
        }
        return total;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public double getValue(RealTimeFeed feed) {
        return getBalance();
    }

    @Override
    public String getReport(RealTimeFeed feed) {
        String retVal = getHeaderReport();
        retVal += "<p>Balance: $" + String.format("%.2f", getBalance()) + "</p>\n";
        retVal += "<table>\n";
        retVal += "<tr><th>Type</th><th>Amount</th></tr>\n";

        for (Transaction t : transactions) {
            retVal += t.getReport();
        }
        retVal += "</table>\n";
        
        return retVal;
    }
}