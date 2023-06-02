package by.vladsimonenko.thirteenthlab.handler;

import by.vladsimonenko.thirteenthlab.entity.Bank;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class BanksHandler extends DefaultHandler {
    private Set<Bank> banks;
    private Bank current;
    private BankXmlTag currentXmlTag;
    private EnumSet<BankXmlTag> withText;
    private static final String ELEMENT_BANK = "bank";

    public BanksHandler() {
        banks = new HashSet<Bank>();
        withText = EnumSet.range(BankXmlTag.NAME, BankXmlTag.TIMECONSTRAINTS);
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_BANK.equals(qName)) {
            current = new Bank();
            if (attrs.getLength() == 2) { // warning!!!!
                //current.setFaculty(attrs.getValue(1));
            }
        } else {
            BankXmlTag temp = BankXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_BANK.equals(qName)) {
            banks.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case NAME -> current.setName(data);
                case TYPE -> current.setType(data);
                case COUNTRY -> current.setCountry(data);
                case ACCOUNTID -> current.setAccountId(Integer.parseInt(data));
                case DEPOSITOR -> current.setDepositor(data);
                case PROFITABILITY -> current.setProfitability(Double.parseDouble(data));
                case AMOUNTONDEPOSIT -> current.setAmountOnDeposit(Double.parseDouble(data));
                case TIMECONSTRAINTS -> current.setTimeConstrains(Integer.parseInt(data));
                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}