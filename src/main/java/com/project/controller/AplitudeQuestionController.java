package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Exceptions.QuestionNotFoundException;
import com.project.model.AplitudeQuestion;
import com.project.service.AplitudeQuestionService;

@RestController
@RequestMapping("/Aplitude")
public class AplitudeQuestionController {

	@Autowired
	AplitudeQuestionService aplitudeQuestionService;

	@GetMapping("getallquestions")
	public ResponseEntity<List<AplitudeQuestion>> getAllQuestions() {
		List<AplitudeQuestion> allQuestions = aplitudeQuestionService.getAllQuestions();
		return new ResponseEntity<List<AplitudeQuestion>>(allQuestions, HttpStatus.OK);
	}

	@GetMapping("/getquestionbyid/{id}")
	public ResponseEntity<AplitudeQuestion> getQuestionById(@PathVariable Long id) throws QuestionNotFoundException {
		AplitudeQuestion questionById = aplitudeQuestionService.getQuestionById(id);
		return new ResponseEntity<AplitudeQuestion>(questionById, HttpStatus.OK);
	}

	@PostMapping("/createquestion")
	public ResponseEntity<String> createQuestion(@RequestBody AplitudeQuestion question) {
		String createQuestion = aplitudeQuestionService.createQuestion(question);
		return new ResponseEntity<String>(createQuestion, HttpStatus.CREATED);
	}

	@PostMapping("/updatequestion")
	public ResponseEntity<String> updateQuestion(AplitudeQuestion question) {
		String createQuestion = aplitudeQuestionService.createQuestion(question);
		return new ResponseEntity<String>(createQuestion, HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteQuestion(Long id) throws QuestionNotFoundException {
		String deleteQuestion = aplitudeQuestionService.deleteQuestion(id);
		return new ResponseEntity<String>(deleteQuestion, HttpStatus.OK);
	}

}
