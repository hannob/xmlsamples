// SPDX-License-Identifier: 0BSD

import java.io.IOException;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.Transformer;
import javax.xml.XMLConstants;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

class javaxml {
    public static void main(String[] argv) {

        try {
            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();

            // Different variations to secure against XXE, see also:
            // https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html#java

            // Disable DOCTYPE entirely
            // dbfactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            // Disable Entities and DTD loading
            // dbfactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            // dbfactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            // dbfactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

            // Poorly documented what this does exactly...
            // https://docs.oracle.com/en/java/javase/11/docs/api/java.xml/javax/xml/XMLConstants.html#FEATURE_SECURE_PROCESSING
            // dbfactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder builder = dbfactory.newDocumentBuilder();
            Document doc = builder.parse(new File(argv[0]));

            DOMSource dom = new DOMSource(doc);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(dom, new StreamResult(System.out));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }

    }

}
