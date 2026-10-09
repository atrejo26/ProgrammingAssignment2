public class Deposit extends Transaction {

    public Deposit(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public String getReport() {
        String retVal = "<tr><td>Deposit</td><td>$" + String.format("%.2f", amount) + "</td></tr>\n";
        return retVal;
    }
}