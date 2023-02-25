package by.vladsimonenko.thirdlab.variantA.entity;

import java.util.Objects;

/**
 * Class that stores information about bank account
 */
public class BankInformation {
    private String address;
    private long creditCardNumber;
    private String bankAccountNumber;

    public BankInformation(String address, long creditCardNumber, String bankAccountNumber) {
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    public BankInformation() {
        super();
    }

    public BankInformation(BankInformation information) {
        this.address = information.address;
        this.creditCardNumber = information.creditCardNumber;
        this.bankAccountNumber = information.bankAccountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankInformation that = (BankInformation) o;

        if (creditCardNumber != that.creditCardNumber) return false;
        if (!Objects.equals(address, that.address)) return false;
        return Objects.equals(bankAccountNumber, that.bankAccountNumber);
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (int) (creditCardNumber ^ (creditCardNumber >>> 32));
        result = 31 * result + (bankAccountNumber != null ? bankAccountNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber='" + bankAccountNumber + '\'';
    }
}

