package com.cham.api.voyages.model;

import javax.persistence.*;

@Entity
@Table(name = "destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "article")
    private String article;

    @Column(name = "year")
    private int year;

    @Column(name = "image")
    private String image;

    // @Type(type = "T")
    @Column(name = "currency")
    private String currency;

    public Destination() {
    }

    public Destination(String title, String article, int year, String image, String currency) {
        this.title = title;
        this.article = article;
        this.year = year;
        this.image = image;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", article='" + article + '\'' +
                ", year=" + year +
                ", image='" + image + '\'' +
                ", currency=" + currency +
                '}';
    }
}
