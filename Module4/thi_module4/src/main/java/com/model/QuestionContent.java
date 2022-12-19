package com.model;
import com.sun.istack.NotNull;
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
@SQLDelete(sql = "UPDATE question_content SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "text")
    private String title;
    @Column(columnDefinition = "text")
    private String content;
    @Column(columnDefinition = "text")
    private String answer;
    @Column(columnDefinition = "date")
    private String dateCreate;
    private boolean status=false;
    private boolean deleted = false;
    @ManyToOne
    private QuestionType questionType;
}
