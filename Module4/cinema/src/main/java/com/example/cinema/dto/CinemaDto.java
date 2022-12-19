package com.example.cinema.dto;

import com.example.cinema.model.Cinema;
import com.example.cinema.model.NameMovie;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.Where;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Where(clause = "deleted=false")
public class CinemaDto implements Validator {
    private Integer id;
    @Pattern(regexp = "[C][I][-][0-9]{4}", message = "Please enter the correct format!!!")
    private String code;
    private NameMovie nameMovie;
    private String date;
    @Min(value = 1, message = "Quantity must be greater than 0")
    private Integer count;
    private boolean deleted = false;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CinemaDto cinema = (CinemaDto) target;
        String dayMovie = cinema.getDate();
        LocalDate dateMovie = LocalDate.parse(dayMovie);
        LocalDate dateNow = LocalDate.now();
        boolean check = dateMovie.isAfter(dateNow);
        if (!check) {
            errors.rejectValue("date", "date", "Show date must be after current date!!!");
        }
    }
}
