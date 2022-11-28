package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "nvarchar(255)")
    private String blogName;
    @Column(columnDefinition = "text")
    private String content;
    private String author;
    @Column(columnDefinition = "date")
    private String dateWriting;
    @ManyToOne
    private Category category;

    public Blog() {
    }

    public Blog(Integer id, String blogName, String content, String author, String dateWriting, Category category) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.dateWriting = dateWriting;
        this.category = category;
    }

    public Blog(String blogName, String content, String author, String dateWriting, Category category) {
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.dateWriting = dateWriting;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateWriting() {
        return dateWriting;
    }

    public void setDateWriting(String dateWriting) {
        this.dateWriting = dateWriting;
    }
}
