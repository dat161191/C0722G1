package com.example.cinema.model;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE name_movie SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class NameMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "nameMovie")
    private Set<Cinema> cinema;
    private boolean deleted=false;
}
