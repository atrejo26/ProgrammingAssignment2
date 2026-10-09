public class Withdraw extends Transaction {

    public Withdraw(double amount) {
        super(amount);
    }

    @Override
    public double getAmount() {
        return -amount;
    }

    @Override
    public String getReport() {
        String retVal = "<tr><td>Withdraw</td><td>$" + String.format("%.2f", amount) + "</td></tr>\n";
        return retVal;
    }
}