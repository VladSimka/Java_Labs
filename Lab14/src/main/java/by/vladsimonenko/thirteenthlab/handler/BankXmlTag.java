package by.vladsimonenko.thirteenthlab.handler;

public enum BankXmlTag {
    BANKS("banks"),
    BANK("bank"),
    NAME("name"),
    COUNTRY("country"),
    TYPE("type"),
    DEPOSITOR("depositor"),
    ACCOUNTID("accountId"),
    AMOUNTONDEPOSIT("amountOnDeposit"),
    PROFITABILITY("profitability"),
    TIMECONSTRAINTS("timeConstrains");


    private String value;

    BankXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
