package by.vladsimonenko.thirteenthlab._main;

import by.vladsimonenko.thirteenthlab.entity.Bank;
import by.vladsimonenko.thirteenthlab.handler.BankDomBuilder;
import by.vladsimonenko.thirteenthlab.parser.BanksSaxBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class XMLSAXMain {
    public static void main(String[] args) {
        BankDomBuilder saxBuilder = new BankDomBuilder();





        saxBuilder.buildSetBanks("src/main/resources/bank.xml");


        List<Bank> banks = new ArrayList<>(saxBuilder.getBanks());
        banks.sort((Comparator.comparingInt(Bank::getAccountId)));

        for(Bank bank:banks){
            System.out.println(bank);
        }
    }
}
