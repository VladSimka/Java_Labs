package by.vladsimonenko.thirteenthlab.parser;

import by.vladsimonenko.thirteenthlab.entity.Bank;
import by.vladsimonenko.thirteenthlab.handler.BanksHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class BanksSaxBuilder {
    static final Logger logger = LogManager.getLogger();
    private Set<Bank> banks;
    private BanksHandler handler = new BanksHandler();
    private XMLReader reader;
    public BanksSaxBuilder(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            logger.error(e.getMessage());
            //reader.setErrorHandler();
            reader.setContentHandler(handler);
        }
    }
    public Set<Bank> getBanks(){
        return banks;
    }

    public void buildSetBanks(String filename){
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            logger.error(e.getMessage());
        }
        banks = handler.getBanks();
    }


}
