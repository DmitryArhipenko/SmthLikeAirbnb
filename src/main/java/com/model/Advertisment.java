package com.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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

    @ElementCollection
    private List<Image> images = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Advertisment() {
    }

    public Advertisment(String title, ApartmentType apartment_type, String city, String address, String description, Date since, Date till, List<Image> image) {

        this.title = title;
        this.apartment_type = apartment_type;
        this.city = city;
        this.address = address;
        this.description = description;
        this.since = since;
        this.till = till;
        this.images = image;

    }

    @JoinTable(name = "advertisment_images",
            joinColumns = @JoinColumn(name = "advertisment_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
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
                ", image=" + images +
                '}';
    }
}
