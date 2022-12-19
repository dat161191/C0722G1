package com.dto;
import com.model.QuestionType;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionContentDto {
    private Integer id;
    @NotNull(message = "Cannot be left blank")
    @Size(min = 5,max = 100)
    private String title;
    @NotNull(message = "Cannot be left blank")
    @Size(min = 10,max = 500)
    private String content;
    private String answer;
    private String dateCreate;
    private boolean status;
    private QuestionType questionType;
}
