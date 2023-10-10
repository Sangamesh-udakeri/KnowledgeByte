package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.QuestionNotFoundException;
import com.project.Repository.DbmsQuestionRepository;
import com.project.model.AplitudeQuestion;
import com.project.model.DbmsQuestion;

@Service
public class DbmsQuestionServiceImpl implements DbmsQuestionService {

	@Autowired
	DbmsQuestionRepository dbmsQuestionRepository;

	@Override
	public List<DbmsQuestion> getAllQuestions() {

		return dbmsQuestionRepository.findAll();
	}

	@Override
	public DbmsQuestion getQuestionById(Long id) throws QuestionNotFoundException {
		Optional<DbmsQuestion> findById = dbmsQuestionRepository.findById(id);
		if (!findById.isPresent()) {
			throw new QuestionNotFoundException("Could not find question with id");
		}
		return findById.get();
	}

	@Override
	public String createQuestion(DbmsQuestion question) {
		dbmsQuestionRepository.save(question);
		return "Saved";
	}

	@Override
	public String updateQuestion(DbmsQuestion question) {
		dbmsQuestionRepository.save(question);
		return "updated";
	}

	@Override
	public String deleteQuestion(Long id) throws QuestionNotFoundException {
		Optional<DbmsQuestion> findById = dbmsQuestionRepository.findById(id);
		if (!findById.isPresent()) {
			throw new QuestionNotFoundException("Could not find question with id");
		}
		dbmsQuestionRepository.deleteById(id);
		return "deleted";
	}

}
