import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/** Reads mock stock prices from a file (e.g. equities.txt: "MSFT 123.45" per line). */
public class MockRealTimeFeed implements RealTimeFeed {
    private Map<String, Double> prices;

    public MockRealTimeFeed(String filePath) {
        prices = new HashMap<>();
        loadPrices(filePath);
    }

    private void loadPrices(String filePath) {
        try {
        Scanner in = new Scanner(new File(filePath));
        while (in.hasNext()) {
            String ticker = in.next();
            double price = in.nextDouble();
            prices.put(ticker, price);
        }
        in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file: " + filePath);
        }
    }

    @Override
    public double getCurrentValue(String tickerSymbol) {
        double retVal = prices.getOrDefault(tickerSymbol, 0.0);
        return retVal;
    }
}