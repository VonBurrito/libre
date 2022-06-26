package com.libre.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/24/2022
 */
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    protected Long id;

    private String firstname;
    private String lastname;

    @OneToMany(mappedBy = "member")
    private List<Reservation> reservations;

    public Member() {
    }

    public Member(String firstname, List<Reservation> reservations) {
        this.firstname = firstname;
        this.reservations = reservations;
    }

    public Member(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
