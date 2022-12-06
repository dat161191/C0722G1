package com.example.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE blog SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")

public class Blog{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String author;
    @Column(columnDefinition = "date")
    private String date;
    @ManyToOne
    private Category category;
    @Column(columnDefinition = "boolean default false")
    private boolean deleted;
}
