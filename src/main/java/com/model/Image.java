package com.model;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "path")
    private String path;

    @ManyToOne
    private Advertisment advertisment;

    public Image(){}

    public Image(String path, Advertisment advertisment){
        this.path = path;
        this.advertisment = advertisment;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Advertisment getAdvertisment() {
        return advertisment;
    }

    public void setAdvertisment(Advertisment advertisment) {
        this.advertisment = advertisment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Image{" +
                "path='" + path + '\'' +
                ", advertisment=" + advertisment +
                ", id=" + id +
                '}';
    }

}