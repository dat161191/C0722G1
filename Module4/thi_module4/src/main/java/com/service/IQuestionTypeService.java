package com.service;

import com.model.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> findAll();
    QuestionType findById(Integer id);
}
