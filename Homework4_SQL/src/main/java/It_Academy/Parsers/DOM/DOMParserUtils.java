package It_Academy.Parsers.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DOMParserUtils {
    public static DocumentBuilder createDocumentBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            return factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            System.out.println("ParserConfigurationException log");
            return null;
        }
    }

    public static Document parseXMLDocument(String path) {
        DocumentBuilder documentBuilder = createDocumentBuilder();
        Document document = null;
        if (null != documentBuilder) {
            try {
                document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(path));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception log");
            }
        }
        return document;
    }

    public static NodeList getNodeList(Document document) {
        return document.getDocumentElement().getChildNodes();
    }

    public static Stream<Node> getNodeListStream(NodeList nodeList) {
        return IntStream.range(0, nodeList.getLength())
                .mapToObj(nodeList::item);
    }
}
