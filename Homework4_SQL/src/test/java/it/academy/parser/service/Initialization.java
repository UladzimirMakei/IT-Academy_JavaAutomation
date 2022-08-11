package it.academy.parser.service;

import it.academy.entity.Article;
import it.academy.entity.Contact;
import it.academy.entity.Journal;

public class Initialization {

    public static void initJournal(Journal journal) {
        journal.setTitle("Very Useful Journal");
    }

    public static void initContact(Contact contact) {
        contact.setAddress("Minsk");
        contact.setTelephone("8-3232-121212");
        contact.setEmail("j@j.com");
        contact.setUrl("www.j.com");
    }

    public static void initArticles(Article articleOne, Article articleTwo) {
        articleOne.setId("1");
        articleOne.setTitle("Issue overview");
        articleOne.setAuthor("Jhon");
        articleOne.setUrl("/article1");
        articleOne.hotkey.add("language");
        articleOne.hotkey.add("marckup");
        articleOne.hotkey.add("hypertext");
        articleTwo.setId("2");
        articleTwo.setTitle("Latest reviews");
        articleTwo.setAuthor("Mike");
        articleTwo.setUrl("/article2");
        articleTwo.hotkey.add("marckup");
        articleTwo.hotkey.add("hypertext");
    }
}
