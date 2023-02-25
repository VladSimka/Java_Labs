package by.vladsimonenko.thirdlab.variantA._main;


import by.vladsimonenko.thirdlab.variantA.action.CustomerAction;
import by.vladsimonenko.thirdlab.variantA.entity.Customer;
import by.vladsimonenko.thirdlab.variantA.reader.Reader;

import java.io.IOException;

/**
 * Class with main method for variantA
 */
public class CustomerMain {

    static final String path = "data.txt";

    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[Reader.getLineCountByReader(path)];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer();
        }
        CustomerAction action = new CustomerAction();
        Reader.createCustomersArray(path, customers);
        action.sortInAlphabetOrder(customers);
        System.out.println();
        action.showCustomers(customers);
        System.out.println();
        action.showInTheGivenRange(customers);


    }
}
