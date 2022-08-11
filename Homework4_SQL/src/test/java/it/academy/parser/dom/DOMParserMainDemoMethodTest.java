package it.academy.parser.dom;

import it.academy.entity.Article;
import it.academy.entity.Contact;
import it.academy.entity.Journal;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import static it.academy.parser.dom.DOMParseService.setJournalWithDataFromXML;
import static it.academy.parser.dom.DOMParserUtils.parseXMLDocument;
import static it.academy.parser.service.Initialization.*;
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
