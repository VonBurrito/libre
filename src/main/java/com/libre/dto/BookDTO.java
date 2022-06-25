package com.libre.dto;

import com.libre.model.Author;
import com.libre.model.Reservation;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/25/2022
 */
public class BookDTO {

    protected Long id;
    protected String title;
    protected LocalDate publicationDate;
    protected String summary;
    private List<Author> authors;
    private List<Reservation> reservations;

    public BookDTO() {
    }

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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
