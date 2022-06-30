package It_Academy.Parsers.DOM;

import It_Academy.Entity.Article;
import It_Academy.Entity.Contact;
import It_Academy.Entity.Journal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import static It_Academy.Parsers.DOM.DOMParseService.setJournalWithDataFromXML;
import static It_Academy.Parsers.DOM.DOMParserUtils.parseXMLDocument;
import static It_Academy.Parsers.Service.Initialization.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DOMParserMainDemoMethodTest {
    private static final String XML_PATH = "Homework4_Journal.xml";
    static Journal journalCreated = new Journal();
    static Contact contact = new Contact();
    static Article articleOne = new Article();
    static Article articleTwo = new Article();

    @BeforeAll
    public static void initAllObjects() {
        initJournal(journalCreated);
        initContact(contact);
        initArticles(articleOne, articleTwo);
        journalCreated.Contact.add(contact);
        journalCreated.Article.add(articleOne);
        journalCreated.Article.add(articleTwo);
        // System.out.println(journalCreated);
    }

    @Test
    void testDOMParserObjectFromXMLEqualToCreated() throws InterruptedException {
        Document document = parseXMLDocument(XML_PATH);
        Journal journalXML = new Journal();
        assertThat(setJournalWithDataFromXML(journalXML, document)).withFailMessage("Object Journal received " +
                        "by DOM Parser is not correct").
                isEqualTo(journalCreated);
        Thread.sleep(1000);
    }
}
