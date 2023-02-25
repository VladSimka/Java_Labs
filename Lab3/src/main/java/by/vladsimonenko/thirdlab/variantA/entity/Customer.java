package by.vladsimonenko.thirdlab.variantA.entity;

import java.util.Objects;

/**
 * Class - entity that stores information about bank user
 */

public class Customer {
    private int id;
    private Person person;
    private BankInformation information;


    public Customer(int id, String surname, String name, String patronymic, String address, long creditCardNumber, String bankAccountNumber) {
        this.id = id;
        this.person = new Person(surname, name, patronymic);
        this.information = new BankInformation(address, creditCardNumber, bankAccountNumber);
    }

    public Customer(Customer customer) {
        this.id = customer.id;
        this.person = new Person(customer.person);
        this.information = new BankInformation(customer.information);
    }

    public Customer() {
        super();
        person = new Person();
        information = new BankInformation();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setSurname(String surname) {
        person.setSurname(surname);
    }

    public String getSurname() {
        return person.getSurname();
    }

    public void setName(String name) {
        person.setName(name);
    }

    public String getName() {
        return person.getName();
    }

    public void setPatronymic(String patronymic) {
        person.setPatronymic(patronymic);
    }

    public String getPatronymic() {
        return person.getPatronymic();
    }

    public void setAddress(String address) {
        information.setAddress(address);
    }

    public String getAddress() {
        return information.getAddress();
    }

    public void setCreditCardNumber(long creditCardNumber) {
        information.setCreditCardNumber(creditCardNumber);
    }

    public long getCreditCardNumber() {
        return information.getCreditCardNumber();
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        information.setBankAccountNumber(bankAccountNumber);
    }

    public String getBankAccountNumber() {
        return information.getBankAccountNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != customer.id) return false;
        if (!Objects.equals(person, customer.person)) return false;
        return Objects.equals(information, customer.information);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (information != null ? information.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer[" +
                "id=" + id +
                "," + person +
                "," + information +
                ']';
    }
}
