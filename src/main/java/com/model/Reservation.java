package com.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "host_id")
    private User host;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private User client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertisment_id")
    private Advertisment advertisment;

    @Column(name = "reservation_since")
    private Date reservetion_since;

    @Column(name = "reservation_till")
    private Date reservetion_till;

    public Reservation() {
    }

    public Reservation(User host, User client, Advertisment advertisment, Date reservetion_since, Date reservetion_till) {
        this.host = host;
        this.client = client;
        this.advertisment = advertisment;
        this.reservetion_since = reservetion_since;
        this.reservetion_till = reservetion_till;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Advertisment getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(Advertisment advertisment) {
        this.advertisment = advertisment;
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

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", host=" + host +
                ", client=" + client +
                ", advertisment=" + advertisment +
                ", reservetion_since=" + reservetion_since +
                ", reservetion_till=" + reservetion_till +
                '}';
    }
}
