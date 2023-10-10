package com.project.service;

import java.util.List;

import com.project.Exceptions.QuestionNotFoundException;
import com.project.model.DbmsQuestion;

public interface DbmsQuestionService {

	List<DbmsQuestion> getAllQuestions();

	DbmsQuestion getQuestionById(Long id) throws QuestionNotFoundException;

	String createQuestion(DbmsQuestion question);

	String updateQuestion(DbmsQuestion question);

	String deleteQuestion(Long id) throws QuestionNotFoundException;
}
