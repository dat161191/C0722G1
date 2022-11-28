package com.example.blog_modal.model;

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

    public Blog() {
    }

    public Blog(Integer id, String blogName, String content, String author, String dateWriting) {
        this.id = id;
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.dateWriting = dateWriting;

    }

    public Blog(String blogName, String content, String author, String dateWriting) {
        this.blogName = blogName;
        this.content = content;
        this.author = author;
        this.dateWriting = dateWriting;

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
