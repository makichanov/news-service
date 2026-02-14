package com.makichanov.news.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class NewsRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "news_seq")
    @SequenceGenerator(name = "news_seq", sequenceName = "news_record_seq", allocationSize = 1)
    private long id;

    private String title;

    private String description;

    public long getId() {
        return id;
    }


    public NewsRecord() {
    }

    public NewsRecord(String description, String title, long id) {
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public NewsRecord(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NewsRecord that = (NewsRecord) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description);
    }

    @Override
    public String toString() {
        return "NewsRecord{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            '}';
    }
}
