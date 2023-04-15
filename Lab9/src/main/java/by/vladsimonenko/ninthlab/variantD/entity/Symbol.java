package by.vladsimonenko.ninthlab.variantD.entity;

/**
 * Class that represents symbol
 */
public class Symbol {
    String symbol;

    public Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Symbol() {
        super();
    }

    @Override
    public String toString() {
        return symbol;
    }
}
