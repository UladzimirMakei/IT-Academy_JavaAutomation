package it.academy.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Article {
    private String id;
    private String title;
    private String author;
    private String url;
    public List<String> hotkey = new ArrayList<>();

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id)
                && Objects.equals(title, article.title)
                && Objects.equals(author, article.author) && Objects.equals(url, article.url)
                && Objects.equals(hotkey, article.hotkey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, url, hotkey);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "\nArticle{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", hotkey=" + hotkey +
                '}';
    }
}
