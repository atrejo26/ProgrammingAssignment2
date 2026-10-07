import java.util.ArrayList;
import java.util.List;

public class Equity extends Account {
    private List<StockPurchase> stockPurchases;

    public Equity(String acctNumber, String first, String last, String address) {
        super(acctNumber, first, last, address);
        stockPurchases = new ArrayList<>();
    }

    public void purchaseStock(String companyName, String tickerSymbol, double pricePerShare, int numSharesPurchased) {
        stockPurchases.add(new StockPurchase(companyName, tickerSymbol, pricePerShare, numSharesPurchased));
    }

    public List<StockPurchase> getStockPurchases() {
        return stockPurchases;
    }

    /** Total current value of all equities, using prices from the feed. */
    @Override
    public double getValue(RealTimeFeed feed) {
        double retVal = 0.0;
        for (StockPurchase sp : stockPurchases) {
            retVal += sp.getCurrentValue(feed);
        }
        return retVal;
    }

    @Override
    public String getReport(RealTimeFeed feed) {
        String retVal = getHeaderReport();
        retVal += "<table>\n";
        retVal += "<tr><th>Company</th><th>Ticker</th><th>Shares</th>"
                + "<th>Purchase Price</th><th>Current Price</th><th>Current Value</th></tr>\n";

        for (StockPurchase sp : stockPurchases) {
            retVal += sp.getReport(feed);
        }
        retVal += "</table>\n";
        retVal += "<p>Total Value: $" + String.format("%.2f", getValue(feed)) + "</p>\n";

        return retVal;
    }
}