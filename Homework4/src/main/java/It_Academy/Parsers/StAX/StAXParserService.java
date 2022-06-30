package It_Academy.Parsers.StAX;

import It_Academy.Entity.Article;
import It_Academy.Entity.Contact;
import It_Academy.Entity.Journal;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;
import java.util.List;

import static javax.xml.stream.XMLStreamConstants.*;

public class StAXParserService {
    List<Journal> journalList = new ArrayList<>();
    List<Article> articleList = new ArrayList<>();
    Article currArticle = null;
    List<Contact> contactList = new ArrayList<>();
    Contact currContact = null;
    String tagContent = null;

    public Journal StAXSwitchMenuRunner(Journal currJournal, XMLStreamReader reader) throws XMLStreamException {
        int interaction = 0;
        while (reader.hasNext()) {
            int event = reader.next();
            switch (event) {
                case START_ELEMENT:
                    if ("contacts".equals(reader.getLocalName())) {
                        currContact = new Contact();
                    }
                    if ("article".equals(reader.getLocalName())) {
                        currArticle = new Article();
                        currArticle.setId(reader.getAttributeValue(0));
                    }
                    break;

                case CHARACTERS:
                    tagContent = reader.getText().trim();
                    break;

                case END_ELEMENT:
                    if (interaction < 30) {
                        switch (reader.getLocalName()) {
                            case "title" -> currJournal.setTitle(tagContent);
                            case "address" -> currContact.setAddress(tagContent);
                            case "tel" -> currContact.setTelephone(tagContent);
                            case "email" -> currContact.setEmail(tagContent);
                            case "url" -> currContact.setUrl(tagContent);
                            case "contacts" -> {
                                currJournal.Contact.add(currContact);
                                contactList.add(currContact);
                            }
                            case "author" -> currArticle.setAuthor(tagContent);
                            case "article" -> {
                                currJournal.Article.add(currArticle);
                                articleList.add(currArticle);
                            }
                            case "hotkey" -> currArticle.hotkey.add(tagContent);
                            case "journal" -> journalList.add(currJournal);
                        }
                    } else {
                        switch (reader.getLocalName()) {
                            case "address" -> currContact.setAddress(tagContent);
                            case "tel" -> currContact.setTelephone(tagContent);
                            case "email" -> currContact.setEmail(tagContent);
                            case "contacts" -> {
                                currJournal.Contact.add(currContact);
                                contactList.add(currContact);
                            }
                            case "title" -> currArticle.setTitle(tagContent);
                            case "author" -> currArticle.setAuthor(tagContent);
                            case "url" -> currArticle.setUrl(tagContent);
                            case "article" -> {
                                currJournal.Article.add(currArticle);
                                articleList.add(currArticle);
                            }
                            case "hotkey" -> currArticle.hotkey.add(tagContent);
                            case "journal" -> journalList.add(currJournal);
                        }
                    }
            }
            interaction++;
        }
        return currJournal;
    }
}


