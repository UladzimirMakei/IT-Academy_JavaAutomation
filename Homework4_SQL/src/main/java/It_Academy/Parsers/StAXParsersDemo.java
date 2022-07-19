package It_Academy.Parsers;

import It_Academy.Entity.Journal;
import It_Academy.Parsers.StAX.StAXParserService;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import static java.lang.System.out;

public class StAXParsersDemo {
    private static final String XML_PATH = "Homework4_Journal.xml";

    public static void main(String[] args) throws XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(XML_PATH));
        StAXParserService StaxRunner = new StAXParserService();
        Journal journal = new Journal();
        StaxRunner.StAXSwitchMenuRunner(journal, reader);
        out.println("StAX Parser in home-task #4\n" + "-----------------------------------\n" +
                journal + "\n-----------------------------------");
    }
}
