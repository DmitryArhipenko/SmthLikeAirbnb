package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "advertisments")
public class Advertisment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "apartment_type")
    private ApartmentType apartment_type;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "since")
    private Date since;

    @Column(name = "till")
    private Date till;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ElementCollection
    private Map<Date, Long> days_reserved = new HashMap<Date, Long>();

    @JsonBackReference
    @ManyToMany(mappedBy="advertisment")
    private Set<Reservation> reservations = new HashSet<Reservation>();

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Advertisment() {
    }

    public Advertisment(String title, ApartmentType apartment_type, String city, String address, String description, Date since, Date till) {

        this.title = title;
        this.apartment_type = apartment_type;
        this.city = city;
        this.address = address;
        this.description = description;
        this.since = since;
        this.till = till;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ApartmentType getApartment_type() {
        return apartment_type;
    }

    public void setApartment_type(ApartmentType apartment_type) {
        this.apartment_type = apartment_type;
    }

    public Date getSince() {
        return since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    public Map<Date, Long> getDays_reserved() {
        return days_reserved;
    }

    public void setDays_reserved(Map<Date, Long> days_reserved) {
        this.days_reserved = days_reserved;
    }

    public Date getTill() {
        return till;
    }

    public void setTill(Date till) {
        this.till = till;
    }

    @Override
    public String toString() {
        return "Advertisment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", apartment_type=" + apartment_type +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", since=" + since +
                ", till=" + till +
                ", user=" + user +
                '}';
    }
}
