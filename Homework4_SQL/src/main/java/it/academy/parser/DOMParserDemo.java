package it.academy.parser;

import it.academy.entity.Journal;
import it.academy.parser.dom.DOMParseService;
import it.academy.parser.dom.DOMParserUtils;
import org.w3c.dom.*;

import static java.lang.System.out;

public class DOMParserDemo {
    private static final String XML_PATH = "Homework4_Journal.xml";

    public static void main(String[] args) {
        Document document = DOMParserUtils.parseXMLDocument(XML_PATH);
        Journal journal = new Journal();
        DOMParseService.setJournalWithDataFromXML(journal, document);
        out.println("DOM Parser in home-task #4\n" + "-----------------------------------\n"
                + journal + "\n-----------------------------------");
    }
}