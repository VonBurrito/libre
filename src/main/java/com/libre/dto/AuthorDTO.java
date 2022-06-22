package com.libre.dto;

import com.libre.model.Periodic;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Hamza Amentag
 * @since 6/22/2022
 */
public class AuthorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String nationality;
    private List<Periodic> periodics;

    public AuthorDTO() {
    }

    public AuthorDTO(String firstName, String lastName, LocalDate dob, String nationality, List<Periodic> periodics) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.nationality = nationality;
        this.periodics = periodics;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Periodic> getPeriodics() {
        return periodics;
    }

    public void setPeriodics(List<Periodic> periodics) {
        this.periodics = periodics;
    }
}
