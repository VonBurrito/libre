package com.libre.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author Hamza Amentag
 * @since 6/24/2022
 */
@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToMany
    @JoinTable(
            name = "RESERVATION_BOOK",
            joinColumns = @JoinColumn(name = "RESERVATION_ID"),
            inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Book> books;

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Set<Book> getDocuments() {
        return books;
    }

    public void setDocuments(Set<Book> documents) {
        this.books = documents;
    }
}
