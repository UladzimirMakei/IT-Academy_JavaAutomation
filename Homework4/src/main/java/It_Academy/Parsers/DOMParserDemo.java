package It_Academy.Parsers;

import It_Academy.Entity.Journal;
import org.w3c.dom.*;

import static It_Academy.Parsers.DOM.DOMParseService.setJournalWithDataFromXML;
import static It_Academy.Parsers.DOM.DOMParserUtils.*;
import static java.lang.System.out;

public class DOMParserDemo {
    private static final String XML_PATH = "Homework4_Journal.xml";

    public static void main(String[] args) {
        Document document = parseXMLDocument(XML_PATH);
        Journal journal = new Journal();
        setJournalWithDataFromXML(journal, document);
        out.println("DOM Parser in home-task #4\n" + "-----------------------------------\n"
                + journal + "\n-----------------------------------");
    }
}