package by.vladsimonenko.thirteenthlab.handler;

import by.vladsimonenko.thirteenthlab.entity.Bank;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class BankDomBuilder {
    private Set<Bank> banks;
    private DocumentBuilder docBuilder;
    public BankDomBuilder() {
        banks = new HashSet<Bank>();
// configuration
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // log
        }
    }
    public Set<Bank> getBanks() {
        return banks;
    }
    public void buildSetBanks(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList banksList = root.getElementsByTagName("bank");
            for (int i = 0; i < banksList.getLength(); i++) {
                Element bankElement = (Element) banksList.item(i);
                Bank student = buildBank(bankElement);
                banks.add(student);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Bank buildBank(Element bankElement) {
        Bank bank = new Bank();
        bank.setName(getElementTextContent(bankElement,"name"));
        bank.setCountry(getElementTextContent(bankElement,"country"));
        bank.setType(getElementTextContent(bankElement,"type"));
        bank.setDepositor(getElementTextContent(bankElement,"depositor"));
        bank.setAccountId(Integer.parseInt(getElementTextContent(bankElement,"accountId")));
        bank.setAmountOnDeposit(Double.parseDouble(getElementTextContent(bankElement,"amountOnDeposit")));
        bank.setProfitability(Double.parseDouble(getElementTextContent(bankElement,"profitability")));
        bank.setTimeConstrains(Integer.parseInt(getElementTextContent(bankElement,"timeConstraints")));
        return bank;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element,
                                                String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

