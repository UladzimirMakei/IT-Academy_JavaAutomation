package It_Academy.Parsers.StAX;

import It_Academy.Entity.Article;
import It_Academy.Entity.Contact;
import It_Academy.Entity.Journal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import static It_Academy.Parsers.Service.Initialization.*;
import static org.assertj.core.api.Assertions.assertThat;

class StAXParserTest {
    private static final String XML_PATH = "Homework4_Journal.xml";
    static Journal journalCreated = new Journal();
    static Contact contact = new Contact();
    static Article articleOne = new Article();
    static Article articleTwo = new Article();

    @BeforeAll
    public static void init() {
        initJournal(journalCreated);
        initContact(contact);
        initArticles(articleOne, articleTwo);
        journalCreated.Contact.add(contact);
        journalCreated.Article.add(articleOne);
        journalCreated.Article.add(articleTwo);
        // System.out.println(journalCreated);
    }

    @Test
    void testStAXParserObjectFromXMLEqualToCreated() throws InterruptedException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(XML_PATH));
        Journal journalXML = new Journal();
        StAXParserService StaxRunner = new StAXParserService();
        assertThat(StaxRunner.StAXSwitchMenuRunner(journalXML, reader)).withFailMessage("Object Journal received " +
                        "by StAX Parser is not correct").
                isEqualTo(journalCreated);
        Thread.sleep(1000);
    }
}