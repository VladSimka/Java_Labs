package by.vladsimonenko.thirdlab.variantA.action;

import by.vladsimonenko.thirdlab.variantA.entity.Customer;

import java.util.Scanner;

/**
 * Class - action for interaction with Customer
 */
public class CustomerAction {

    /**
     * Method for displaying Customer array
     *
     * @param customers Customer array
     */
    public void showCustomers(Customer[] customers) {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    /**
     * Method that sort the array in alphabet order by bubble
     *
     * @param customers Customer array
     */
    public void sortInAlphabetOrder(Customer[] customers) {
        for (int i = 0; i < customers.length; i++) {
            for (int j = 0; j < customers.length - 1; j++) {
                if ((customers[i].getSurname()).compareTo(customers[j].getSurname()) < 0) {
                    Customer tmp = customers[i];
                    customers[i] = customers[j];
                    customers[j] = tmp;
                }
                if ((customers[i].getSurname().compareTo(customers[j].getSurname()) == 0) &&
                        (customers[i].getName().compareTo(customers[j].getName()) > 0)) {
                    Customer tmp = customers[i];
                    customers[i] = customers[j];
                    customers[j] = tmp;
                }
                if ((customers[i].getSurname().compareTo(customers[j].getSurname()) == 0) &&
                        (customers[i].getName().compareTo(customers[j].getName()) == 0) &&
                        (customers[i].getPatronymic().compareTo(customers[j].getPatronymic()) > 0)
                ) {
                    Customer tmp = customers[i];
                    customers[i] = customers[j];
                    customers[j] = tmp;
                }
            }
        }
    }

    /**
     * Method that shows users with a creditCardNumber in a given range
     *
     * @param customers Customer array
     */
    public void showInTheGivenRange(Customer[] customers) {
        Scanner scanner = new Scanner(System.in);
        long lowerLimit;
        long upperLimit;
        while (true) {
            System.out.println("Введите границы интервала (нули, если хотите выйти)");
            lowerLimit = scanner.nextLong();
            upperLimit = scanner.nextLong();
            if (Math.pow(lowerLimit, 2) + Math.pow(upperLimit, 2) == 0) {
                break;
            }

            System.out.println("Пользователи с номером карты в заданном диапазоне");
            for (Customer customer : customers) {
                if (customer.getCreditCardNumber() > lowerLimit && customer.getCreditCardNumber() < upperLimit) {
                    System.out.println(customer);
                }
            }

        }


    }
}
