package by.vladsimonenko.thirteenthlab.handler;

import by.vladsimonenko.thirteenthlab.entity.Bank;
import org.xml.sax.XMLReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BanksSTAXBuilder {
    private Set<Bank> banks;
    private XMLInputFactory inputFactory;

    public BanksSTAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        banks = new HashSet<Bank>();
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void buildSetBanks(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(BankXmlTag.BANKS.getValue())) {
                        Bank bank = buildBank(reader);
                        banks.add(bank);
                    }
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }

    private Bank buildBank(XMLStreamReader reader) throws XMLStreamException {
        Bank bank = new Bank();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (BankXmlTag.valueOf(name.toUpperCase())) {
                        case NAME -> bank.setName(getXMLText(reader));
                        case TYPE -> bank.setType(getXMLText(reader));
                        case COUNTRY -> bank.setCountry(getXMLText(reader));
                        case ACCOUNTID -> bank.setAccountId(Integer.parseInt(getXMLText(reader)));
                        case DEPOSITOR -> bank.setDepositor(getXMLText(reader));
                        case PROFITABILITY -> bank.setProfitability(Double.parseDouble(getXMLText(reader)));
                        case AMOUNTONDEPOSIT -> bank.setAmountOnDeposit(Double.parseDouble(getXMLText(reader)));
                        case TIMECONSTRAINTS -> bank.setTimeConstrains(Integer.parseInt(getXMLText(reader)));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (BankXmlTag.valueOf(name.toUpperCase()) == BankXmlTag.BANK) {
                        return bank;
                    }
            }
        }
        throw new XMLStreamException();
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }


}
