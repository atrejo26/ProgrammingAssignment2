public class StockPurchase {
    private String companyName;
    private String tickerSymbol;
    private int numSharesPurchased;
    private double pricePerShare;

    public StockPurchase(String companyName, String tickerSymbol, double pricePerShare, int numSharesPurchased) {
        this.companyName = companyName;
        this.tickerSymbol = tickerSymbol;
        this.pricePerShare = pricePerShare;
        this.numSharesPurchased = numSharesPurchased;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public int getNumSharesPurchased() {
        return numSharesPurchased;
    }

    public double getPricePerShare() {
        return pricePerShare;
    }

    /** Current value of this purchase, using the feed's current price. */
    public double getCurrentValue(RealTimeFeed feed) {
        return feed.getCurrentValue(tickerSymbol) * numSharesPurchased;
    }

    /** Row of HTML describing this purchase. */
    public String getReport(RealTimeFeed feed) {
        String retVal = "<tr>";
        retVal += "<td>" + companyName + "</td>";
        retVal += "<td>" + tickerSymbol + "</td>";
        retVal += "<td>" + numSharesPurchased + "</td>";
        retVal += "<td>$" + String.format("%.2f", pricePerShare) + "</td>";
        retVal += "<td>$" + String.format("%.2f", feed.getCurrentValue(tickerSymbol)) + "</td>";
        retVal += "<td>$" + String.format("%.2f", getCurrentValue(feed)) + "</td>";
        retVal += "</tr>\n";
        return retVal;
    }
}