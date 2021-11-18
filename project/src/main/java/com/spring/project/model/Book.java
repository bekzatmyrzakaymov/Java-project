package com.spring.project.model;


import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    @Column(name="image", columnDefinition = "TEXT")
    private String image;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name="descritption",columnDefinition = "TEXT")
    private String description;
    @Column(name = "price")
    private Integer price;


    public Book() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
