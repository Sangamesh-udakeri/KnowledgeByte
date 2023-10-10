package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Exceptions.QuestionNotFoundException;
import com.project.Repository.AplitudeQuestionRepository;
import com.project.model.AplitudeQuestion;
@Service
public class AplitudeQuestionServiceImpl implements AplitudeQuestionService {

	@Autowired
	AplitudeQuestionRepository aplitudeQuestionRepository;

	@Override
	public List<AplitudeQuestion> getAllQuestions() {

		return aplitudeQuestionRepository.findAll();
	}

	@Override
	public AplitudeQuestion getQuestionById(Long id) throws QuestionNotFoundException {
		Optional<AplitudeQuestion> findById = aplitudeQuestionRepository.findById(id);
		if (!findById.isPresent()) {
			throw new QuestionNotFoundException("Could not find question with id");
		}

		return findById.get();
	}

	@Override
	public String createQuestion(AplitudeQuestion question) {
		aplitudeQuestionRepository.save(question);
		return "Saved";
	}

	@Override
	public String updateQuestion(AplitudeQuestion question) {
		aplitudeQuestionRepository.save(question);
		return "updated";
	}

	@Override
	public String deleteQuestion(Long id) throws QuestionNotFoundException {
		Optional<AplitudeQuestion> findById = aplitudeQuestionRepository.findById(id);
		if(!findById.isPresent()) {
			throw new QuestionNotFoundException("Could not find question with id");
		}
		aplitudeQuestionRepository.deleteById(id);
		return "deleted";
	}

}
