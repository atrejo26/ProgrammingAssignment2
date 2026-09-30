# Notes

## Class Hierarchy

- **Account**
  - **CheckingAccount**
    - **Transaction**
      - Withdraw (+)
      - Deposit (−)
  - **EquityAccount**
    - **StockPurchase**
    - **RealTimeFeed**
      - MockRealTimeFeed
      - ScrapingRealTimeFeed
      - YahooRealTimeFeed
  - **Portfolio**

## Class Details

### Account
**Fields**
- `acctNumber`
- `first`
- `last`
- `address`

**Methods**
- `getReport()`
- `getValue()`

---

### CheckingAccount

#### Transaction
**Fields**
- `amount`

**Methods**
- `getAmount()`

**Subclasses**
- **Withdraw** (+)
- **Deposit** (−)

---

### EquityAccount

#### StockPurchase
**Fields**
- `companyName`
- `tickerSymbol`
- `numSharesPurchased`
- `pricePerShare`

#### RealTimeFeed
**Methods**
- `getValuesOfStock(String tickerSymbol)`

**Subclasses**
- **MockRealTimeFeed**
- **ScrapingRealTimeFeed**
- **YahooRealTimeFeed**

---

### Portfolio
**Methods**
- `addAccount(Account a)`
- `generateReport()`