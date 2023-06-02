package by.vladsimonenko.thirteenthlab._main;

import by.vladsimonenko.thirteenthlab.entity.Bank;
import by.vladsimonenko.thirteenthlab.handler.BankDomBuilder;
import by.vladsimonenko.thirteenthlab.handler.BanksSTAXBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class XMLSTAXMain {
    public static void main(String[] args) {
        BankDomBuilder staxBuilder = new BankDomBuilder();









        staxBuilder.buildSetBanks("src/main/resources/bank.xml");
        List<Bank> banks = new ArrayList<>(staxBuilder.getBanks());
        banks.sort((Comparator.comparingInt(Bank::getAccountId)));

        for(Bank bank:banks){
            System.out.println(bank);
        }
    }
}
