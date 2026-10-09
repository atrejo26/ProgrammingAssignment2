public abstract class Account {
    protected String acctNumber;
    protected String first;
    protected String last;
    protected String address;

    public Account(String acctNumber, String first, String last, String address) {
        this.acctNumber = acctNumber;
        this.first = first;
        this.last = last;
        this.address = address;
    }

    public String getAcctNumber() {
        return acctNumber;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getAddress() {
        return address;
    }

    /**
     * Total value of the account. The feed is used by accounts that need
     * current stock prices; others may ignore it.
     */
    public abstract double getValue(RealTimeFeed feed);

    /** HTML report for this account. */
    public abstract String getReport(RealTimeFeed feed);

    /** Shared HTML for the account number, holder name and address. */
    protected String getHeaderReport() {
        String retVal = "";
        retVal += "<h2>Account " + acctNumber + "</h2>\n";
        retVal += "<p>" + first + " " + last + "</p>\n";
        retVal += "<p>" + address + "</p>\n";
        return retVal;
    }
}