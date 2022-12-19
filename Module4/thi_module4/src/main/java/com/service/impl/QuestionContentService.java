package com.service.impl;

import com.model.QuestionContent;
import com.model.QuestionType;
import com.repository.IQuestionContentRepository;
import com.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionContentService implements IQuestionContentService {
    @Autowired
    private IQuestionContentRepository questionContentRepository;

    @Override
    public Page<QuestionContent> findByTitleContainingAndQuestionType(String title, QuestionType questionType, Pageable pageable) {
        return questionContentRepository.findByTitleContainingAndQuestionType(title, questionType, pageable);
    }

    @Override
    public Page<QuestionContent> findByTitleContaining(String title, Pageable pageable) {
        return questionContentRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public void delete(Integer id) {
        questionContentRepository.deleteById(id);
    }


    @Override
    public QuestionContent findByID(Integer id) {
        return questionContentRepository.findById(id).get();
    }
}
