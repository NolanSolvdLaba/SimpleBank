package org.example.enums;

public enum CurrencyConversion {
    USD("United States Dollar", "$"),
    EUR("Euro", "€");

    private final String currencyName;
    private final String symbol;

    CurrencyConversion(String currencyName, String symbol){
        this.currencyName = currencyName;
        this.symbol = symbol;
    }
    public String getCurrencyName() {
        return currencyName;
    }

    public String getSymbol() {
        return symbol;
    }

    public double convertToUSD(double amount) {
        if (this == EUR) {
            return amount * 1.2;
        }
        //no conversion for Dollar
        return amount;
    }

    public double convertToEUR(double amount) {
        if (this == USD) {
            return amount * 0.83;
        }
        //no conversion for Euro
        return amount;
    }
}
