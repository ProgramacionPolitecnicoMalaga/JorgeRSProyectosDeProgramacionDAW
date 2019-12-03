import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;

public class LeerXML {

    public NodeList leer(String nombreFichero) {
        try {
            String dir= System.getProperty("user.dir");
            File inputFile = new File(dir + File.separator + nombreFichero);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            XPath xPath = XPathFactory.newInstance().newXPath();
            return (NodeList) xPath.compile("/proyectos/proyecto").evaluate(doc, XPathConstants.NODESET);
        } catch (Throwable t) {
            return null;
        }
    }
}
