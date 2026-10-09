public interface RealTimeFeed {
    /** Returns the current price per share for the given ticker symbol. */
    double getCurrentValue(String tickerSymbol);
}