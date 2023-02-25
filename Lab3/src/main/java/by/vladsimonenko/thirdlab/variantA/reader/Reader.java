package by.vladsimonenko.thirdlab.variantA.reader;

import by.vladsimonenko.thirdlab.variantA.entity.Customer;

import java.io.*;
import java.util.Scanner;

/**
 * Class - action that read information from file
 */
public class Reader {

    /**
     * Method find how many strings there are in file
     *
     * @return number of lines in the file
     */
    public static int getLineCountByReader(String fileName) throws IOException {
        try (var lnr = new LineNumberReader(new BufferedReader(new FileReader(fileName)))) {
            while (lnr.readLine() != null) ;
            return lnr.getLineNumber();
        }
    }


    /**
     * Method reads information from a file and puts it into a Customer array
     *
     * @param path      the path to the file
     * @param customers Customer array
     */
    public static void createCustomersArray(String path, Customer[] customers) throws IOException {

        File file = new File(path);
        Scanner scanner = new Scanner(file);
        String line;
        String[] array;
        for (Customer customer : customers) {
            line = scanner.nextLine();
            array = line.split(" ");
            customer.setId(Integer.parseInt(array[0]));
            customer.setSurname(array[1]);
            customer.setName(array[2]);
            customer.setPatronymic(array[3]);
            customer.setAddress(array[4]);
            customer.setCreditCardNumber(Long.parseLong(array[5]));
            customer.setBankAccountNumber(array[6]);
        }


        scanner.close();
    }


}
