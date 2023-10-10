package com.project.service;

import java.util.List;

import com.project.Exceptions.QuestionNotFoundException;
import com.project.model.AplitudeQuestion;

public interface AplitudeQuestionService {

	List<AplitudeQuestion> getAllQuestions();

	AplitudeQuestion getQuestionById(Long id) throws QuestionNotFoundException;

	String createQuestion(AplitudeQuestion question);

	String updateQuestion(AplitudeQuestion question);

	String deleteQuestion(Long id) throws QuestionNotFoundException;
}
