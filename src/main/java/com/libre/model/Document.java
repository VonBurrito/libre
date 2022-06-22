package com.libre.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */

@MappedSuperclass
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "TITLE")
    protected String title;

    @Column(name = "PUBLICATION_DATE")
    protected LocalDate publicationDate;

    @Column(name = "SUMMARY")
    protected String summary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
