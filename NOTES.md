# Notes

## Class Hierarchy

### Inheritance ("is a")

- **Account** *(abstract)*
  - **Checking**
  - **Equity**
- **Transaction** *(abstract)*
  - **Deposit** (+)
  - **Withdraw** (−)
- **RealTimeFeed** *(interface)*
  - **MockRealTimeFeed**
  - ScrapingRealTimeFeed *(optional, not implemented)*
  - YahooRealTimeFeed *(optional, not implemented)*

### Composition ("has a")

- **Portfolio** has a list of `Account`s and a `RealTimeFeed`
- **Checking** has a list of `Transaction`s
- **Equity** has a list of `StockPurchase`s

## Class Details

### Account *(abstract)*
**Fields**
- `acctNumber`
- `first`
- `last`
- `address`

**Methods**
- Getters for each field
- `getValue(RealTimeFeed feed)` *(abstract)*: total value of the account
- `getReport(RealTimeFeed feed)` *(abstract)*: HTML report for the account
- `getHeaderReport()`: shared HTML for account number, name, and address

---

### Checking *(extends Account)*
**Fields**
- `transactions`: `List<Transaction>`

**Methods**
- `deposit(double amount)`: adds a `Deposit`
- `withdraw(double amount)`: adds a `Withdraw` if the balance covers it
- `getBalance()`: sum of all transaction amounts
- `getTransactions()`
- `getValue(RealTimeFeed feed)`: returns the balance (feed not used)
- `getReport(RealTimeFeed feed)`: header, balance, and transaction table

---

### Transaction *(abstract)*
**Fields**
- `amount` (always stored as positive)

**Methods**
- `getAmount()` *(abstract)*: signed amount
- `getReport()` *(abstract)*: one HTML table row

**Subclasses**
- **Deposit**: `getAmount()` returns `amount` (+)
-