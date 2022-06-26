package com.libre.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */
@Entity
public class Book extends Document implements Serializable {

    @JsonIgnore
    @Column(name = "AUTORS")
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @JsonIgnore
    @ManyToMany
    private List<Reservation> reservations;

    public Book() {
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
