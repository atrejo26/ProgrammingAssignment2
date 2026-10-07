# Financial Portfolio Manager

Programming Assignment 2

## Your Information

- **Name:** Rey T
- **Date:** 9/28/2026

## How to Run

### From VS Code

1. Open this folder in VS Code.
2. If you haven't already done so, install the recommended Extension Pack for Java when prompted.
3. Make sure `equities.txt` is in the project folder (next to `src`).
4. Open `src/Driver.java`.
5. Click the **Run** link above the `main` method.

### From the terminal

From the project folder, pass the path to the stock price file as an argument:

    javac -d bin src/*.java
    java -cp bin Driver equities.txt

### Viewing the report

The program writes `portfolioReport.html` to the project folder. Open it in a web browser to view the report.

## Notes

- **Account hierarchy:** `Account` is an abstract base class holding the shared account holder information and report header. `Checking` and `Equity` extend it and each implement `getValue()` and `getReport()`.
- **Transactions:** `Transaction` is an abstract class with `Deposit` and `Withdraw` subclasses. Deposits return a positive amount and withdrawals a negative amount, so the checking balance is the sum of all transactions. Withdrawals larger than the balance are ignored.
- **Stock prices:** `MockRealTimeFeed` implements the `RealTimeFeed` interface and reads current prices from `equities.txt`. Each `StockPurchase` uses the feed to calculate its current value, which may differ from its purchase price.
- **Sorting:** `Portfolio` sorts accounts from most to least valuable using a `Comparator` with `Collections.sort()` before writing the report.
- **File path:** The Driver uses the path passed in through `args` if one is given, and otherwise falls back to a default path.

## Course Policy

Unless I say otherwise, always write your code *without* an AI assistant. You may use AI tools as a tutor to ask questions and to check your work, but not use them to write the code for you.
