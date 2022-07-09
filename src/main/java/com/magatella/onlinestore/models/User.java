package com.magatella.onlinestore.models;

import javax.persistence.*;

@Entity
@Table(name="user_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private Long id;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "firstname")
    private String Firstname;

    @Column(name = "lastname")
    private String Lastname;

    public User() {
    }

    public User(Long id, String surname, String firstname, String lastname) {
        this.id = id;
        Surname = surname;
        Firstname = firstname;
        Lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }
}
