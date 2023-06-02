package by.vladsimonenko.thirteenthlab.entity;

public class Bank {
    private String name;
    private String country;
    private String type;
    private String depositor;
    private int accountId;
    private double amountOnDeposit;
    private double profitability;
    private int timeConstrains;

    public Bank() {
        super();
    }

    public Bank(String name, String country, String type, String depositor, int accountId, double amountOnDeposit, double profitability, int timeConstrains) {
        this.name = name;
        this.country = country;
        this.type = type;
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOnDeposit = amountOnDeposit;
        this.profitability = profitability;
        this.timeConstrains = timeConstrains;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(double amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public int getTimeConstrains() {
        return timeConstrains;
    }

    public void setTimeConstrains(int timeConstrains) {
        this.timeConstrains = timeConstrains;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Банк[");
        sb.append("название='").append(name).append('\'');
        sb.append(", страна регистрации='").append(country).append('\'');
        sb.append(", тип вклада='").append(type).append('\'');
        sb.append(", имя вкладчика='").append(depositor).append('\'');
        sb.append(", номер счета=").append(accountId);
        sb.append(", сумма вклада =").append(amountOnDeposit);
        sb.append(", годовой процент=").append(profitability);
        sb.append(", срок вклада=").append(timeConstrains);
        sb.append(']');
        return sb.toString();
    }
}
