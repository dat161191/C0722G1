package com.repository;

import com.model.QuestionContent;
import com.model.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionContentRepository extends JpaRepository<QuestionContent,Integer> {
    Page<QuestionContent> findByTitleContainingAndQuestionType(String title, QuestionType questionType, Pageable pageable);
    Page<QuestionContent> findByTitleContaining(String title,Pageable pageable);

}
