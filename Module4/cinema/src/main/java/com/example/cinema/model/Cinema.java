package com.example.cinema.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE cinema SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
//public class Cinema implements Validator {
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Pattern(regexp = "[C][I][-][0-9]{4}", message = "Please enter the correct format!!!")
    private String code;
    @ManyToOne
    private NameMovie nameMovie;
    @Column(columnDefinition = "date")
    private String date;
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer count;
    private boolean deleted = false;
}
