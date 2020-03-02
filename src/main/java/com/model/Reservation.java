package com.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private User client;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "advertisment_id")
    private Set<Advertisment> advertisment = new HashSet<Advertisment>();

    @Column(name = "reservation_since")
    private Date reservetion_since;

    @Column(name = "reservation_till")
    private Date reservetion_till;

    public Reservation() {
    }

    public Reservation(int id, User client, Date reservetion_since, Date reservetion_till) {
        this.id = id;
        this.client = client;
        this.reservetion_since = reservetion_since;
        this.reservetion_till = reservetion_till;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Date getReservetion_since() {
        return reservetion_since;
    }

    public void setReservetion_since(Date reservetion_since) {
        this.reservetion_since = reservetion_since;
    }

    public Date getReservetion_till() {
        return reservetion_till;
    }

    public void setReservetion_till(Date reservetion_till) {
        this.reservetion_till = reservetion_till;
    }

    public Set<Advertisment> getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(Set<Advertisment> advertisment) {
        this.advertisment = advertisment;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", client=" + client +
                ", reservetion_since=" + reservetion_since +
                ", reservetion_till=" + reservetion_till +
                '}';
    }
}
