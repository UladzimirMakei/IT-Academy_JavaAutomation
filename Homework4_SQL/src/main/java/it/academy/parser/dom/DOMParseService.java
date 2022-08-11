package it.academy.parser.dom;

import it.academy.entity.Article;
import it.academy.entity.Contact;
import it.academy.entity.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import static it.academy.parser.dom.DOMParserUtils.getNodeList;
import static it.academy.parser.dom.DOMParserUtils.getNodeListStream;

public class DOMParseService {

    public static Journal setJournalWithDataFromXML(Journal journal, Document document) {
        NodeList nodeList = getNodeList(document);
        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i) instanceof Element) {
                DOMParseService.setJournalWithNodeValues(journal, nodeList.item(i));
            }
        }
        return journal;
    }

    public static void setJournalWithNodeValues(Journal journal, Node node) {
        String content = node.getLastChild().getTextContent().trim();
        switch (node.getNodeName()) {
            case "title" -> journal.setTitle(content);
            case "contacts" -> {
                NodeList contactNodelist = node.getChildNodes();
                journal.Contact.add(setContactsWithXMLNodeValues(contactNodelist));
            }
            case "articles" -> {
                NodeList articlesNodelist = node.getChildNodes();
                setArticlesWithXMLNodeValues(journal, articlesNodelist);
            }
        }
    }

    public static void setArticlesWithXMLNodeValues(Journal journal, NodeList nodeList) {
        getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                if (node.getAttributes().getNamedItem("ID").getNodeValue() != null) {
                    Article article = new Article();
                    article.setId(node.getAttributes().getNamedItem("ID").getNodeValue());
                    NodeList childNodes = node.getChildNodes();
                    getNodeListStream(childNodes).forEach(childNode -> {
                        if (childNode instanceof Element) {
                            setArticleWithXMLChildNodeValues(article, childNode);
                        }
                    });
                    journal.Article.add(article);
                }
            }
        });
    }

    public static void setArticleWithXMLChildNodeValues(Article article, Node node) {
        String content = node.getLastChild().getTextContent().trim();
        switch (node.getNodeName()) {
            case "title" -> article.setTitle(content);
            case "author" -> article.setAuthor(content);
            case "url" -> article.setUrl(content);
            case "hotkeys" -> {
                NodeList hotkeyNodelist = node.getChildNodes();
                setHotkeysWithXMLNodeValues(article, hotkeyNodelist);
            }
        }
    }

    public static Contact setContactsWithXMLNodeValues(NodeList nodeList) {
        Contact contact = new Contact();
        getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                String content = node.getLastChild().getTextContent().trim();
                switch (node.getNodeName()) {
                    case "address" -> contact.setAddress(content);
                    case "tel" -> contact.setTelephone(content);
                    case "email" -> contact.setEmail(content);
                    case "url" -> contact.setUrl(content);
                }
            }
        });
        return contact;
    }

    public static void setHotkeysWithXMLNodeValues(Article article, NodeList nodeList) {
        getNodeListStream(nodeList).forEach(node -> {
            if (node instanceof Element) {
                String content = node.getLastChild().getTextContent().trim();
                if ("hotkey".equals(node.getNodeName())) {
                    article.hotkey.add(content);
                }
            }
        });
    }
}
