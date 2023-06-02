package by.vladsimonenko.thirteenthlab.pdf;

import org.apache.fop.apps.*;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.net.Socket;

public class XmlToPdf {
    public static void main(String[] args) {
       createPdf();
    }

    static void createPdf(){
        try {
            File xmlFile = new File("src/main/resources/bankPdf.xml");
            File xslFile = new File("src/main/resources/bankPdf.xsl");
            File pdfDir = new File("data/pdf");

            pdfDir.mkdirs();
            File pdfFile = new File(pdfDir, "bank.pdf");

            final FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();


            OutputStream out = new FileOutputStream(pdfFile);
            out = new BufferedOutputStream(out);

            try {
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xslFile));

                Source src = new StreamSource(xmlFile);

                Result result = new SAXResult(fop.getDefaultHandler());
                transformer.transform(src, result);

            } catch (FOPException | TransformerException e) {
               e.printStackTrace();
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
