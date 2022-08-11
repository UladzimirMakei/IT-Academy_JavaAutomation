package it.academy.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Journal {
    String title;
    public List<Contact> Contact = new ArrayList<>();
    public List<Article> Article = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journal journal = (Journal) o;
        return Objects.equals(title, journal.title) && Objects.equals(Contact, journal.Contact) && Objects.equals(Article, journal.Article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, Contact, Article);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "title='" + title + '\'' +
                ", \nContact=" + Contact + '\'' +
                ", \nArticle=" + Article + '\'' +
                '}';
    }
}
