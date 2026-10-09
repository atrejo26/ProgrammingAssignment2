import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Portfolio {
    private List<Account> accounts;
    private RealTimeFeed realTimeFeed;

    public Portfolio(RealTimeFeed realTimeFeed) {
        accounts = new ArrayList<>();
        this.realTimeFeed = realTimeFeed;
    }

    public void addAccount(Account a) {
        accounts.add(a);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    /** Sum of the values of all accounts. */
    public double getTotalValue() {
        double retVal = 0.0;
        for (Account a : accounts) {
            retVal += a.getValue(realTimeFeed);
        }
        return retVal;
    }

    /** Sorts accounts from most to least valuable (Comparator + Collections.sort()). */
    private void sortAccountsByValue() {
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account a, Account b) {
                return Double.compare(b.getValue(realTimeFeed), a.getValue(realTimeFeed));
            }
        });
    }

    /** Writes an HTML report for all accounts to the given file. */
    public void generateReport(String outputFilePath) {
        sortAccountsByValue();

        String html = "<html>\n<head>\n<title>Portfolio Report</title>\n";
        html += "<style>table, th, td { border: 1px solid black; border-collapse: collapse; padding: 4px; }</style>\n";
        html += "</head>\n<body>\n";
        html += "<h1>Portfolio Report</h1>\n";

        for (Account a : accounts) {
            html += a.getReport(realTimeFeed);
            html += "<hr>\n";
        }

        html += "<h2>Total Portfolio Value: $" + String.format("%.2f", getTotalValue()) + "</h2>\n";
        html += "</body>\n</html>\n";

        try (PrintWriter out = new PrintWriter(outputFilePath)) {
            out.print(html);
        } catch (FileNotFoundException e) {
            System.out.println("Could not write file: " + outputFilePath);
        }
    }
}