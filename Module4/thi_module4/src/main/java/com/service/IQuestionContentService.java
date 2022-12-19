package com.service;

import com.model.QuestionContent;
import com.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuestionContentService {
    Page<QuestionContent> findByTitleContainingAndQuestionType(String title, QuestionType questionType, Pageable pageable);
    Page<QuestionContent> findByTitleContaining(String title,Pageable pageable);
    void save(QuestionContent questionContent);

    void delete(Integer id);

    QuestionContent findByID(Integer id);

}
